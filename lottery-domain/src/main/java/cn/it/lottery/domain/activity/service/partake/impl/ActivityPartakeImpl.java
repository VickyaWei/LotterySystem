package cn.it.lottery.domain.activity.service.partake.impl;

import cn.bugstack.middleware.db.router.strategy.IDBRouterStrategy;
import cn.it.lottery.common.Constants;
import cn.it.lottery.common.Result;
import cn.it.lottery.domain.activity.model.req.PartakeReq;
import cn.it.lottery.domain.activity.model.vo.ActivityBillVO;
import cn.it.lottery.domain.activity.model.vo.DrawOrderVO;
import cn.it.lottery.domain.activity.model.vo.UserTakeActivityVO;
import cn.it.lottery.domain.activity.repository.IUserTakeActivityRepository;
import cn.it.lottery.domain.activity.service.partake.BaseActivityPartake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * @author vickyaa
 * @date 1/5/24
 * @file ActivityPartakeImpl
 */

@Service
public class ActivityPartakeImpl extends BaseActivityPartake {

    private Logger logger = LoggerFactory.getLogger(ActivityPartakeImpl.class);

    @Resource
    private IUserTakeActivityRepository userTakeActivityRepository;

    @Resource
    private TransactionTemplate transactionTemplate;

    @Resource
    private IDBRouterStrategy dbRouter;

    @Override
    protected UserTakeActivityVO queryNoConsumedTakeActivityOrder(Long activityId, String uId) {
        return userTakeActivityRepository.queryNoConsumedTakeActivityOrder(activityId, uId);
    }

    @Override
    protected Result checkActivityBill(PartakeReq partake, ActivityBillVO bill) {
        if (!Constants.ActivityState.DOING.getCode().equals(bill.getState())) {
            logger.warn("The current status of the activity is not available state：{}", bill.getState());
            return Result.buildResult(Constants.ResponseCode.UN_ERROR, "The current status of the activity is not available");
        }

        if (bill.getBeginDateTime().after(partake.getPartakeDate()) || bill.getEndDateTime().before(partake.getPartakeDate())) {
            logger.warn("The activity time range is not available beginDateTime：{} endDateTime：{}", bill.getBeginDateTime(), bill.getEndDateTime());
            return Result.buildResult(Constants.ResponseCode.UN_ERROR, "The activity time range is not available");
        }

        if (bill.getStockSurplusCount() <= 0) {
            logger.warn("The remaining inventory of the activity is not available stockSurplusCount：{}", bill.getStockSurplusCount());
            return Result.buildResult(Constants.ResponseCode.UN_ERROR, "The remaining inventory of the activity is not available");
        }

        if (null != bill.getUserTakeLeftCount() && bill.getUserTakeLeftCount() <= 0) {
            logger.warn("The individual claim count is not available userTakeLeftCount：{}", bill.getUserTakeLeftCount());
            return Result.buildResult(Constants.ResponseCode.UN_ERROR, "The individual claim count is not available");

        }

        //The individual claim count is not available userTakeLeftCount
        return Result.buildSuccessResult();
    }

    @Override
    protected Result subtractionActivityStock(PartakeReq req) {
        int count = activityRepository.subtractionActivityStock(req.getActivityId());
        if (0 == count) {
            logger.error("Failed to deduct inventory for the promotion, activityId：{}", req.getActivityId());
            return Result.buildResult(Constants.ResponseCode.NO_UPDATE);
        }
        return Result.buildSuccessResult();
    }



    @Override
    protected Result grabActivity(PartakeReq partake, ActivityBillVO bill, long takeId) {
        try {
            dbRouter.doRouter(partake.getuId());
            return transactionTemplate.execute(status -> {
                try {

                    //Deducting individual participation count failed
                    int updateCount = userTakeActivityRepository.subtractionLeftCount(bill.getActivityId(), bill.getActivityName(), bill.getTakeCount(), bill.getUserTakeLeftCount(), partake.getuId(), partake.getPartakeDate());
                    if (0 == updateCount) {
                        status.setRollbackOnly();
                        logger.error("Failed to claim the activity; deduction of individual participation count unsuccessful, activityId：{} uId：{}", partake.getActivityId(), partake.getuId());
                        return Result.buildResult(Constants.ResponseCode.NO_UPDATE);
                    }
                    userTakeActivityRepository.takeActivity(bill.getActivityId(), bill.getActivityName(), bill.getTakeCount(), bill.getUserTakeLeftCount(), partake.getuId(), partake.getPartakeDate(), takeId);
                } catch (DuplicateKeyException e) {
                    status.setRollbackOnly();
                    logger.error("Failed to claim the activity; unique index conflict, activityId：{} uId：{}", partake.getActivityId(), partake.getuId(), e);
                    return Result.buildResult(Constants.ResponseCode.INDEX_DUP);
                }
                return Result.buildSuccessResult();
            });
        } finally {
            dbRouter.clear();
        }
    }

    @Override
    public Result recordDrawOrder(DrawOrderVO drawOrder) {
        try {
            dbRouter.doRouter(drawOrder.getuId());
            return transactionTemplate.execute(status -> {
                try {
                    // 锁定活动领取记录
                    int lockCount = userTakeActivityRepository.lockTackActivity(drawOrder.getuId(), drawOrder.getActivityId(), drawOrder.getTakeId());
                    if (0 == lockCount) {
                        status.setRollbackOnly();
                        logger.error("记录中奖单，个人参与活动抽奖已消耗完 activityId：{} uId：{}", drawOrder.getActivityId(), drawOrder.getuId());
                        return Result.buildResult(Constants.ResponseCode.NO_UPDATE);
                    }

                    // 保存抽奖信息
                    userTakeActivityRepository.saveUserStrategyExport(drawOrder);
                } catch (DuplicateKeyException e) {
                    status.setRollbackOnly();
                    logger.error("记录中奖单，唯一索引冲突 activityId：{} uId：{}", drawOrder.getActivityId(), drawOrder.getuId(), e);
                    return Result.buildResult(Constants.ResponseCode.INDEX_DUP);
                }
                return Result.buildSuccessResult();
            });
        } finally {
            dbRouter.clear();
        }
    }
}

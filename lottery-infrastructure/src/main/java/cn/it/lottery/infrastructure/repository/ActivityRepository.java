package cn.it.lottery.infrastructure.repository;import cn.it.lottery.common.Constants;
import cn.it.lottery.domain.activity.model.req.PartakeReq;
import cn.it.lottery.domain.activity.model.vo.*;
import cn.it.lottery.domain.activity.repository.IActivityRepository;
import cn.it.lottery.infrastructure.dao.*;
import cn.it.lottery.infrastructure.po.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author vickyaa
 * @date 1/3/24
 * @file ActivityRepository
 */

@Repository
public class ActivityRepository implements IActivityRepository {

    @Resource
    private IActivityDao activityDao;

    @Resource
    private IAwardDao awardDao;

    @Resource
    private IStrategyDao strategyDao;

    @Resource
    private IStrategyDetailDao strategyDetailDao;

    @Resource
    private IUserTakeActivityCountDao userTakeActivityCountDao;

    @Override
    public void addActivity(ActivityVO activity) {
        Activity req = new Activity();
        BeanUtils.copyProperties(activity, req);
        activityDao.insert(req);
    }

    @Override
    public void addAward(List<AwardVO> awardList) {
        List<Award> req = new ArrayList<>();
        for(AwardVO awardVO : awardList){
            Award award = new Award();
            BeanUtils.copyProperties(awardVO, award);
            req.add(award);
        }
        awardDao.insertList(req);
    }

    @Override
    public void addStrategy(StrategyVO strategy) {
        Strategy req = new Strategy();
        BeanUtils.copyProperties(strategy, req);
        strategyDao.insert(req);
    }

    @Override
    public void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList) {
        List<StrategyDetail> req = new ArrayList<>();
        for(StrategyDetailVO strategyDetailVO : strategyDetailList){
            StrategyDetail strategyDetail = new StrategyDetail();
            BeanUtils.copyProperties(strategyDetailVO, strategyDetail);
            req.add(strategyDetail);
        }
        strategyDetailDao.insertList(req);
    }

    @Override
    public boolean alterStatus(Long activityId, Enum<Constants.ActivityState> beforeState, Enum<Constants.ActivityState> afterState) {
        AlterStateVO alterStateVO = new AlterStateVO(activityId,((Constants.ActivityState) beforeState).getCode(),((Constants.ActivityState) afterState).getCode());
        int count = activityDao.alterState(alterStateVO);
        return 1 == count;
    }

    @Override
    public ActivityBillVO queryActivityBill(PartakeReq req) {
        Activity activity = activityDao.queryActivityById(req.getActivityId());

        UserTakeActivityCount userTakeActivityCountReq = new UserTakeActivityCount();
        userTakeActivityCountReq.setuId(req.getuId());
        userTakeActivityCountReq.setActivityId(req.getActivityId());
        UserTakeActivityCount userTakeActivityCount = userTakeActivityCountDao.queryUserTakeActivityCount(userTakeActivityCountReq);


        ActivityBillVO activityBillVO = new ActivityBillVO();
        if(activity != null){

            activityBillVO.setuId(req.getuId());
            activityBillVO.setActivityId(req.getActivityId());
            activityBillVO.setActivityName(activity.getActivityName());
            activityBillVO.setBeginDateTime(activity.getBeginDateTime());
            activityBillVO.setEndDateTime(activity.getEndDateTime());
            activityBillVO.setTakeCount(activity.getTakeCount());
            activityBillVO.setStockSurplusCount(activity.getStockSurplusCount());
            activityBillVO.setStrategyId(activity.getStrategyId());
            activityBillVO.setState(activity.getState());
            activityBillVO.setUserTakeLeftCount(null == userTakeActivityCount ? null : userTakeActivityCount.getLeftCount());

        }

        return activityBillVO;
    }

    @Override
    public int subtractionActivityStock(Long activityId) {
        return activityDao.subtractionActivityStock(activityId);
    }

}

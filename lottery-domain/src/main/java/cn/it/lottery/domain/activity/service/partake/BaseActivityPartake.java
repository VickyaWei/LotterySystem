package cn.it.lottery.domain.activity.service.partake;

import cn.it.lottery.common.Constants;
import cn.it.lottery.common.Result;
import cn.it.lottery.domain.activity.model.req.PartakeReq;
import cn.it.lottery.domain.activity.model.res.PartakeResult;
import cn.it.lottery.domain.activity.model.vo.ActivityBillVO;
import cn.it.lottery.domain.activity.model.vo.UserTakeActivityVO;
import cn.it.lottery.domain.support.ids.IIdGenerator;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author vickyaa
 * @date 1/5/24
 * @file BaseActivityPartake
 */
public abstract class BaseActivityPartake extends ActivityPartakeSupport implements IActivityPartake {

    @Resource
    private Map<Constants.Ids, IIdGenerator> idGeneratorMap;


    @Override
    public PartakeResult doPartake(PartakeReq req){

        //1. Check whether there are unredeemed activity records for lottery drawing in the user_take_activity table (where state = 0).
        //If a user has claimed an activity but the lottery process failed, the system can directly return the redemption result to continue with the lottery.
        UserTakeActivityVO userTakeActivityVO = this.queryNoConsumedTakeActivityOrder(req.getActivityId(), req.getuId());
        if (null != userTakeActivityVO) {
            return buildPartakeResult(userTakeActivityVO.getStrategyId(), userTakeActivityVO.getTakeId());
        }

        //2. Check the activity bill
        ActivityBillVO activityBillVO = super.queryActivityBill(req);

        //3. Activity Information Validation Handling [Activity Inventory, Status, Dates, Individual Participation Count]
        Result checkResult = this.checkActivityBill(req, activityBillVO);
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(checkResult.getCode())) {
            return new PartakeResult(checkResult.getCode(), checkResult.getInfo());
        }

        //4.Deduct Activity Inventory
        Result subtractionActivityResult = this.subtractionActivityStock(req);
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(subtractionActivityResult.getCode())) {
            return new PartakeResult(subtractionActivityResult.getCode(), subtractionActivityResult.getInfo());
        }

        //5.Insert activity redemption information into the user table for individual users
        Long takeId = idGeneratorMap.get(Constants.Ids.SnowFlake).nextId();
        Result grabResult = this.grabActivity(req, activityBillVO, takeId);
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(grabResult.getCode())) {
            return new PartakeResult(grabResult.getCode(), grabResult.getInfo());
        }

        //Encapsulate Result [Strategy ID returned for further lottery steps completion]
        PartakeResult partakeResult = new PartakeResult(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
        partakeResult.setStrategyId(activityBillVO.getStrategyId());
        return partakeResult;
    }

    private PartakeResult buildPartakeResult(Long strategyId, Long takeId) {
        PartakeResult partakeResult = new PartakeResult(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
        partakeResult.setStrategyId(strategyId);
        partakeResult.setTakeId(takeId);
        return partakeResult;
    }

    protected abstract UserTakeActivityVO queryNoConsumedTakeActivityOrder(Long activityId, String s);

    protected abstract Result checkActivityBill(PartakeReq partake, ActivityBillVO bill);

    protected abstract Result subtractionActivityStock(PartakeReq req);

    protected abstract Result grabActivity(PartakeReq partake, ActivityBillVO bill, long takeId);
}

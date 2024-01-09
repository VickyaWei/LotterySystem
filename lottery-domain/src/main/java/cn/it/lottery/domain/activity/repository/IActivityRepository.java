package cn.it.lottery.domain.activity.repository;

import cn.it.lottery.common.Constants;
import cn.it.lottery.domain.activity.model.req.PartakeReq;
import cn.it.lottery.domain.activity.model.vo.ActivityVO;
import cn.it.lottery.domain.activity.model.vo.AwardVO;
import cn.it.lottery.domain.activity.model.vo.StrategyDetailVO;
import cn.it.lottery.domain.activity.model.vo.StrategyVO;
import cn.it.lottery.domain.activity.model.vo.ActivityBillVO;

import java.util.List;

/**
 * @author vickyaa
 * @date 1/3/24
 * @file IActivityRepository
 */
public interface IActivityRepository {

    void addActivity(ActivityVO activity);

    void addAward(List<AwardVO> awardList);

    void addStrategy(StrategyVO strategy);

    void addStrategyDetailList(List<StrategyDetailVO> strategyDetailList);

    boolean alterStatus(Long activityId, Enum<Constants.ActivityState> beforeState, Enum<Constants.ActivityState> afterState);

    ActivityBillVO queryActivityBill(PartakeReq req);

    int subtractionActivityStock(Long activityId);
}

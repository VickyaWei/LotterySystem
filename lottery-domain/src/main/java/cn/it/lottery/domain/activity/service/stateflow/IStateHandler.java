package cn.it.lottery.domain.activity.service.stateflow;

import cn.it.lottery.common.Constants;
import cn.it.lottery.common.Result;

/**
 * @author vickyaa
 * @date 1/3/24
 * @file IStateHandler
 */
public interface IStateHandler {

    Result arraignment(Long activityId, Enum<Constants.ActivityState> curState);

    Result checkPass(Long activityId, Enum<Constants.ActivityState> curState);

    Result checkRefuse(Long activityId, Enum<Constants.ActivityState> curState);

    Result checkRevoke(Long activityId, Enum<Constants.ActivityState> curState);

    Result close(Long activityId, Enum<Constants.ActivityState> curState);

    Result open(Long activityId, Enum<Constants.ActivityState> curState);

    Result doing(Long activityId, Enum<Constants.ActivityState> curState);

}

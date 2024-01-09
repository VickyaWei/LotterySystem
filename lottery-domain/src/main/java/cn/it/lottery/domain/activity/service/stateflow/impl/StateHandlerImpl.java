package cn.it.lottery.domain.activity.service.stateflow.impl;

import cn.it.lottery.common.Constants;
import cn.it.lottery.common.Result;
import cn.it.lottery.domain.activity.service.stateflow.IStateHandler;
import cn.it.lottery.domain.activity.service.stateflow.StateConfig;
import org.springframework.stereotype.Service;

/**
 * @author vickyaa
 * @date 1/3/24
 * @file StateHandlerImpl
 */

@Service
public class StateHandlerImpl extends StateConfig implements IStateHandler {
    @Override
    public Result arraignment(Long activityId, Enum<Constants.ActivityState> curState) {
        return stateGroup.get(curState).arraignment(activityId, curState);
    }

    @Override
    public Result checkPass(Long activityId, Enum<Constants.ActivityState> curState) {
        return stateGroup.get(curState).checkPass(activityId, curState);
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<Constants.ActivityState> curState) {
        return stateGroup.get(curState).checkRefuse(activityId, curState);
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<Constants.ActivityState> curState) {
        return stateGroup.get(curState).checkRevoke(activityId, curState);
    }

    @Override
    public Result close(Long activityId, Enum<Constants.ActivityState> curState) {
        return stateGroup.get(curState).close(activityId, curState);
    }

    @Override
    public Result open(Long activityId, Enum<Constants.ActivityState> curState) {
        return stateGroup.get(curState).open(activityId, curState);
    }

    @Override
    public Result doing(Long activityId, Enum<Constants.ActivityState> curState) {
        return stateGroup.get(curState).doing(activityId, curState);
    }
}

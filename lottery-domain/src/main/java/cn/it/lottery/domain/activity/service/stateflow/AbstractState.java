package cn.it.lottery.domain.activity.service.stateflow;

import cn.it.lottery.common.Constants;
import cn.it.lottery.common.Result;
import cn.it.lottery.domain.activity.repository.IActivityRepository;

import javax.annotation.Resource;

/**
 * @author vickyaa
 * @date 1/3/24
 * @file AbstractState
 */
public abstract class AbstractState {

    @Resource
    protected IActivityRepository activityRepository;

    public abstract Result arraignment(Long activityId, Enum<Constants.ActivityState> curState);

    public abstract Result checkPass(Long activityId, Enum<Constants.ActivityState> curState);

    public abstract Result checkRefuse(Long activityId, Enum<Constants.ActivityState> curState);

    public abstract Result checkRevoke(Long activityId, Enum<Constants.ActivityState> curState);

    public abstract Result close(Long activityId, Enum<Constants.ActivityState> curState);

    public abstract Result open(Long activityId, Enum<Constants.ActivityState> curState);

    public abstract Result doing(Long activityId, Enum<Constants.ActivityState> curState);
}

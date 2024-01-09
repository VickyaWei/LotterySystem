package cn.it.lottery.domain.activity.service.stateflow.event;

import cn.it.lottery.common.Constants;
import cn.it.lottery.common.Result;
import cn.it.lottery.domain.activity.service.stateflow.AbstractState;
import org.springframework.stereotype.Component;

/**
 * @author vickyaa
 * @date 1/3/24
 * @file PassState
 */

@Component
public class PassState extends AbstractState{
    @Override
    public Result arraignment(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "Cannot Resubmit in Approved State");
    }

    @Override
    public Result checkPass(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "Cannot Reapprove in Approved State");
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.REFUSE);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "Activity Rejection Completed") : Result.buildErrorResult("Failed to update activity status");
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "Audit approval is irreversible (can be rejected first)");
    }

    @Override
    public Result close(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.CLOSE);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "Activity audit closure completed") : Result.buildErrorResult("Activity status change failed");
    }

    @Override
    public Result open(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "Cannot open non-closed activity");
    }

    @Override
    public Result doing(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.DOING);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "Activity modification completed during activity") : Result.buildErrorResult("Activity status change failed");
    }

}

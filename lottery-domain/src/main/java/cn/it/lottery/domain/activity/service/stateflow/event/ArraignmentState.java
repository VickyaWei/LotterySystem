package cn.it.lottery.domain.activity.service.stateflow.event;

import cn.it.lottery.common.Constants;
import cn.it.lottery.common.Result;
import cn.it.lottery.domain.activity.service.stateflow.AbstractState;
import org.springframework.stereotype.Component;

/**
 * @author vickyaa
 * @date 1/3/24
 * @file ArraignmentState
 */

@Component
public class ArraignmentState extends AbstractState {
    @Override
    public Result arraignment(Long activityId, Enum<Constants.ActivityState> curState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "Cannot resubmit in pending approval state" );
    }

    @Override
    public Result checkPass(Long activityId, Enum<Constants.ActivityState> curState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, curState, Constants.ActivityState.PASS);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "Activity Approval Successful") : Result.buildErrorResult("Failed to Update Activity Status");
    }

    @Override
    public Result checkRefuse(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.REFUSE);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "Activity Approval Failure") : Result.buildErrorResult("Failed to Update Activity Status");
    }

    @Override
    public Result checkRevoke(Long activityId, Enum<Constants.ActivityState> currentState) {
        boolean isSuccess = activityRepository.alterStatus(activityId, currentState, Constants.ActivityState.EDIT);
        return isSuccess ? Result.buildResult(Constants.ResponseCode.SUCCESS, "Activity Approval Reverted to Editing") : Result.buildErrorResult("Failed to Update Activity Status");
    }

    @Override
    public Result close(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "Non-refusable activity cannot be closed");
    }

    @Override
    public Result open(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "Cannot Open Non-Closed Activity");
    }

    @Override
    public Result doing(Long activityId, Enum<Constants.ActivityState> currentState) {
        return Result.buildResult(Constants.ResponseCode.UN_ERROR, "Pending Approval Activities Cannot Be Modified While In Progress");
    }
}

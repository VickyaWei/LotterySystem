package cn.it.lottery.application.process.res;

import cn.it.lottery.common.Result;

/**
 * @author vickyaa
 * @date 1/9/24
 * @file RuleQuantificationCrowdResult
 */
public class RuleQuantificationCrowdResult extends Result {

    private Long activityId;

    public RuleQuantificationCrowdResult(String code, String info) {
        super(code, info);
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }
}

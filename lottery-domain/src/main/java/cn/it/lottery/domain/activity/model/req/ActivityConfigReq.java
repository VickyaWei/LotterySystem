package cn.it.lottery.domain.activity.model.req;

import cn.it.lottery.domain.activity.model.aggregates.ActivityConfigRich;
import cn.it.lottery.domain.activity.model.vo.ActivityVO;
import cn.it.lottery.domain.activity.model.vo.AwardVO;
import cn.it.lottery.domain.activity.model.vo.StrategyVO;

import java.util.List;

/**
 * @author vickyaa
 * @date 1/3/24
 * @file ActivityConfigReq
 */
public class ActivityConfigReq {

    private Long activityId;

    private ActivityConfigRich activityConfigRich;

    public ActivityConfigReq() {
    }

    public ActivityConfigReq(Long activityId, ActivityConfigRich activityConfigRich) {
        this.activityId = activityId;
        this.activityConfigRich = activityConfigRich;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public ActivityConfigRich getActivityConfigRich() {
        return activityConfigRich;
    }

    public void setActivityConfigRich(ActivityConfigRich activityConfigRich) {
        this.activityConfigRich = activityConfigRich;
    }
}

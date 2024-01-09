package cn.it.lottery.domain.activity.service.deploy;

import cn.it.lottery.domain.activity.model.req.ActivityConfigReq;

/**
 * @author vickyaa
 * @date 1/3/24
 * @file IActivityPartake
 */
public interface IActivityDeploy {

    void createActivity(ActivityConfigReq req);

    void updateActivity(ActivityConfigReq req);
}

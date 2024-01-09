package cn.it.lottery.rpc.req;

import java.io.Serializable;

/**
 * @author vickyaa
 * @date 1/9/24
 * @file DrawReq
 */
public class DrawReq implements Serializable {

    private String uId;

    private Long activityId;

    public DrawReq() {
    }

    public DrawReq(String uId, Long activityId) {
        this.uId = uId;
        this.activityId = activityId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }
}

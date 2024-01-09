package cn.it.lottery.domain.activity.model.vo;

import java.util.Date;

/**
 * @author vickyaa
 * @date 1/5/24
 * @file ActivityBillVO
 */
public class ActivityBillVO {

    private String uId;

    private Long activityId;

    private String activityName;

    private Date beginDateTime;

    private Date endDateTime;

    private Integer stockSurplusCount;

    private Integer state;

    private Long strategyId;

    private Integer takeCount;

    private Integer userTakeLeftCount;

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

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Date getBeginDateTime() {
        return beginDateTime;
    }

    public void setBeginDateTime(Date beginDateTime) {
        this.beginDateTime = beginDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Integer getStockSurplusCount() {
        return stockSurplusCount;
    }

    public void setStockSurplusCount(Integer stockSurplusCount) {
        this.stockSurplusCount = stockSurplusCount;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Integer getTakeCount() {
        return takeCount;
    }

    public void setTakeCount(Integer takeCount) {
        this.takeCount = takeCount;
    }

    public Integer getUserTakeLeftCount() {
        return userTakeLeftCount;
    }

    public void setUserTakeLeftCount(Integer userTakeLeftCOunt) {
        this.userTakeLeftCount = userTakeLeftCOunt;
    }

    @Override
    public String toString() {
        return "ActivityBillVO{" +
                "uId='" + uId + '\'' +
                ", activityId=" + activityId +
                ", activityName='" + activityName + '\'' +
                ", beginDateTime=" + beginDateTime +
                ", endDateTime=" + endDateTime +
                ", stockSurplusCount=" + stockSurplusCount +
                ", state=" + state +
                ", takeCount=" + takeCount +
                ", userTakeLeftCount=" + userTakeLeftCount +
                '}';
    }
}

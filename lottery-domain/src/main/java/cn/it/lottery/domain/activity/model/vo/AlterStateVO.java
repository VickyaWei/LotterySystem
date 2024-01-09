package cn.it.lottery.domain.activity.model.vo;

/**
 * @author vickyaa
 * @date 1/3/24
 * @file AlterStateVO
 */
public class AlterStateVO {

    private Long activityId;

    private Integer beforeState;

    private Integer afterState;

    public AlterStateVO() {
    }

    public AlterStateVO(Long activityId, Integer beforeState, Integer afterState) {
        this.activityId = activityId;
        this.beforeState = beforeState;
        this.afterState = afterState;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Integer getBeforeState() {
        return beforeState;
    }

    public void setBeforeState(Integer beforeState) {
        this.beforeState = beforeState;
    }

    public Integer getAfterState() {
        return afterState;
    }

    public void setAfterState(Integer afterState) {
        this.afterState = afterState;
    }

    @Override
    public String toString() {
        return "AlterStateVO{" + "activityId=" + activityId + ", beforeState=" + beforeState + ", afterState=" + afterState + '}';
    }
}

package cn.it.lottery.domain.rule.model.vo;

/**
 * @author vickyaa
 * @date 1/5/24
 * @file TreeNodeLineVO
 */
public class TreeNodeLineVO {

    private Long nodeIdFrom;

    private Long nodeIdTo;

    private Integer ruleLimitType;

    private String ruleLimitValue;

    public Long getNodeIdFrom() {
        return nodeIdFrom;
    }

    public void setNodeIdFrom(Long nodeIdFrom) {
        this.nodeIdFrom = nodeIdFrom;
    }

    public Long getNodeIdTo() {
        return nodeIdTo;
    }

    public void setNodeIdTo(Long nodeIdTo) {
        this.nodeIdTo = nodeIdTo;
    }

    public Integer getRuleLimitType() {
        return ruleLimitType;
    }

    public void setRuleLimitType(Integer ruleLimitType) {
        this.ruleLimitType = ruleLimitType;
    }

    public String getRuleLimitValue() {
        return ruleLimitValue;
    }

    public void setRuleLimitValue(String ruleLimitValue) {
        this.ruleLimitValue = ruleLimitValue;
    }

    @Override
    public String toString() {
        return "TreeNodeLineVO{" +
                "nodeIdFrom=" + nodeIdFrom +
                ", nodeIdTo=" + nodeIdTo +
                ", ruleLimitType=" + ruleLimitType +
                ", ruleLimitValue='" + ruleLimitValue + '\'' +
                '}';
    }
}

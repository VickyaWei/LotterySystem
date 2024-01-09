package cn.it.lottery.domain.activity.model.vo;

import java.math.BigDecimal;

/**
 * @author vickyaa
 * @date 1/3/24
 * @file StrategyDetailVO
 */
public class StrategyDetailVO {

    private Long strategyId;

    private String awardId;

    private String awardName;

    private Integer awardCount;

    private Integer awardSurplusCount;

    private BigDecimal awardRate;

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public Integer getAwardCount() {
        return awardCount;
    }

    public void setAwardCount(Integer awardCount) {
        this.awardCount = awardCount;
    }

    public Integer getAwardSurplusCount() {
        return awardSurplusCount;
    }

    public void setAwardSurplusCount(Integer awardSurplusCount) {
        this.awardSurplusCount = awardSurplusCount;
    }

    public BigDecimal getAwardRate() {
        return awardRate;
    }

    public void setAwardRate(BigDecimal awardRate) {
        this.awardRate = awardRate;
    }

    @Override
    public String toString() {
        return "StrategyDetailVO{" +
                "strategyId=" + strategyId +
                ", awardId='" + awardId + '\'' +
                ", awardName='" + awardName + '\'' +
                ", awardCount=" + awardCount +
                ", awardSurplusCount=" + awardSurplusCount +
                ", awardRate=" + awardRate +
                '}';
    }
}

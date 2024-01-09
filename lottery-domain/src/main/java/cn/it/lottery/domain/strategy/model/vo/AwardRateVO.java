package cn.it.lottery.domain.strategy.model.vo;

import java.math.BigDecimal;

/**
 * @author vickyaa
 * @date 12/20/23
 * @file AwardRateInfo
 */
public class AwardRateVO {

    private String awardId;

    private BigDecimal awardRate;

    public AwardRateVO() {
    }

    public AwardRateVO(String awardId, BigDecimal awardRate) {
        this.awardId = awardId;
        this.awardRate = awardRate;
    }

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public BigDecimal getAwardRate() {
        return awardRate;
    }

    public void setAwardRate(BigDecimal awardRate) {
        this.awardRate = awardRate;
    }
}

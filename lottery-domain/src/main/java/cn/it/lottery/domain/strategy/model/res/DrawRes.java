package cn.it.lottery.domain.strategy.model.res;

import cn.it.lottery.domain.strategy.model.vo.DrawAwardVO;

/**
 * @author vickyaa
 * @date 12/20/23
 * @file DrawRes
 */
public class DrawRes {

    private String uId;

    private Long strategyId;

    private Integer drawState;

    private DrawAwardVO drawAwardVO;

    public DrawRes() {
    }

    public DrawRes(String uId, Long strategyId, Integer drawState) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.drawState = drawState;
    }

    public DrawRes(String uId, Long strategyId, Integer drawState, DrawAwardVO drawAwardInfo) {
        this.uId = uId;
        this.strategyId = strategyId;
        this.drawState = drawState;
        this.drawAwardVO = drawAwardInfo;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public Integer getDrawState() {
        return drawState;
    }

    public void setDrawState(Integer drawState) {
        this.drawState = drawState;
    }

    public DrawAwardVO getDrawAwardInfo() {
        return drawAwardVO;
    }

    public void setDrawAwardInfo(DrawAwardVO drawAwardInfo) {
        this.drawAwardVO = drawAwardInfo;
    }
}

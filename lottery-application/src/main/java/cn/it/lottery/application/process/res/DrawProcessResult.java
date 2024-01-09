package cn.it.lottery.application.process.res;

import cn.it.lottery.common.Result;
import cn.it.lottery.domain.strategy.model.vo.DrawAwardVO;
/**
 * @author vickyaa
 * @date 1/5/24
 * @file DrawProcessResult
 */
public class DrawProcessResult extends Result {

    private DrawAwardVO drawAwardVO;


    public DrawProcessResult(String code, String info) {
        super(code, info);
    }

    public DrawProcessResult(String code, String info, DrawAwardVO drawAwardVO) {
        super(code, info);
        this.drawAwardVO = drawAwardVO;
    }

    public DrawAwardVO getDrawAwardVO() {
        return drawAwardVO;
    }

    public void setDrawAwardInfo(DrawAwardVO drawAwardVO) {
        this.drawAwardVO = drawAwardVO;
    }
}

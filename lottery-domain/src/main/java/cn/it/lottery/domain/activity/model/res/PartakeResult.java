package cn.it.lottery.domain.activity.model.res;

import cn.it.lottery.common.Result;

/**
 * @author vickyaa
 * @date 1/5/24
 * @file PartakeResult
 */
public class PartakeResult extends Result {

    private Long strategyId;

    private Long takeId;

    public PartakeResult(String code, String info){
        super(code, info);
    }

    public Long getStrategyId(){
        return strategyId;
    }

    public void  setStrategyId(Long strategyId){
        this.strategyId = strategyId;
    }

    public Long getTakeId() {
        return takeId;
    }

    public void setTakeId(Long takeId) {
        this.takeId = takeId;
    }
}

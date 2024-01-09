package cn.it.lottery.domain.strategy.model.aggregates;

import cn.it.lottery.domain.strategy.model.vo.StrategyBriefVO;
import cn.it.lottery.domain.strategy.model.vo.StrategyDetailBriefVO;


import java.util.List;

/**
 * @author vickyaa
 * @date 12/20/23
 * @file StrategyRich
 */
public class StrategyRich {

    private Long strategyId;

    private StrategyBriefVO strategy;

    private List<StrategyDetailBriefVO> strategyDetailList;

    public StrategyRich() {
    }

    public StrategyRich(Long strategyId, StrategyBriefVO strategy, List<StrategyDetailBriefVO> strategyDetailList) {
        this.strategyId = strategyId;
        this.strategy = strategy;
        this.strategyDetailList = strategyDetailList;
    }

    public Long getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Long strategyId) {
        this.strategyId = strategyId;
    }

    public StrategyBriefVO getStrategy() {
        return strategy;
    }

    public void setStrategy(StrategyBriefVO strategy) {
        this.strategy = strategy;
    }

    public List<StrategyDetailBriefVO> getStrategyDetailList() {
        return strategyDetailList;
    }

    public void setStrategyDetailList(List<StrategyDetailBriefVO> strategyDetailList) {
        this.strategyDetailList = strategyDetailList;
    }
}

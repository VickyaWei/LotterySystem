package cn.it.lottery.domain.strategy.service.draw;

import cn.it.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.it.lottery.domain.strategy.model.vo.AwardBriefVO;
import cn.it.lottery.domain.strategy.repository.IStrategyRepository;


import javax.annotation.Resource;

/**
 * @author vickyaa
 * @date 12/21/23
 * @file DrawStrategySupport
 */
public class DrawStrategySupport extends DrawConfig{

    @Resource
    protected IStrategyRepository strategyRepository;

    // get strategy information
    protected StrategyRich queryStrategyRich(Long strategyId) {
        return strategyRepository.queryStrategyRich(strategyId);
    }

    // get award information
    protected AwardBriefVO queryAwardInfoByAwardId(String awardId){
        return strategyRepository.queryAwardInfo(awardId);
    }
}

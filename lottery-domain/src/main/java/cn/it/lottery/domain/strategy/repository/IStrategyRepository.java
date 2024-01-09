package cn.it.lottery.domain.strategy.repository;

import cn.it.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.it.lottery.domain.strategy.model.vo.AwardBriefVO;


import java.util.List;


/**
 * @author vickyaa
 * @date 12/20/23
 * @file IStrategyRepository
 */
public interface IStrategyRepository {

    StrategyRich queryStrategyRich(Long strategyId);

    AwardBriefVO queryAwardInfo(String awardId);

    List<String> queryNoStockStrategyAwardList(long strategyId);

    boolean deductStock(Long strategyId, String awardId);
}

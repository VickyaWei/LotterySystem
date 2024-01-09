package cn.it.lottery.domain.strategy.service.algorithm;

import cn.it.lottery.domain.strategy.model.vo.AwardRateVO;


import java.util.List;

/**
 * @author vickyaa
 * @date 12/20/23
 * @file IDrawAlgorithm
 */
public interface IDrawAlgorithm {

    // Initialize the rate info
    // 0.2 = 0 ~ 0.2   0.3 = 0.2 ~ 0.5  0.5 = 0.5 ~ 1
    void initRateTuple(Long strategyId, List<AwardRateVO> awardRateInfoList);

    // If the tuple has been initialized
    boolean isExistRateTuple(Long strategyId);

    String randomDraw(Long strategyId, List<String> excludeAwardIds);
}

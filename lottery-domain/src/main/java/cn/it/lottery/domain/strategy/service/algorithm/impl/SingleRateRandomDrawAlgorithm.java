package cn.it.lottery.domain.strategy.service.algorithm.impl;

import cn.it.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.List;

/**
 * @author vickyaa
 * @date 12/20/23
 * @file SingleRateRandomDrawAlgorithm
 */
@Component("singleRateRandomDrawAlgorithm")
public class SingleRateRandomDrawAlgorithm extends BaseAlgorithm {

    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {

        // get tuple
        String[] rateTuple = super.rateTupleMap.get(strategyId);
        assert rateTuple != null;

        // get random index
        int randomVal = this.generateSecureRandomIntCode(100);
        int idx = super.hashIdx(randomVal);

        // return result
        String awardId = rateTuple[idx];

        if (excludeAwardIds.contains(awardId)) {
            return "Not win";
        }

        return awardId;
    }

}
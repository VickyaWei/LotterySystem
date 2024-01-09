package cn.it.lottery.domain.strategy.service.algorithm.impl;

import cn.it.lottery.domain.strategy.model.vo.AwardRateVO;
import cn.it.lottery.domain.strategy.service.algorithm.BaseAlgorithm;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author vickyaa
 * @date 12/20/23
 * @file DefaultRateRandomDrawAlgorithm
 */
@Component("defaultRateRandomDrawAlgorithm")
public class DefaultRateRandomDrawAlgorithm extends BaseAlgorithm {

    @Override
    public String randomDraw(Long strategyId, List<String> excludeAwardIds) {

        BigDecimal differenceDenominator = BigDecimal.ZERO;

        // exclude not in the award list
        List<AwardRateVO> differenceAwardRateList = new ArrayList<>();
        List<AwardRateVO> awardRateIntervalValList = awardRateInfoMap.get(strategyId);
        for (AwardRateVO awardRateInfo : awardRateIntervalValList) {
            String awardId = awardRateInfo.getAwardId();
            if (excludeAwardIds.contains(awardId)) {
                continue;
            }
            differenceAwardRateList.add(awardRateInfo);
            differenceDenominator = differenceDenominator.add(awardRateInfo.getAwardRate());
        }

        // preliminary judgment
        if (differenceAwardRateList.size() == 0) {
            return "";
        }

        if (differenceAwardRateList.size() == 1) {
            return differenceAwardRateList.get(0).getAwardId();
        }

        // get probability
        int randomVal = this.generateSecureRandomIntCode(100);

        // get award
        String awardId = null;
        int cursorVal = 0;
        for (AwardRateVO awardRateInfo : differenceAwardRateList) {
            int rateVal = awardRateInfo.getAwardRate().divide(differenceDenominator, 2, BigDecimal.ROUND_UP).multiply(new BigDecimal(100)).intValue();
            if (randomVal <= (cursorVal + rateVal)) {
                awardId = awardRateInfo.getAwardId();
                break;
            }
            cursorVal += rateVal;
        }

        // return result
        return awardId;
    }

}

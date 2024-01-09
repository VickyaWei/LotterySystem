package cn.it.lottery.domain.strategy.service.algorithm;

import cn.it.lottery.domain.strategy.model.vo.AwardRateVO;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author vickyaa
 * @date 12/20/23
 * @file BaseAlgorithm
 */
public abstract class BaseAlgorithm implements IDrawAlgorithm{

    private final int HASH_INCREMENT = 0x61c88647;

    private final int RATE_TUPLE_LENGTH = 128;

    // strategyId -> rateTuple
    protected Map<Long, String[]> rateTupleMap = new ConcurrentHashMap<>();

    // strategyId -> [awardId->begin、awardId->end]
    protected Map<Long, List<AwardRateVO>> awardRateInfoMap = new ConcurrentHashMap<>();
    @Override
    public void initRateTuple(Long strategyId, List<AwardRateVO> awardRateInfoList) {

        awardRateInfoMap.put(strategyId, awardRateInfoList);

        String[] rateTuple = rateTupleMap.computeIfAbsent(strategyId, k -> new String[RATE_TUPLE_LENGTH]);

        int cursorVal = 0;

        for (AwardRateVO awardRateInfo : awardRateInfoList) {
            int rateVal = awardRateInfo.getAwardRate().multiply(new BigDecimal(100)).intValue();
            for (int i = cursorVal + 1; i <= (rateVal + cursorVal); i++) {
                rateTuple[hashIdx(i)] = awardRateInfo.getAwardId();
            }
            cursorVal += rateVal;
        }
    }

    @Override
    public boolean isExistRateTuple(Long strategyId) {
        return rateTupleMap.containsKey(strategyId);
    }

    protected int hashIdx(int val) {
        int hashCode = val * HASH_INCREMENT + HASH_INCREMENT;
        return hashCode & (RATE_TUPLE_LENGTH - 1);
    }
    protected int generateSecureRandomIntCode(int bound){
        return new SecureRandom().nextInt(bound) + 1;
    }
}

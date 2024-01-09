package cn.it.lottery.domain.strategy.service.draw;

import cn.it.lottery.common.Constants;
import cn.it.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author vickyaa
 * @date 12/20/23
 * @file DrawConfig
 */
public class DrawConfig {

    @Resource
    private IDrawAlgorithm defaultRateRandomDrawAlgorithm;

    @Resource
    private IDrawAlgorithm singleRateRandomDrawAlgorithm;

    protected static Map<Integer, IDrawAlgorithm> drawAlgorithmMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init(){
        drawAlgorithmMap.put(Constants.StrategyMode.DEFAULT.getCode(), defaultRateRandomDrawAlgorithm);
        drawAlgorithmMap.put(Constants.StrategyMode.SINGLE.getCode(), singleRateRandomDrawAlgorithm);
    }
}

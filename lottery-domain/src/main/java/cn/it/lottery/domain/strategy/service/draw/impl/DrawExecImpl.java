package cn.it.lottery.domain.strategy.service.draw.impl;


import cn.it.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import cn.it.lottery.domain.strategy.service.draw.DrawBase;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author vickyaa
 * @date 12/20/23
 * @file DrawExecImpl
 */

@Service("drawExec")
public class DrawExecImpl extends DrawBase {

    private Logger logger = LoggerFactory.getLogger(DrawExecImpl.class);

    @Override
    protected List<String> queryExcludeAwardIds(Long strategyId) {
        List<String> awardList = strategyRepository.queryNoStockStrategyAwardList(strategyId);
        logger.info("Execute lottery strategy. strategyId: {} awardList: {}", strategyId, JSON.toJSONString(awardList));
        return awardList;
    }

    @Override
    protected String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds) {
        String awardId = drawAlgorithm.randomDraw(strategyId, excludeAwardIds);

        if(awardId == null){
            return null;
        }

        boolean isSuccess = strategyRepository.deductStock(strategyId, awardId);

        return isSuccess ? awardId : null;
    }


}

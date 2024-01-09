package cn.it.lottery.domain.strategy.service.draw;

import cn.it.lottery.common.Constants;
import cn.it.lottery.domain.strategy.model.aggregates.StrategyRich;
import cn.it.lottery.domain.strategy.model.req.DrawReq;
import cn.it.lottery.domain.strategy.model.res.DrawRes;
import cn.it.lottery.domain.strategy.model.vo.*;
import cn.it.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vickyaa
 * @date 12/20/23
 * @file DrawBase
 */
public abstract class DrawBase extends DrawStrategySupport implements IDrawExec {
    private Logger logger = LoggerFactory.getLogger(DrawBase.class);

    @Override
    public DrawRes doDrawExec(DrawReq req){

        // 1. Retrieve lottery strategy
        StrategyRich strategyRich = super.queryStrategyRich(req.getStrategyId());
        StrategyBriefVO strategy = strategyRich.getStrategy();

        // 2. Validate whether the lottery strategy has been initialized into memory
        this.checkAndInitRateData(req.getStrategyId(), strategy.getStrategyMode(), strategyRich.getStrategyDetailList());

        // 3. Retrieve a list of entries outside the lottery scope
        List<String> excludeAwardIds = this.queryExcludeAwardIds(req.getStrategyId());

        // 4. Execute lottery algorithm
       String awardId = this.drawAlgorithm(req.getStrategyId(), drawAlgorithmMap.get(strategy.getStrategyMode()), excludeAwardIds);

        // 5. Get the result
        return buildDrawRes(req.getuId(), req.getStrategyId(), awardId, strategy);
    }


    // 3. Retrieve a list of entries outside the lottery scope
    protected abstract List<String> queryExcludeAwardIds(Long strategyId);


    // 4. Execute lottery algorithm
    protected abstract String drawAlgorithm(Long strategyId, IDrawAlgorithm drawAlgorithm, List<String> excludeAwardIds);


    // 2. Validate whether the lottery strategy has been initialized into memory
    private void checkAndInitRateData(Long strategyId, Integer strategyMode, List<StrategyDetailBriefVO> strategyDetailList) {

        IDrawAlgorithm drawAlgorithm = drawAlgorithmMap.get(strategyMode);


        if(drawAlgorithm.isExistRateTuple(strategyId)){
            return;
        }

        List<AwardRateVO> awardRateInfoList = new ArrayList<>();
        for(StrategyDetailBriefVO strategyDetail : strategyDetailList){
            awardRateInfoList.add(new AwardRateVO(strategyDetail.getAwardId(), strategyDetail.getAwardRate()));
        }

        if(!Constants.StrategyMode.SINGLE.getCode().equals(strategyMode)){
            drawAlgorithm.initRateTuple(strategyId, awardRateInfoList);
            return;
        }

        drawAlgorithm.initRateTuple(strategyId, awardRateInfoList);
    }


    // 5. Get the result
    private DrawRes buildDrawRes(String uId, Long strategyId, String awardId, StrategyBriefVO strategy) {
        if(awardId == null){
            logger.info("Lottery completed, result is not win. User Id: {} Strategy Id: {}", uId, strategyId);
            return new DrawRes(uId, strategyId, Constants.DrawState.FAIL.getCode());
        }

        AwardBriefVO award = super.queryAwardInfoByAwardId(awardId);
        DrawAwardVO drawAwardVO = new DrawAwardVO(award.getAwardId(), award.getAwardType(), award.getAwardName(), award.getAwardContent());
        drawAwardVO.setStrategyMode(strategy.getStrategyMode());
        drawAwardVO.setGrantType(strategy.getGrantType());
        drawAwardVO.setGrantDate(strategy.getGrantDate());
        logger.info("Lottery completed, result is win. User Id: {} Strategy Id: {}, award Id: {}, award Name: {}", uId, strategyId, awardId, award.getAwardName());

        return new DrawRes(uId, strategyId, Constants.DrawState.SUCCESS.getCode(), drawAwardVO);
    }
}

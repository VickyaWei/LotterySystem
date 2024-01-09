package cn.it.lottery.application.process.impl;

import cn.it.lottery.application.process.IActivityProcess;
import cn.it.lottery.application.process.req.DrawProcessReq;
import cn.it.lottery.application.process.res.DrawProcessResult;
import cn.it.lottery.application.process.res.RuleQuantificationCrowdResult;
import cn.it.lottery.common.Constants;
import cn.it.lottery.domain.activity.model.req.PartakeReq;
import cn.it.lottery.domain.activity.model.res.PartakeResult;
import cn.it.lottery.domain.activity.model.vo.DrawOrderVO;
import cn.it.lottery.domain.activity.service.partake.IActivityPartake;
import cn.it.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.it.lottery.domain.rule.model.res.EngineResult;
import cn.it.lottery.domain.rule.service.engine.EngineFilter;
import cn.it.lottery.domain.strategy.model.req.DrawReq;
import cn.it.lottery.domain.strategy.model.res.DrawRes;
import cn.it.lottery.domain.strategy.model.vo.DrawAwardVO;
import cn.it.lottery.domain.strategy.service.draw.IDrawExec;
import cn.it.lottery.domain.support.ids.IIdGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author vickyaa
 * @date 1/5/24
 * @file ActivityProcessImpl
 */

@Service
public class ActivityProcessImpl implements IActivityProcess {

    @Resource
    private IActivityPartake activityPartake;

    @Resource
    private IDrawExec drawExec;

    @Resource(name = "ruleEngineHandle")
    private EngineFilter engineFilter;

    @Resource
    private Map<Constants.Ids, IIdGenerator> idGeneratorMap;

    @Override
    public DrawProcessResult doDrawProcess(DrawProcessReq req) {
        // 1. 领取活动
        PartakeResult partakeResult = activityPartake.doPartake(new PartakeReq(req.getuId(), req.getActivityId()));
        if (!Constants.ResponseCode.SUCCESS.getCode().equals(partakeResult.getCode())) {
            return new DrawProcessResult(partakeResult.getCode(), partakeResult.getInfo());
        }
        Long strategyId = partakeResult.getStrategyId();
        Long takeId = partakeResult.getTakeId();

        // 2. 执行抽奖
        DrawRes drawResult = drawExec.doDrawExec(new DrawReq(req.getuId(), strategyId, String.valueOf(takeId)));
        if (Constants.DrawState.FAIL.getCode().equals(drawResult.getDrawState())) {
            return new DrawProcessResult(Constants.ResponseCode.LOSING_DRAW.getCode(), Constants.ResponseCode.LOSING_DRAW.getInfo());
        }
        DrawAwardVO drawAwardVO = drawResult.getDrawAwardInfo();

        // 3. 结果落库
        activityPartake.recordDrawOrder(buildDrawOrderVO(req, strategyId, takeId, drawAwardVO));

        // 4. 发送MQ，触发发奖流程

        // 5. 返回结果
        return new DrawProcessResult(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo(), drawAwardVO);
    }

    @Override
    public RuleQuantificationCrowdResult doRuleQuantificationCrowd(DecisionMatterReq req) {
        // 1. 量化决策
        EngineResult engineResult = engineFilter.process(req);

        if (!engineResult.isSuccess()) {
            return new RuleQuantificationCrowdResult(Constants.ResponseCode.RULE_ERR.getCode(),Constants.ResponseCode.RULE_ERR.getInfo());
        }

        // 2. 封装结果
        RuleQuantificationCrowdResult ruleQuantificationCrowdResult = new RuleQuantificationCrowdResult(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
        ruleQuantificationCrowdResult.setActivityId(Long.valueOf(engineResult.getNodeValue()));

        return ruleQuantificationCrowdResult;
    }


    private DrawOrderVO buildDrawOrderVO(DrawProcessReq req, Long strategyId, Long takeId, DrawAwardVO drawAwardVO)  {
        long orderId = idGeneratorMap.get(Constants.Ids.SnowFlake).nextId();
        DrawOrderVO drawOrderVO = new DrawOrderVO();
        drawOrderVO.setuId(req.getuId());
        drawOrderVO.setTakeId(takeId);
        drawOrderVO.setActivityId(req.getActivityId());
        drawOrderVO.setOrderId(orderId);
        drawOrderVO.setStrategyId(strategyId);
        drawOrderVO.setStrategyMode(drawAwardVO.getStrategyMode());
        drawOrderVO.setGrantType(drawAwardVO.getGrantType());
        drawOrderVO.setGrantDate(drawAwardVO.getGrantDate());
        drawOrderVO.setGrantState(Constants.GrantState.INIT.getCode());
        drawOrderVO.setAwardId(drawAwardVO.getAwardId());
        drawOrderVO.setAwardType(drawAwardVO.getAwardType());
        drawOrderVO.setAwardName(drawAwardVO.getAwardName());
        drawOrderVO.setAwardContent(drawAwardVO.getAwardContent());
        return drawOrderVO;
    }
}

package cn.it.lottery.domain.rule.service.engine;

import cn.it.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.it.lottery.domain.rule.model.res.EngineResult;

/**
 * @author vickyaa
 * @date 1/5/24
 * @file EngineFilter
 */
public interface EngineFilter {

    EngineResult process(final DecisionMatterReq matter);
}

package cn.it.lottery.application.process;

import cn.it.lottery.application.process.req.DrawProcessReq;
import cn.it.lottery.application.process.res.DrawProcessResult;
import cn.it.lottery.application.process.res.RuleQuantificationCrowdResult;
import cn.it.lottery.domain.rule.model.req.DecisionMatterReq;

/**
 * @author vickyaa
 * @date 1/5/24
 * @file IActivityProcess
 */
public interface IActivityProcess {

    DrawProcessResult doDrawProcess(DrawProcessReq req);

    RuleQuantificationCrowdResult doRuleQuantificationCrowd(DecisionMatterReq req);
}

package cn.it.lottery.domain.rule.service.engine.impl;

import cn.it.lottery.domain.rule.model.aggregates.TreeRuleRich;
import cn.it.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.it.lottery.domain.rule.model.res.EngineResult;
import cn.it.lottery.domain.rule.model.vo.TreeNodeVO;
import cn.it.lottery.domain.rule.repository.IRuleRepository;
import cn.it.lottery.domain.rule.service.engine.EngineBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author vickyaa
 * @date 1/5/24
 * @file RuleEngineHandle
 */
@Service("ruleEngineHandle")
public class RuleEngineHandle extends EngineBase {

    @Resource
    private IRuleRepository ruleRepository;

    @Override
    public EngineResult process(DecisionMatterReq matter) {

        TreeRuleRich treeRuleRich = ruleRepository.queryTreeRuleRich(matter.getTreeId());
        if (null == treeRuleRich) {
            throw new RuntimeException("Tree Rule is null!");
        }

        TreeNodeVO treeNodeInfo = engineDecisionMaker(treeRuleRich, matter);

        return new EngineResult(matter.getUserId(), treeNodeInfo.getTreeId(), treeNodeInfo.getTreeNodeId(), treeNodeInfo.getNodeValue());
    }

}
package cn.it.lottery.domain.rule.service.engine;

import cn.it.lottery.common.Constants;
import cn.it.lottery.domain.rule.model.aggregates.TreeRuleRich;
import cn.it.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.it.lottery.domain.rule.model.res.EngineResult;
import cn.it.lottery.domain.rule.model.vo.TreeNodeVO;
import cn.it.lottery.domain.rule.model.vo.TreeRootVO;
import cn.it.lottery.domain.rule.service.logic.LogicFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author vickyaa
 * @date 1/5/24
 * @file EngineBase
 */
public abstract class EngineBase extends EngineConfig implements EngineFilter{

    private Logger logger = LoggerFactory.getLogger(EngineBase.class);

    @Override
    public EngineResult process(DecisionMatterReq matter) {
        throw new RuntimeException("Rule Engine Service Not Implemented");
    }

    protected TreeNodeVO engineDecisionMaker(TreeRuleRich treeRuleRich, DecisionMatterReq matter){
        TreeRootVO treeRoot = treeRuleRich.getTreeRoot();
        Map<Long, TreeNodeVO> treeNodeMap = treeRuleRich.getTreeNodeMap();

        Long rootNodeId = treeRoot.getTreeRootNodeId();
        TreeNodeVO treeNodeInfo = treeNodeMap.get(rootNodeId);
        if(treeNodeInfo != null){
            while (Constants.NodeType.STEM.equals(treeNodeInfo.getNodeType())) {
                String ruleKey = treeNodeInfo.getRuleKey();
                LogicFilter logicFilter = logicFilterMap.get(ruleKey);
                String matterValue = logicFilter.matterValue(matter);
                Long nextNode = logicFilter.filter(matterValue, treeNodeInfo.getTreeNodeLineInfoList());
                treeNodeInfo = treeNodeMap.get(nextNode);
                logger.info("Rule tree engine =>{} userId：{} treeId：{} treeNode：{} ruleKey：{} matterValue：{}", treeRoot.getTreeName(), matter.getUserId(), matter.getTreeId(), treeNodeInfo.getTreeNodeId(), ruleKey, matterValue);
            }
        }


        return treeNodeInfo;
    }
}

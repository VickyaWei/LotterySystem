package cn.it.lottery.domain.rule.service.logic;

import cn.it.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.it.lottery.domain.rule.model.vo.TreeNodeLineVO;

import java.util.List;

/**
 * @author vickyaa
 * @date 1/5/24
 * @file LogicFilter
 */
public interface LogicFilter {

    Long filter(String matterValue, List<TreeNodeLineVO> treeNodeLineInfoList);

    String matterValue(DecisionMatterReq decisionMatter);
}

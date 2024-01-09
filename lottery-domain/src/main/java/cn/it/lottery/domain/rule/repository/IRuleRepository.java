package cn.it.lottery.domain.rule.repository;

import cn.it.lottery.domain.rule.model.aggregates.TreeRuleRich;

/**
 * @author vickyaa
 * @date 1/5/24
 * @file IRuleRepository
 */
public interface IRuleRepository {

    TreeRuleRich queryTreeRuleRich(Long treeId);
}

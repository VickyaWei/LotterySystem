package cn.it.lottery.infrastructure.dao;

import cn.it.lottery.infrastructure.po.RuleTree;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author vickyaa
 * @date 1/5/24
 * @file RuleTreeDao
 */

@Mapper
public interface RuleTreeDao {

    RuleTree queryRuleTreeByTreeId(Long id);

    RuleTree queryTreeSummaryInfo(Long treeId);
}

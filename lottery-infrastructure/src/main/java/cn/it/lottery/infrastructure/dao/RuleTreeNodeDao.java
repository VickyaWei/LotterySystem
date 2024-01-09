package cn.it.lottery.infrastructure.dao;

import cn.it.lottery.infrastructure.po.RuleTreeNode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author vickyaa
 * @date 1/5/24
 * @file RuleTreeNodeDao
 */
@Mapper
public interface RuleTreeNodeDao {

    List<RuleTreeNode> queryRuleTreeNodeList(Long treeId);

    int queryTreeNodeCount(Long treeId);

    List<RuleTreeNode> queryTreeRulePoint(Long treeId);
}

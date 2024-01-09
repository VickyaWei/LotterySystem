package cn.it.lottery.infrastructure.dao;

import cn.it.lottery.infrastructure.po.RuleTreeNodeLine;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author vickyaa
 * @date 1/5/24
 * @file RuleTreeNodeLineDao
 */

@Mapper
public interface RuleTreeNodeLineDao {

    List<RuleTreeNodeLine> queryRuleTreeNodeLineList(RuleTreeNodeLine req);

    int queryTreeNodeLineCount(Long treeId);
}

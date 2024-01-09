package cn.it.lottery.domain.rule.model.aggregates;

import cn.it.lottery.domain.rule.model.vo.TreeNodeVO;
import cn.it.lottery.domain.rule.model.vo.TreeRootVO;

import java.util.Map;

/**
 * @author vickyaa
 * @date 1/5/24
 * @file TreeRuleRich
 */
public class TreeRuleRich {

    private TreeRootVO treeRoot;

    private Map<Long, TreeNodeVO> treeNodeMap;

    public TreeRootVO getTreeRoot() {
        return treeRoot;
    }

    public void setTreeRoot(TreeRootVO treeRoot) {
        this.treeRoot = treeRoot;
    }

    public Map<Long, TreeNodeVO> getTreeNodeMap() {
        return treeNodeMap;
    }

    public void setTreeNodeMap(Map<Long, TreeNodeVO> treeNodeMap) {
        this.treeNodeMap = treeNodeMap;
    }
}

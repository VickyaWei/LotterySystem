package cn.it.lottery.domain.rule.model.req;

import java.util.Map;

/**
 * @author vickyaa
 * @date 1/5/24
 * @file DecisionMatterReq
 */
public class DecisionMatterReq {

    private Long treeId;

    private String userId;

    private Map<String, Object> valMap;

    public DecisionMatterReq() {
    }

    public DecisionMatterReq(Long treeId, String userId, Map<String, Object> valMap) {
        this.treeId = treeId;
        this.userId = userId;
        this.valMap = valMap;
    }

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<String, Object> getValMap() {
        return valMap;
    }

    public void setValMap(Map<String, Object> valMap) {
        this.valMap = valMap;
    }
}

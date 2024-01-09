package cn.it.lottery.domain.rule.service.logic.impl;

import cn.it.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.it.lottery.domain.rule.service.logic.BaseLogic;
import org.springframework.stereotype.Component;

/**
 * @author vickyaa
 * @date 1/5/24
 * @file UserAgeFilter
 */

@Component
public class UserAgeFilter extends BaseLogic {

    @Override
    public String matterValue(DecisionMatterReq decisionMatter) {
        return decisionMatter.getValMap().get("age").toString();
    }
}

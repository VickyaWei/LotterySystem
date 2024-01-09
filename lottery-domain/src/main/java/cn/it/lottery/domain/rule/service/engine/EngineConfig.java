package cn.it.lottery.domain.rule.service.engine;

import cn.it.lottery.domain.rule.service.logic.LogicFilter;
import cn.it.lottery.domain.rule.service.logic.impl.UserAgeFilter;
import cn.it.lottery.domain.rule.service.logic.impl.UserGenderFilter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author vickyaa
 * @date 1/5/24
 * @file EngineConfig
 */
public class EngineConfig {

    protected  static Map<String, LogicFilter> logicFilterMap = new ConcurrentHashMap<>();

    @Resource
    private UserAgeFilter userAgeFilter;

    @Resource
    private UserGenderFilter userGenderFilter;

    @PostConstruct
    public void init(){
        logicFilterMap.put("userAge", userAgeFilter);
        logicFilterMap.put("userGender", userGenderFilter);
    }
}

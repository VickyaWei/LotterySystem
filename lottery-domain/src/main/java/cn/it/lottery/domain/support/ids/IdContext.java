package cn.it.lottery.domain.support.ids;

import cn.it.lottery.common.Constants;
import cn.it.lottery.domain.support.ids.policy.RandomNumeric;
import cn.it.lottery.domain.support.ids.policy.ShortCode;
import cn.it.lottery.domain.support.ids.policy.SnowFlake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author vickyaa
 * @date 1/4/24
 * @file IdContext
 */

@Configuration
public class IdContext {

    @Bean
    public Map<Constants.Ids, IIdGenerator> idGenerator(SnowFlake snowFlake, ShortCode shortCode, RandomNumeric randomNumeric){
        Map<Constants.Ids, IIdGenerator> idGeneratorMap = new ConcurrentHashMap<>();
        idGeneratorMap.put(Constants.Ids.SnowFlake, snowFlake);
        idGeneratorMap.put(Constants.Ids.ShortCode, shortCode);
        idGeneratorMap.put(Constants.Ids.RandomNumeric, randomNumeric);
        return idGeneratorMap;
    }
}

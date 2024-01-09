package cn.it.lottery.domain;


import cn.it.lottery.common.Constants;
import cn.it.lottery.domain.support.ids.IIdGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author vickyaa
 * @date 1/4/24
 * @file SupportTest
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class SupportTest {

    private Logger logger = LoggerFactory.getLogger(SupportTest.class);

    @Resource
    private Map<Constants.Ids, IIdGenerator> idGeneratorMap;

    @Test
    public void test_ids(){
        logger.info("Snow flake strategy，generate ID：{}", idGeneratorMap.get(Constants.Ids.SnowFlake).nextId());
        logger.info("Short code strategy, generate ID：{}", idGeneratorMap.get(Constants.Ids.ShortCode).nextId());
        logger.info("Random numeric strategy，generate ID：{}", idGeneratorMap.get(Constants.Ids.RandomNumeric).nextId());
    }
}

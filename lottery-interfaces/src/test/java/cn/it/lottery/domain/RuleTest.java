package cn.it.lottery.domain;

import cn.it.lottery.domain.rule.model.req.DecisionMatterReq;
import cn.it.lottery.domain.rule.model.res.EngineResult;
import cn.it.lottery.domain.rule.service.engine.EngineFilter;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author vickyaa
 * @date 1/5/24
 * @file RuleTest
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RuleTest {

    private Logger logger = LoggerFactory.getLogger(ActivityTest.class);

    @Resource
    private EngineFilter engineFilter;

    @Test
    public void test_process(){
        DecisionMatterReq req = new DecisionMatterReq();
        req.setTreeId(2110081902L);
        req.setUserId("vicky");
        req.setValMap(new HashMap<String, Object>() {{
            put("gender", "man");
            put("age", "25");
        }});

        EngineResult res = engineFilter.process(req);

        logger.info("Request Parameters:{}", JSON.toJSONString(req));
        logger.info("Test result: {}", JSON.toJSONString(res));
    }
}

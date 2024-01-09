package cn.it.lottery.interfaces;


import cn.it.lottery.rpc.ILotteryActivityBooth;
import cn.it.lottery.rpc.req.DrawReq;
import cn.it.lottery.rpc.req.QuantificationDrawReq;
import cn.it.lottery.rpc.res.DrawRes;
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
 * @date 1/9/24
 * @file LotteryActivityBoothTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LotteryActivityBoothTest {

    private Logger logger = LoggerFactory.getLogger(LotteryActivityBoothTest.class);

    @Resource
    private ILotteryActivityBooth lotteryActivityBooth;

    @Test
    public void test_doDraw() {
        DrawReq drawReq = new DrawReq();
        drawReq.setuId("vicky");
        drawReq.setActivityId(100001L);
        DrawRes drawRes = lotteryActivityBooth.doDraw(drawReq);
        logger.info("Request Parameters：{}", JSON.toJSONString(drawReq));
        logger.info("Test Result：{}", JSON.toJSONString(drawRes));
    }

    @Test
    public void test_doQuantificationDraw() {
        QuantificationDrawReq req = new QuantificationDrawReq();
        req.setuId("xiaofuge");
        req.setTreeId(2110081902L);
        req.setValMap(new HashMap<String, Object>() {{
            put("gender", "man");
            put("age", "18");
        }});

        DrawRes drawRes = lotteryActivityBooth.doQuantificationDraw(req);
        logger.info("Request Parameters：{}", JSON.toJSONString(req));
        logger.info("Test Result：{}", JSON.toJSONString(drawRes));

    }
}

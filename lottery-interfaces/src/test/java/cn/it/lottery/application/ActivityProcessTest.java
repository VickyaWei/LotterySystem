package cn.it.lottery.application;

import cn.it.lottery.application.process.IActivityProcess;
import cn.it.lottery.application.process.req.DrawProcessReq;
import cn.it.lottery.application.process.res.DrawProcessResult;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author vickyaa
 * @date 1/5/24
 * @file ActivityProcessTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivityProcessTest {

    private Logger logger = LoggerFactory.getLogger(ActivityProcessTest.class);
    @Resource
    private IActivityProcess activityProcess;

    @Test
    public void test_doDrawProcess(){
        DrawProcessReq req = new DrawProcessReq();
        req.setuId("vicky");
        req.setActivityId(100013L);
        DrawProcessResult drawProcessResult = activityProcess.doDrawProcess(req);

        logger.info("Request Parameters: {}", JSON.toJSONString(req));
        logger.info("Test result：{}", JSON.toJSONString(drawProcessResult));
    }

}

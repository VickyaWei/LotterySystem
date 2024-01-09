package cn.it.lottery;

import cn.it.lottery.infrastructure.dao.IActivityDao;
import cn.it.lottery.infrastructure.po.Activity;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author vickyaa
 * @date 12/19/23
 * @file ApiTest
 */

/*
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LotteryApplication.class)
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    private IActivityBooth activityBooth;

    @Resource
    private IActivityDao activityDao;

    @Test
    public void test_insert(){
        Activity activity = new Activity();
        activity.setActivityId(100001L);
        activity.setActivityName("vicky");
        activity.setActivityDesc("Just for test");
        activity.setBeginDateTime(new Date());
        activity.setEndDateTime(new Date());
        activity.setStockCount(100);
        activity.setStockSurplusCount(99);
        activity.setTakeCount(10);
        activity.setStrategyId(1001L);
        activity.setState(0);
        activity.setCreator("vicky");
        activityDao.insert(activity);
        logger.info("Result is: {}", JSON.toJSONString(activity));
    }

    @Test
    public void test_select(){
        Activity activity = activityDao.queryActivityById(100002L);
        logger.info("Result is: {}", JSON.toJSONString(activity));
    }
}


 */

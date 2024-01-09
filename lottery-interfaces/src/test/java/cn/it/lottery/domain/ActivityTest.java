package cn.it.lottery.domain;

import cn.it.lottery.common.Constants;
import cn.it.lottery.domain.activity.model.aggregates.ActivityConfigRich;
import cn.it.lottery.domain.activity.model.req.ActivityConfigReq;
import cn.it.lottery.domain.activity.model.req.PartakeReq;
import cn.it.lottery.domain.activity.model.res.PartakeResult;
import cn.it.lottery.domain.activity.model.vo.ActivityVO;
import cn.it.lottery.domain.activity.model.vo.AwardVO;
import cn.it.lottery.domain.activity.model.vo.StrategyDetailVO;
import cn.it.lottery.domain.activity.model.vo.StrategyVO;
import cn.it.lottery.domain.activity.service.deploy.IActivityDeploy;
import cn.it.lottery.domain.activity.service.partake.IActivityPartake;
import cn.it.lottery.domain.activity.service.stateflow.IStateHandler;
import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author vickyaa
 * @date 1/4/24
 * @file ActivityTest
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActivityTest {

    private Logger logger = LoggerFactory.getLogger(ActivityTest.class);

    @Resource
    private IActivityDeploy activityDeploy;

    @Resource
    private IStateHandler stateHandler;

    @Resource
    private IActivityPartake activityPartake;

    private ActivityConfigRich activityConfigRich;

    private Long activityId = 120981321L;

    @Before
    public void init(){

        ActivityVO activity = new ActivityVO();
        activity.setActivityId(activityId);
        activity.setActivityName("Test Activity");
        activity.setActivityDesc("Tset Activity Description");
        activity.setBeginDateTime(new Date());
        activity.setEndDateTime(new Date());
        activity.setStockCount(100);
        activity.setTakeCount(10);
        activity.setState(Constants.ActivityState.EDIT.getCode());
        activity.setCreator("vicky");

        StrategyVO strategy = new StrategyVO();
        strategy.setStrategyId(1000012L);
        strategy.setStrategyDesc("Lottery strategy");
        strategy.setStrategyMode(Constants.StrategyMode.SINGLE.getCode());
        strategy.setGrantType(1);
        strategy.setGrantDate(new Date());
        strategy.setExtInfo("");

        StrategyDetailVO strategyDetail_01 = new StrategyDetailVO();
        strategyDetail_01.setStrategyId(strategy.getStrategyId());
        strategyDetail_01.setAwardId("101");
        strategyDetail_01.setAwardName("First prize");
        strategyDetail_01.setAwardCount(10);
        strategyDetail_01.setAwardSurplusCount(10);
        strategyDetail_01.setAwardRate(new BigDecimal("0.05"));

        StrategyDetailVO strategyDetail_02 = new StrategyDetailVO();
        strategyDetail_02.setStrategyId(strategy.getStrategyId());
        strategyDetail_02.setAwardId("102");
        strategyDetail_02.setAwardName("Second prize");
        strategyDetail_02.setAwardCount(20);
        strategyDetail_02.setAwardSurplusCount(20);
        strategyDetail_02.setAwardRate(new BigDecimal("0.15"));

        StrategyDetailVO strategyDetail_03 = new StrategyDetailVO();
        strategyDetail_03.setStrategyId(strategy.getStrategyId());
        strategyDetail_03.setAwardId("103");
        strategyDetail_03.setAwardName("Third prize");
        strategyDetail_03.setAwardCount(50);
        strategyDetail_03.setAwardSurplusCount(50);
        strategyDetail_03.setAwardRate(new BigDecimal("0.20"));

        StrategyDetailVO strategyDetail_04 = new StrategyDetailVO();
        strategyDetail_04.setStrategyId(strategy.getStrategyId());
        strategyDetail_04.setAwardId("104");
        strategyDetail_04.setAwardName("Fourth prize");
        strategyDetail_04.setAwardCount(100);
        strategyDetail_04.setAwardSurplusCount(100);
        strategyDetail_04.setAwardRate(new BigDecimal("0.25"));

        StrategyDetailVO strategyDetail_05 = new StrategyDetailVO();
        strategyDetail_05.setStrategyId(strategy.getStrategyId());
        strategyDetail_05.setAwardId("105");
        strategyDetail_05.setAwardName("Fifth prize");
        strategyDetail_05.setAwardCount(500);
        strategyDetail_05.setAwardSurplusCount(500);
        strategyDetail_05.setAwardRate(new BigDecimal("0.35"));

        List<StrategyDetailVO> strategyDetailList = new ArrayList<>();
        strategyDetailList.add(strategyDetail_01);
        strategyDetailList.add(strategyDetail_02);
        strategyDetailList.add(strategyDetail_03);
        strategyDetailList.add(strategyDetail_04);
        strategyDetailList.add(strategyDetail_05);

        strategy.setStrategyDetailList(strategyDetailList);


        AwardVO award_01 = new AwardVO();
        award_01.setAwardId("101");
        award_01.setAwardType(Constants.AwardType.DESC.getCode());
        award_01.setAwardName("Computer");
        award_01.setAwardContent("Please contact vicky");

        AwardVO award_02 = new AwardVO();
        award_02.setAwardId("102");
        award_02.setAwardType(Constants.AwardType.DESC.getCode());
        award_02.setAwardName("iPhone");
        award_02.setAwardContent("Please contact vicky");

        AwardVO award_03 = new AwardVO();
        award_03.setAwardId("103");
        award_03.setAwardType(Constants.AwardType.DESC.getCode());
        award_03.setAwardName("iPad");
        award_03.setAwardContent("Please contact vicky");

        AwardVO award_04 = new AwardVO();
        award_04.setAwardId("104");
        award_04.setAwardType(Constants.AwardType.DESC.getCode());
        award_04.setAwardName("iPod");
        award_04.setAwardContent("Please contact vicky");

        AwardVO award_05 = new AwardVO();
        award_05.setAwardId("105");
        award_05.setAwardType(Constants.AwardType.DESC.getCode());
        award_05.setAwardName("charger");
        award_05.setAwardContent("Please contact vicky");

        List<AwardVO> awardList = new ArrayList<>();
        awardList.add(award_01);
        awardList.add(award_02);
        awardList.add(award_03);
        awardList.add(award_04);
        awardList.add(award_05);

        activityConfigRich = new ActivityConfigRich(activity, strategy, awardList);

        logger.info("activity test is: {}", JSON.toJSONString(activityConfigRich));
    }

    @Test
    public void test_createActivity(){
        activityDeploy.createActivity(new ActivityConfigReq(activityId, activityConfigRich));
    }


    @Test
    public void test_alterState() {
        logger.info("Submit for Review, Testing：{}", JSON.toJSONString(stateHandler.arraignment(100001L, Constants.ActivityState.EDIT)));
        logger.info("Audit Approved, Testing：{}", JSON.toJSONString(stateHandler.checkPass(100001L, Constants.ActivityState.ARRAIGNMENT)));
        logger.info("Run Activity, Testing：{}", JSON.toJSONString(stateHandler.doing(100001L, Constants.ActivityState.PASS)));
        logger.info("Resubmit for Approval, Testing：{}", JSON.toJSONString(stateHandler.checkPass(100001L, Constants.ActivityState.EDIT)));
    }

    @Test
    public void test_activityPartake() {
        PartakeReq req = new PartakeReq("Uhdgdsaw766120d", 100011L);
        PartakeResult res = activityPartake.doPartake(req);
        logger.info("Request Parameters：{}", JSON.toJSONString(req));
        logger.info("Test result：{}", JSON.toJSONString(res));
    }
}

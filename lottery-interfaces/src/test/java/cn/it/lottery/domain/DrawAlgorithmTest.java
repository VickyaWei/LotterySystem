package cn.it.lottery.domain;

import cn.it.lottery.domain.strategy.model.vo.AwardRateVO;
import cn.it.lottery.domain.strategy.service.algorithm.IDrawAlgorithm;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author vickyaa
 * @date 12/21/23
 * @file DrawAlgorithmTest
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class DrawAlgorithmTest {

    @Resource(name = "singleRateRandomDrawAlgorithm")
    private IDrawAlgorithm drawAlgorithm;

    @Before
    public void init() {
        List<AwardRateVO> awardList = new ArrayList<>();
        awardList.add(new AwardRateVO("one: IMac", new BigDecimal(0.05)));
        awardList.add(new AwardRateVO("two: Iphone", new BigDecimal(0.15)));
        awardList.add(new AwardRateVO("three: Ipad", new BigDecimal(0.20)));
        awardList.add(new AwardRateVO("four: Airpods", new BigDecimal(0.25)));
        awardList.add(new AwardRateVO("five: Iphone charger", new BigDecimal(0.35)));

        drawAlgorithm.initRateTuple(100001L, awardList);
    }

    @Test
    public void  test_drawAlgorithm(){
        List<String> excludeAwardIds = new ArrayList<>();
        excludeAwardIds.add("two: Iphone");
        excludeAwardIds.add("four: Airpods");

        for(int i = 0; i < 20; i++){
            System.out.println("result is: " + drawAlgorithm.randomDraw(100001L, excludeAwardIds));
        }
    }
}

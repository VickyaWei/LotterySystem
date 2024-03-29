package cn.it.lottery;

import cn.it.lottery.common.Constants;
import cn.it.lottery.domain.strategy.model.res.DrawRes;
import org.junit.Test;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author vickyaa
 * @date 1/3/24
 * @file DrawStrategyTest
 */
public class DrawStrategyTest {

    @Test
    public void test_strategy(){
        SecureRandom random = new SecureRandom();
        int rate = random.nextInt(100);

        System.out.println("probability:" + rate);

        List<Map<String, String>> strategyList = new ArrayList<>();

        strategyList.add(new HashMap<String, String>(){{
            put("awardDesc", "first prize: refrigerator");
            put("awardId", "10001");
            put("awardCount", "3");
            put("awardRate", "0.2");
        }});

        strategyList.add(new HashMap<String, String>(){{
            put("awardDesc", "Second prize: iPhone");
            put("awardId", "10002");
            put("awardCount", "5");
            put("awardRate", "0.3");
        }});

        strategyList.add(new HashMap<String, String>(){{
            put("awardDesc", "Third prize: backpack");
            put("awardId", "10003");
            put("awardCount", "10");
            put("awardRate", "0.5");
        }});
    }

    @Test
    public void test_idx(){
        Map<Integer, Integer> map = new HashMap<>();

        int HASH_INCREMENT = 0x61c88647;
        int hashCode = 0;
        for(int i = 1; i <= 100; i++){
            hashCode = i * HASH_INCREMENT + HASH_INCREMENT;
            int idx = hashCode & (128 - 1);

            map.merge(idx, 1, Integer::sum);
            System.out.println("Fibonacci:" + idx + "ordinary scattering: " + (String.valueOf(i).hashCode() & (128 - 1)));
        }

        System.out.println(map);
    }

    @Test
    public void test_DrawStrategy() {

        List<Map<String, String>> strategyList = new ArrayList<>();

        strategyList.add(new HashMap<String, String>() {{
            put("awardDesc", "一等奖：彩电");
            put("awardId", "10001");
            put("awardCount", "3");
            put("awardRate", "20");
        }});

        strategyList.add(new HashMap<String, String>() {{
            put("awardDesc", "二等奖：冰箱");
            put("awardId", "10002");
            put("awardCount", "5");
            put("awardRate", "30");
        }});

        strategyList.add(new HashMap<String, String>() {{
            put("awardDesc", "三等奖：洗衣机");
            put("awardId", "10003");
            put("awardCount", "10");
            put("awardRate", "50");
        }});

        DrawStrategy drawStrategy = new DrawStrategy();
        drawStrategy.initRateTuple(strategyList);

        for (int i = 0; i < 20; i++) {
            System.out.println("中奖结果：" + drawStrategy.randomDraw());
        }
    }

}


class DrawStrategy {

    private final int HASH_INCREMENT = 0x61c88647;

    private String[] rateTuple = new String[128];

    public void initRateTuple(List<Map<String, String>> drawConfig) {
        int cursorVal = 0;
        for (Map<String, String> drawMap : drawConfig) {
            int rateVal = Integer.parseInt(drawMap.get("awardRate"));

            for (int i = cursorVal + 1; i <= (rateVal + cursorVal); i++) {

                int hashCode = i * HASH_INCREMENT + HASH_INCREMENT;
                int idx = hashCode & (rateTuple.length - 1);
                rateTuple[idx] = drawMap.get("awardDesc");
            }

            cursorVal += rateVal;

        }
    }

    public String randomDraw() {

        int rate = new SecureRandom().nextInt(100) + 1;

        int hashCode = rate * HASH_INCREMENT + HASH_INCREMENT;
        int idx = hashCode & (rateTuple.length - 1);
        return rateTuple[idx];
    }

}
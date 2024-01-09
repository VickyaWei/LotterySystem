package cn.it.lottery.domain.award.service.goods;

import cn.it.lottery.domain.award.repository.IAwardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;


/**
 * @author vickyaa
 * @date 1/3/24
 * @file DistributionBase
 */
public class DistributionBase {

    protected Logger logger = LoggerFactory.getLogger(DistributionBase.class);

    @Resource
    private IAwardRepository awardRepository;

    protected void updateUserAwardState(String uId, String orderId, String awardId, Integer awardState, String awardStateInfo){
        logger.info("TODO Prize distribution status for user's individual lottery record with uId:{}", uId);
    }

}

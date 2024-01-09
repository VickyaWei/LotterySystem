package cn.it.lottery.domain.activity.service.deploy.impl;

import cn.it.lottery.domain.activity.model.aggregates.ActivityConfigRich;
import cn.it.lottery.domain.activity.model.req.ActivityConfigReq;
import cn.it.lottery.domain.activity.model.vo.ActivityVO;
import cn.it.lottery.domain.activity.model.vo.AwardVO;
import cn.it.lottery.domain.activity.model.vo.StrategyDetailVO;
import cn.it.lottery.domain.activity.model.vo.StrategyVO;
import cn.it.lottery.domain.activity.repository.IActivityRepository;
import cn.it.lottery.domain.activity.service.deploy.IActivityDeploy;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author vickyaa
 * @date 1/3/24
 * @file ActivityDeployImpl
 */

@Service
public class ActivityDeployImpl implements IActivityDeploy {

    private Logger logger = LoggerFactory.getLogger(ActivityDeployImpl.class);

    @Resource
    private IActivityRepository activityRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createActivity(ActivityConfigReq req) {
        logger.info("Creating Activity Configuration Starts, activityId: {}", req.getActivityId());
        ActivityConfigRich activityConfigRich = req.getActivityConfigRich();
        try{
            ActivityVO activity = activityConfigRich.getActivity();
            activityRepository.addActivity(activity);

            List<AwardVO> awardList = activityConfigRich.getAwardList();
            activityRepository.addAward(awardList);

            StrategyVO strategy = activityConfigRich.getStrategy();
            activityRepository.addStrategy(strategy);

            List<StrategyDetailVO> strategyDetailList = activityConfigRich.getStrategy().getStrategyDetailList();;
            activityRepository.addStrategyDetailList(strategyDetailList);

            logger.info("Creation of Activity Configuration Completed, activityId:{}", req.getActivityId());
        } catch (DuplicateKeyException e){
            logger.error("Failed to Create Activity Configuration, Unique Index Conflict. activityId: {} reqJson: {}", req.getActivityId(), JSON.toJSONString(req), e);
            throw e;
        }
    }

    @Override
    public void updateActivity(ActivityConfigReq req) {
        //TODO
    }
}

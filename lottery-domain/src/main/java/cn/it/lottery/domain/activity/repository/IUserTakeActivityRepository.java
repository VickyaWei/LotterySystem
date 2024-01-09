package cn.it.lottery.domain.activity.repository;

import cn.it.lottery.domain.activity.model.vo.DrawOrderVO;
import cn.it.lottery.domain.activity.model.vo.UserTakeActivityVO;

import java.util.Date;

/**
 * @author vickyaa
 * @date 1/5/24
 * @file IUserTakeActivityRepository
 */
public interface IUserTakeActivityRepository {

    int subtractionLeftCount(Long activityId, String activityName, Integer takeCount, Integer userTakeLeftCount, String uId, Date partakeDate);

    void takeActivity(Long activityId, String activityName, Integer takeCount, Integer userTakeLeftCount, String uId, Date takeDate, Long takeId);

    int lockTackActivity(String uId, Long activityId, Long takeId);

    void saveUserStrategyExport(DrawOrderVO drawOrder);

    UserTakeActivityVO queryNoConsumedTakeActivityOrder(Long activityId, String uId);
}

package cn.it.lottery.infrastructure.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import cn.it.lottery.infrastructure.po.UserTakeActivity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author vickyaa
 * @date 1/5/24
 * @file IUserTakeActivityDao
 */

@Mapper
public interface IUserTakeActivityDao {


    void insert(UserTakeActivity userTakeActivity);

    int lockTackActivity(UserTakeActivity userTakeActivity);

    @DBRouter
    UserTakeActivity queryNoConsumedTakeActivityOrder(UserTakeActivity userTakeActivity);
}

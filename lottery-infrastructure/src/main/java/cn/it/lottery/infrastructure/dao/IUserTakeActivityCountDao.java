package cn.it.lottery.infrastructure.dao;

import cn.bugstack.middleware.db.router.annotation.DBRouter;
import cn.it.lottery.infrastructure.po.UserTakeActivity;
import cn.it.lottery.infrastructure.po.UserTakeActivityCount;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author vickyaa
 * @date 1/5/24
 * @file IUserTakeActivityCountDao
 */

@Mapper
public interface IUserTakeActivityCountDao {

    @DBRouter
    UserTakeActivityCount queryUserTakeActivityCount(UserTakeActivityCount userTakeActivityCountReq);

    void insert(UserTakeActivityCount userTakeActivityCount);

    int updateLeftCount(UserTakeActivityCount userTakeActivityCount);
}

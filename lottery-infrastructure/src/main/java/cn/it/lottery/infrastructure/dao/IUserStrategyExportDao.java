package cn.it.lottery.infrastructure.dao;


import cn.bugstack.middleware.db.router.annotation.DBRouter;
import cn.bugstack.middleware.db.router.annotation.DBRouterStrategy;
import cn.it.lottery.infrastructure.po.UserStrategyExport;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author vickyaa
 * @date 1/5/24
 * @file IUserStrategyExportDao
 */

@Mapper
@DBRouterStrategy(splitTable = true)
public interface IUserStrategyExportDao {

    @DBRouter(key = "uId")
    void insert(UserStrategyExport userStrategyExport);

    @DBRouter
    UserStrategyExport queryUserStrategyExportByUId(String uId);
}

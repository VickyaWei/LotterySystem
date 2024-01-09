package cn.it.lottery.infrastructure.dao;

import cn.it.lottery.infrastructure.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author vickyaa
 * @date 12/20/23
 * @file IStrategyDao
 */

@Mapper
public interface IStrategyDao {

    Strategy queryStrategy(Long strategyId);

    void insert(Strategy req);
}

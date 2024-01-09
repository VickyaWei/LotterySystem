package cn.it.lottery.infrastructure.dao;

import cn.it.lottery.infrastructure.po.StrategyDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author vickyaa
 * @date 12/20/23
 * @file IStrategyDetailDao
 */

@Mapper
public interface IStrategyDetailDao {

    List<StrategyDetail> queryStrategyDetailList(Long strategyId);

    List<String> queryNoStockStrategyAwardList(Long strategyId);

    int deductStock(StrategyDetail strategyDetailreq);

    void insertList(List<StrategyDetail> list);
}

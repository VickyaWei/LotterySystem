package cn.it.lottery.infrastructure.dao;

import cn.it.lottery.infrastructure.po.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * @author vickyaa
 * @date 12/20/23
 * @file IAwardDao
 */

@Mapper
public interface IAwardDao {

    Award queryAwardInfo(String awardId);

    void insertList(List<Award> list);
}

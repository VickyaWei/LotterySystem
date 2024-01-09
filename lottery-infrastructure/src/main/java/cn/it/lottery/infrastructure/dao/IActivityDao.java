package cn.it.lottery.infrastructure.dao;

import cn.it.lottery.domain.activity.model.vo.AlterStateVO;
import cn.it.lottery.infrastructure.po.Activity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author vickyaa
 * @date 12/19/23
 * @file IActivityDao
 */

@Mapper
public interface IActivityDao {

    void insert(Activity req);

    Activity queryActivityById(Long activityId);

    int alterState(AlterStateVO alterStateVO);

    int subtractionActivityStock(Long activityId);
}

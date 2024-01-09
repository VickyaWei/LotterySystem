package cn.it.lottery.domain.activity.service.partake;

import cn.it.lottery.domain.activity.model.req.PartakeReq;
import cn.it.lottery.domain.activity.model.vo.ActivityBillVO;
import cn.it.lottery.domain.activity.repository.IActivityRepository;

import javax.annotation.Resource;

/**
 * @author vickyaa
 * @date 1/5/24
 * @file ActivityPartakeSupport
 */
public class ActivityPartakeSupport {

    @Resource
    protected IActivityRepository activityRepository;

    protected ActivityBillVO queryActivityBill(PartakeReq req){
        return activityRepository.queryActivityBill(req);
    }
}

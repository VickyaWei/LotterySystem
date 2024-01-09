package cn.it.lottery.domain.activity.service.partake;

import cn.it.lottery.common.Result;
import cn.it.lottery.domain.activity.model.req.PartakeReq;
import cn.it.lottery.domain.activity.model.res.PartakeResult;
import cn.it.lottery.domain.activity.model.vo.DrawOrderVO;

/**
 * @author vickyaa
 * @date 1/3/24
 * @file IActivityPartake
 */
public interface IActivityPartake {

    PartakeResult doPartake(PartakeReq req);


    Result recordDrawOrder(DrawOrderVO drawOrder);
}

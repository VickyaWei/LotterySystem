package cn.it.lottery.domain.award.service.goods.impl;

import cn.it.lottery.common.Constants;
import cn.it.lottery.domain.award.model.req.GoodsReq;
import cn.it.lottery.domain.award.model.res.DistributionRes;
import cn.it.lottery.domain.award.service.goods.DistributionBase;
import cn.it.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Component;

/**
 * @author vickyaa
 * @date 1/3/24
 * @file CouponGoods
 */

@Component
public class CouponGoods extends DistributionBase implements IDistributionGoods {
    @Override
    public DistributionRes doDistribution(GoodsReq req) {
        logger.info("Simulate calling the coupon issuance API for uId:{} awardContent:{}", req.getuId(), req.getAwardContent());

        super.updateUserAwardState(req.getuId(), req.getOrderId(), req.getAwardId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());

        return new DistributionRes(req.getuId(), Constants.AwardState.SUCCESS.getCode(), Constants.AwardState.SUCCESS.getInfo());
    }

    @Override
    public Integer getDistributionGoodsName() {
        return Constants.AwardType.COUPONGOODS.getCode();
    }
}

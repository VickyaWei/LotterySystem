package cn.it.lottery.domain.award.service.goods;

import cn.it.lottery.domain.award.model.req.GoodsReq;
import cn.it.lottery.domain.award.model.res.DistributionRes;

/**
 * @author vickyaa
 * @date 1/3/24
 * @file IDistributionGoods
 */
public interface IDistributionGoods {

    DistributionRes doDistribution(GoodsReq req);

    Integer getDistributionGoodsName();
}

package cn.it.lottery.domain.award.service.factory;

import cn.it.lottery.common.Constants;
import cn.it.lottery.domain.award.service.goods.IDistributionGoods;
import cn.it.lottery.domain.award.service.goods.impl.CouponGoods;
import cn.it.lottery.domain.award.service.goods.impl.DescGoods;
import cn.it.lottery.domain.award.service.goods.impl.PhysicalGoods;
import cn.it.lottery.domain.award.service.goods.impl.RedeemCodeGoods;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author vickyaa
 * @date 1/3/24
 * @file GoodsConfig
 */
public class GoodsConfig {

    protected static Map<Integer, IDistributionGoods> goodsMap = new ConcurrentHashMap<>();

    @Resource
    private DescGoods descGoods;

    @Resource
    private CouponGoods couponGoods;

    @Resource
    private PhysicalGoods physicalGoods;

    @Resource
    private RedeemCodeGoods redeemCodeGoods;

    @PostConstruct
    public void init(){
        goodsMap.put(Constants.AwardType.DESC.getCode(), descGoods);
        goodsMap.put(Constants.AwardType.REDEEMCODEGOODS.getCode(), redeemCodeGoods);
        goodsMap.put(Constants.AwardType.COUPONGOODS.getCode(), couponGoods);
        goodsMap.put(Constants.AwardType.PYHSICALGOODS.getCode(), physicalGoods);
    }
}

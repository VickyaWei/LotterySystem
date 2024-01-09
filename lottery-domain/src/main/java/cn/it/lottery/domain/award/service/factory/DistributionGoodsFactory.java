package cn.it.lottery.domain.award.service.factory;

import cn.it.lottery.domain.award.service.goods.IDistributionGoods;
import org.springframework.stereotype.Service;

/**
 * @author vickyaa
 * @date 1/3/24
 * @file DistributionGoodsFactory
 */
@Service
public class DistributionGoodsFactory extends GoodsConfig {

    public IDistributionGoods getDistributionGoodsService(Integer awardType){
        return goodsMap.get(awardType);
    }
}

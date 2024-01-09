package cn.it.lottery.rpc;


import cn.it.lottery.rpc.req.DrawReq;
import cn.it.lottery.rpc.req.QuantificationDrawReq;
import cn.it.lottery.rpc.res.DrawRes;

/**
 * @author vickyaa
 * @date 1/9/24
 * @file ILotteryActivityBooth
 */
public interface ILotteryActivityBooth {

    DrawRes doDraw(DrawReq drawReq);

    DrawRes doQuantificationDraw(QuantificationDrawReq quantificationDrawReq);
}

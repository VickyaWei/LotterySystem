package cn.it.lottery.domain.strategy.service.draw;

import cn.it.lottery.domain.strategy.model.req.DrawReq;
import cn.it.lottery.domain.strategy.model.res.DrawRes;

/**
 * @author vickyaa
 * @date 12/20/23
 * @file IDrawExec
 */
public interface IDrawExec {

    DrawRes doDrawExec(DrawReq req);
}

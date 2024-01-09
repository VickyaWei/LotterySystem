package cn.it.lottery.rpc.res;

import cn.it.lottery.common.Result;
import cn.it.lottery.rpc.dto.AwardDTO;

import java.io.Serializable;

/**
 * @author vickyaa
 * @date 1/9/24
 * @file DrawRes
 */
public class DrawRes extends Result implements Serializable {

    private AwardDTO awardDTO;

    public DrawRes(String code, String info) {
        super(code, info);
    }

    public AwardDTO getAwardDTO() {
        return awardDTO;
    }

    public void setAwardDTO(AwardDTO awardDTO) {
        this.awardDTO = awardDTO;
    }
}

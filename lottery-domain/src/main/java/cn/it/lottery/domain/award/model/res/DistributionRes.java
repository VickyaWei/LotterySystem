package cn.it.lottery.domain.award.model.res;

/**
 * @author vickyaa
 * @date 1/3/24
 * @file DistributionRes
 */
public class DistributionRes {

    private String uId;

    private Integer code;

    private String info;

    private String statementId;

    public DistributionRes() {
    }

    public DistributionRes(String uId, Integer code, String info) {
        this.uId = uId;
        this.code = code;
        this.info = info;
    }

    public DistributionRes(String uId, Integer code, String info, String statementId) {
        this.uId = uId;
        this.code = code;
        this.info = info;
        this.statementId = statementId;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getStatementId() {
        return statementId;
    }

    public void setStatementId(String statementId) {
        this.statementId = statementId;
    }
}

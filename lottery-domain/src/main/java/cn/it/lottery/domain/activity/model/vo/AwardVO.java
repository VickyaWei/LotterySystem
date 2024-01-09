package cn.it.lottery.domain.activity.model.vo;

/**
 * @author vickyaa
 * @date 1/3/24
 * @file AwardVO
 */
public class AwardVO {

    private String awardId;

    private Integer awardType;

    private String awardName;

    private String awardContent;

    public String getAwardId() {
        return awardId;
    }

    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    public Integer getAwardType() {
        return awardType;
    }

    public void setAwardType(Integer awardType) {
        this.awardType = awardType;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }

    public String getAwardContent() {
        return awardContent;
    }

    public void setAwardContent(String awardContent) {
        this.awardContent = awardContent;
    }

    @Override
    public String toString() {
        return "AwardVO{" + "awardId='" + awardId + '\'' + ", awardType=" + awardType + ", awardName='" + awardName + '\'' + ", awardContent='" + awardContent + '\'' + '}';
    }

}

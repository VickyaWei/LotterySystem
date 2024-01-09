package cn.it.lottery.common;

/**
 * @author vickyaa
 * @date 12/19/23
 * @file Constants
 */
public class Constants {

    public enum ResponseCode {
        SUCCESS("0000", "success"),

        UN_ERROR("0001", "unknown error"),
        ILLEGAL_PARAMETER("0002", "illegal parameter"),
        INDEX_DUP("0003", "index conflict"),
        NO_UPDATE("0004", "SQL no update"),
        LOSING_DRAW("D001","not win prize"),
        RULE_ERR("D002", "Quantitative Population Rule Execution Failure");
        private String code;
        private String info;

        ResponseCode(String code, String info) {
            this.code = code;
            this.info = info;
        }

        public String getCode() {
            return code;
        }

        public String getInfo() {
            return info;
        }
    }

    public enum StrategyMode {
        DEFAULT(1, "default probability"),

        SINGLE(2, "single probability");

        private Integer code;

        private String info;

        StrategyMode(Integer code, String info) {
            this.code = code;
            this.info = info;
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
    }

    public enum DrawState{

        FAIL(0, "not win"),

        SUCCESS(1, "win"),

        COVER(2, "last prize");

        private Integer code;

        private String info;

        DrawState(Integer code, String info) {
            this.code = code;
            this.info = info;
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
    }

    public enum AwardState{

        WAIT(0, "Awaiting Prize Distribution"),

        SUCCESS(1, "Prize Distribution Successful"),

        FAILURE(2, "Prize Distribution Failure");

        private Integer code;

        private String info;

        AwardState(Integer code, String info) {
            this.code = code;
            this.info = info;
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
    }

    public enum AwardType {
        DESC(1, "Word Description"),

        REDEEMCODEGOODS(2, "Redeem Code"),

        COUPONGOODS(3, "Coupon goods"),

        PYHSICALGOODS(4, "Physical Prize");

        private Integer code;

        private String info;

        AwardType(Integer code, String info) {
            this.code = code;
            this.info = info;
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
    }

    public enum ActivityState{

        EDIT(1, "Edit"),

        ARRAIGNMENT(2, "Arraignment"),

        REVOKE(3, "Revoke"),

        PASS(4, "Pass"),

        DOING(5, "Doing"),

        REFUSE(6, "Refuse"),

        CLOSE(7, "Close"),

        OPEN(8, "Open");

        private Integer code;

        private String info;

        ActivityState(Integer code, String info) {
            this.code = code;
            this.info = info;
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
    }


    public enum Ids {
        SnowFlake,

        ShortCode,

        RandomNumeric;
    }

    public enum TaskState{
        NO_USED(0, "not used"),
        USED(1, "used");

        private Integer code;

        private String info;

        TaskState() {
        }

        TaskState(Integer code, String info) {
            this.code = code;
            this.info = info;
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
    }

    public enum GrantState{

        INIT(0, "initialized"),
        COMPLETE(1, "completed"),
        FAIL(2, "failed");

        private Integer code;

        private String info;

        GrantState() {
        }

        GrantState(Integer code, String info) {
            this.code = code;
            this.info = info;
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
    }

    public static final class  Global{
        public static final Long TREE_NULL_NODE = 0L;
    }

    public static final class NodeType{
        public static final Integer STEM = 1;

        public static final Integer FRUIT = 2;
    }

    public static final class RuleLimitType{
        public static final int EQUAL = 1;
        public static final int GT = 2;
        public static final int LT = 3;
        public static final int GE = 4;
        public static final int LE = 5;
        public static final int ENUM = 6;
    }
}

package com.dss.girl.enums;

/**
 * 返回结果的枚举：将code和msg对应起来，方便维护
 */
public enum ResultEnum {

    UNKNOW_ERROR(-1,"未知错误"),SUCCESS(0,"成功"),PRIMARY_SCHOOL(100,"你还在上小学"),MIDDLE_SCHOOL(101,"你在上初中"),
    VERIFY_ERROR(1,"表单校验失败");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}

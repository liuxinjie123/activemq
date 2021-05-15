package com.mq.common.dto;

public enum CodeEnu {
    SUCCESS("000000", "成功"),
    ERROR("999999", "失败"),


    ;
    public String code;
    public String desc;
    CodeEnu() {}

    CodeEnu(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}

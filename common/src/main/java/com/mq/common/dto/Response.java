package com.mq.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Response<T> implements Serializable {
    private String code;
    private String desc;
    private T data;

    public Response(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Response(String code, String desc, T data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public static Response success() {
        return new Response().setCode(CodeEnu.SUCCESS.code).setDesc(CodeEnu.SUCCESS.desc);
    }

    public static Response success(Object data) {
        return new Response().setCode(CodeEnu.SUCCESS.code).setDesc(CodeEnu.SUCCESS.desc).setData(data);
    }

    public static Response error(String desc) {
        return new Response().setCode(CodeEnu.ERROR.code).setDesc(desc);
    }

    public static Response error(CodeEnu enu) {
        return new Response().setCode(enu.code).setDesc(enu.desc);
    }

}

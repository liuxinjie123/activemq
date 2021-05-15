package com.mq.common.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class MQObj<T> implements Serializable {
    /**
     * code
     */
    private String code;

    /**
     * msg
     */
    private String msg;

    /**
     * data
     */
    private T data;

}

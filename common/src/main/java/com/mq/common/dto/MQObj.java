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
    private String code = "000000";

    /**
     * msg
     */
    private String msg = "SUCCESS";

    /**
     * data
     */
    private T data;

}

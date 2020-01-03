package com.sandra.msc.common.core.entity;

import lombok.Data;

/**
 * @author sandra
 * @date 2019/9/27
 */
@Data
public class ResponseDto {

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 返回码
     */
    private String code;

    /**
     * 描述信息
     */
    private String message;

    /**
     * 返回结果
     */
    private Object data;

    /**
     * 请求Id
     */
    private String requestId;

    /**
     * 请求路径
     */
    private String path;

}

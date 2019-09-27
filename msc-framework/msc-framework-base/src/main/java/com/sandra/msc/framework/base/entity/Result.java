package com.sandra.msc.framework.base.entity;

import lombok.Data;

/**
 * @author sandra
 * @date 2019/9/27
 */
@Data
public class Result<T> {

    /**
     * 返回码
     */
    private String code = "0000";

    /**
     * 描述信息
     */
    private String msg = "SUCCESS";

    /**
     * 返回结果
     */
    private T data;

}

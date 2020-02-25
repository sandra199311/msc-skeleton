package com.sandra.msc.common.core.exception;

/**
 * 能力调用异常枚举接口
 *
 * @author sandra
 * @date 2019年10月14日
 */
public interface IErrorCode {

    /**
     * 获取异常编码
     *
     * @return 异常编码
     */
    String getCode();

    /**
     * 获取异常信息
     *
     * @return 异常信息
     */
    String getMessage();
}

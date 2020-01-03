package com.sandra.msc.common.core.constant;

import com.sandra.msc.common.core.exception.IErrorCode;

/**
 * 
 * ExceptionEnum
 *
 * @author sandra
 * @date 2019年12月10日
 */
@SuppressWarnings("nls")
public enum ErrorCode implements IErrorCode {

    /**
     * 成功
     */
    SUCCESS("200", "成功"),

    /**
     * 请求错误
     */
    BAD_REQUEST("4000", "bad_request"),
    NOT_FOUND("4004", "not_found"),
    METHOD_NOT_ALLOWED("4005", "method_not_allowed"),
    MEDIA_TYPE_NOT_ACCEPTABLE("4006", "media_type_not_acceptable"),
    TOO_MANY_REQUESTS("4029", "too_many_requests"),

    /**
     * 系统错误
     */
    SERVER_ERROR("5000", "internal_server_error"),
    FEIGN_ERROR("5001", "feign_error"),
    SERVICE_UNAVAILABLE("5003", "service_unavailable"),
    GATEWAY_TIMEOUT("5004", "gateway_timeout"),

    /**
     * 业务异常
     */
    BUSINESS_ERROR("6000", "bussiness_error");

    private String code;

    private String message;

    private ErrorCode(final String code, final String message) {

        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {

        return code;
    }

    public void setCode(final String code) {

        this.code = code;
    }

    @Override
    public String getMessage() {

        return message;
    }

    public void setMessage(final String message) {

        this.message = message;
    }

}

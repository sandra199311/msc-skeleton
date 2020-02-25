package com.sandra.msc.common.core.exception;

/**
 * 
 * BaseException
 *
 * @author sandra
 * @date 2019年12月26日
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String code;

    private String message;

    public BaseException(final IErrorCode errorCode) {

        super();
        code = errorCode.getCode();
        message = errorCode.getMessage();
    }

    public BaseException(final IErrorCode errorCode, final String detailMessage) {

        super();
        code = errorCode.getCode();
        message = errorCode.getMessage() + "(" + detailMessage + ")";
    }

    public BaseException(final IErrorCode errorCode, final Throwable cause) {

        super(cause);
        code = errorCode.getCode();
        message = errorCode.getMessage();
    }

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

    public static long getSerialversionuid() {

        return serialVersionUID;
    }

}

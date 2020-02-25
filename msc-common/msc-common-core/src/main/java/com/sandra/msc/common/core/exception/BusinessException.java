package com.sandra.msc.common.core.exception;

/**
 * 业务异常
 *
 * @author sandra
 * @date 2019年10月11日
 */
public class BusinessException extends BaseException {

    private static final long serialVersionUID = 1410272129693890185L;

    public BusinessException(final IErrorCode errorCode, final String detailMessage) {

        super(errorCode, detailMessage);
    }

    public BusinessException(final IErrorCode exceptionEnum) {

        super(exceptionEnum);
    }

}

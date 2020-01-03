package com.sandra.msc.common.core.exception;

import com.sandra.msc.common.core.constant.ErrorCode;

/**
 * 业务异常
 *
 * @author sandra
 * @date 2019年10月11日
 */
public class BusinessException extends BaseException {

    private static final long serialVersionUID = 1410272129693890185L;

    public BusinessException(final ErrorCode exceptionCode, final String detailMessage) {

        super(exceptionCode, detailMessage);
    }

    public BusinessException(final IErrorCode exceptionEnum) {

        super(exceptionEnum);
    }

}

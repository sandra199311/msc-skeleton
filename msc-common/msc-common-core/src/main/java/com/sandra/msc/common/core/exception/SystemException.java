package com.sandra.msc.common.core.exception;

import com.sandra.msc.common.core.constant.ErrorCode;

/**
 * 系统异常
 *
 * @author sandra
 * @date 2019年10月11日
 */
public class SystemException extends BaseException {

    private static final long serialVersionUID = 467081499617125516L;

    public SystemException(final ErrorCode errorCode, final String detailMessage) {

        super(errorCode, detailMessage);
    }

    public SystemException(final IErrorCode errorCode) {

        super(errorCode);
    }

}

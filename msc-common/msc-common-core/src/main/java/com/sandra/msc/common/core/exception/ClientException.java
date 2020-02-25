package com.sandra.msc.common.core.exception;

/**
 * 
 * 客户端请求错误异常
 *
 * @author sandra
 * @date 2019年12月30日
 */
public class ClientException extends BaseException {

    private static final long serialVersionUID = 7617385935108748873L;

    public ClientException(final IErrorCode errorCode, final String detailMessage) {

        super(errorCode, detailMessage);
    }

    public ClientException(final IErrorCode errorCode) {

        super(errorCode);
    }

}

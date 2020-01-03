package com.sandra.msc.common.core.utils;

import com.sandra.msc.common.core.constant.ErrorCode;
import com.sandra.msc.common.core.entity.ResponseDto;
import com.sandra.msc.common.core.exception.BaseException;

public class ResponseUtil {

    /**
     * 构建成功返回结果
     *
     * @param data
     * @return 返回结果
     */
    public static ResponseDto buildSuccess(final Object data) {

        final ResponseDto response = new ResponseDto();
        response.setSuccess(true);
        response.setCode(ErrorCode.SUCCESS.getCode());
        response.setMessage(ErrorCode.SUCCESS.getMessage());
        response.setData(data);

        return response;
    }

    /**
     * 构建成功返回结果
     * 
     * @return 返回结果
     */
    public static ResponseDto buildFailure(final Exception ex) {

        final ResponseDto response = new ResponseDto();
        response.setSuccess(false);

        if (ex instanceof BaseException) {
            response.setCode(((BaseException) ex).getCode());
            response.setMessage(((BaseException) ex).getMessage());
        } else {
            response.setCode(ErrorCode.SERVER_ERROR.getCode());
            response.setMessage(ErrorCode.SERVER_ERROR.getMessage());
        }

        return response;
    }
}

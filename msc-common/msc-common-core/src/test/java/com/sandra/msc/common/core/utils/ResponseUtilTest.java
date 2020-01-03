package com.sandra.msc.common.core.utils;

import org.junit.Test;

import com.sandra.msc.common.core.constant.ErrorCode;
import com.sandra.msc.common.core.entity.ResponseDto;
import com.sandra.msc.common.core.exception.BusinessException;

public class ResponseUtilTest {

    @Test
    public void test() {

        final BusinessException ex = new BusinessException(ErrorCode.BUSINESS_ERROR);
        final ResponseDto response = ResponseUtil.buildFailure(ex);
        System.out.println(response.getCode());
    }

}

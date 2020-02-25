package com.sandra.msc.common.core.exception;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.sandra.msc.common.core.constant.ErrorCode;

/**
 * 
 * BaseExceptionTest
 *
 * @author sandra
 * @date 2020年1月9日
 */
public class BaseExceptionTest {

    @Test
    public void testGetCause() {

        final BaseException baseException1 = new BaseException(ErrorCode.SERVER_ERROR);
        final BaseException baseException2 = new BaseException(ErrorCode.FEIGN_ERROR, baseException1);

        baseException2.getCause().printStackTrace();
        assertTrue(true);
    }

}

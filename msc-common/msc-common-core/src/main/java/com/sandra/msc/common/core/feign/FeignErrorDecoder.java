package com.sandra.msc.common.core.feign;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;

import com.netflix.hystrix.exception.HystrixBadRequestException;
import com.sandra.msc.common.core.constant.Constant;
import com.sandra.msc.common.core.constant.ErrorCode;
import com.sandra.msc.common.core.exception.SystemException;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

/**
 *
 *
 * FeignErrorDecoder(处理响应码为200~300/404之外的异常返回)
 *
 * @author sandra
 * @date 2019年11月20日
 */
@Configuration
@Slf4j
public class FeignErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(final String methodKey, final Response response) {

        final int status = response.status();
        String body = null;

        try {
            body = Util.toString(response.body().asReader());
        } catch (final IOException e) {
            log.error("读取Feign调用响应结果异常：", e);
        }

        log.error("Feign调用异常," + methodKey + ",响应码:" + status + ",结果:" + body);
        if (response.status() >= Constant.Http.STATUS_CODE_400 && response.status() <= Constant.Http.STATUS_CODE_499) {
            return new HystrixBadRequestException("Feign调用异常，客户端错误:" + methodKey);
        }
        return new SystemException(ErrorCode.FEIGN_ERROR, methodKey);
    }

}
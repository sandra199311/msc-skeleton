package com.sandra.msc.common.autoconfigure.exception;

import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sandra.msc.common.core.constant.ErrorCode;
import com.sandra.msc.common.core.entity.ResponseDto;
import com.sandra.msc.common.core.exception.BusinessException;
import com.sandra.msc.common.core.exception.ClientException;
import com.sandra.msc.common.core.exception.SystemException;
import com.sandra.msc.common.core.utils.ResponseUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * Controller层全局统一异常处理
 *
 * @author sandra
 * @date 2019年10月11日
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler({ MethodArgumentNotValidException.class, BindException.class,
            ServletRequestBindingException.class })
    public ResponseDto paramExceptionHandler(final Exception e) {

        log.error(e.getLocalizedMessage(), e);

        String detailMessage = null;
        if (e instanceof MethodArgumentNotValidException) {
            detailMessage = ((MethodArgumentNotValidException) e).getBindingResult()
                    .getFieldError()
                    .getDefaultMessage();
        } else if (e instanceof BindException) {
            detailMessage = ((BindException) e).getBindingResult().getFieldError().getDefaultMessage();
        } else {
            detailMessage = e.getLocalizedMessage();
        }

        final ClientException ex = new ClientException(ErrorCode.BAD_REQUEST, detailMessage);
        return ResponseUtil.buildFailure(ex);
    }

    @ExceptionHandler({ BusinessException.class })
    public ResponseDto bussinessExceptionHandler(final BusinessException e) {

        log.error(e.getMessage(), e);
        return ResponseUtil.buildFailure(e);
    }

    @ExceptionHandler({ SystemException.class })
    public ResponseDto systemExceptionExceptionHandler(final SystemException e) {

        log.error(e.getMessage(), e);
        return ResponseUtil.buildFailure(e);
    }

    @ExceptionHandler({ Exception.class })
    public ResponseDto exceptionHandler(final Exception e) {

        log.error(e.getLocalizedMessage(), e);
        final SystemException ex = new SystemException(ErrorCode.SERVER_ERROR, e.getLocalizedMessage());
        return ResponseUtil.buildFailure(ex);
    }

}

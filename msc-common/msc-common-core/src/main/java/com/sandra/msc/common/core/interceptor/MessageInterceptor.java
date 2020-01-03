package com.sandra.msc.common.core.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
 * MessageInterceptor
 *
 * @author sandra
 * @date 2019年12月30日
 */
public class MessageInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler)
            throws Exception {

        return true;
    }

    @Override
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler,
                           final ModelAndView modelAndView)
            throws Exception {

    }

}

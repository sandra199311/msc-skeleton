package com.sandra.msc.common.core.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

/**
 * 
 * BusinessContext
 *
 * @author sandra
 * @date 2019年12月26日
 */
public class BusinessContext {

    /**
     * ThreadLocal常量，线程共享
     */
    private static final ThreadLocal<Map<String, String>> THREADLOCAL = new ThreadLocal<>();

    /**
     * ObjectThreadLocal常量，线程共享
     */
    private static final ThreadLocal<Map<String, Object>> OBJTHREADLOCAL = new ThreadLocal<>();

    /**
     * 获取上下文中的值
     *
     * @param key
     * @return 获取的变量值
     */
    public static String getProperty(final String key) {

        if (!StringUtils.isEmpty(key)) {
            final Map<String, String> threadMap = THREADLOCAL.get();
            if (null != threadMap) {
                return threadMap.get(key);
            }
        }
        return null;
    }

    /**
     * 获取上下文中的值(object)
     *
     * @param key
     * @return 获取的变量值
     */
    public static Object getObjProperty(final String key) {

        if (!StringUtils.isEmpty(key)) {
            final Map<String, Object> threadMap = OBJTHREADLOCAL.get();
            if (null != threadMap) {
                return threadMap.get(key);
            }
        }
        return null;
    }

    /**
     * 设置上下文中的值
     *
     * @param key
     * @param value
     */
    public static void setProperty(final String key, final String value) {

        if (!StringUtils.isEmpty(key) && !StringUtils.isEmpty(value)) {
            Map<String, String> threadMap = THREADLOCAL.get();
            if (null == threadMap) {
                threadMap = new HashMap<>(16);
                THREADLOCAL.set(threadMap);
            }
            threadMap.put(key, value);
        }

    }

    /**
     * 设置上下文中的值(object)
     *
     * @param key
     * @param value
     */
    public static void setObjProperty(final String key, final Object obj) {

        if (!StringUtils.isEmpty(key) && !StringUtils.isEmpty(obj)) {
            Map<String, Object> threadMap = OBJTHREADLOCAL.get();
            if (null == threadMap) {
                threadMap = new HashMap<>(16);
                OBJTHREADLOCAL.set(threadMap);
            }
            threadMap.put(key, obj);
        }

    }

    /**
     * 清空上下文中的值
     */
    public static void clear() {

        THREADLOCAL.remove();
        OBJTHREADLOCAL.remove();
    }

}

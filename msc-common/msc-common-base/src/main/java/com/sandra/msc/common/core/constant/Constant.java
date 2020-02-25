package com.sandra.msc.common.core.constant;

/**
 * 
 * 公共常量类(使用内部类区分不同的常量类别)
 *
 * @author sandra
 * @date 2019年12月10日
 */
@SuppressWarnings("nls")
public interface Constant {

    /**
     * 百分号 "%"
     */
    String PERCENT = "%";

    /**
     * swagger文档URI
     */
    String SWAGGER_API_URI = "/v2/api-docs";

    /**
     * http常量信息
     */
    class Http {

        /**
         * 请求协议
         */
        public static String HTTP = "http";

        public static String HTTPS = "https";

        /**
         * 请求方法
         */
        public static String GET = "GET";

        public static String POST = "POST";

        public static String PUT = "PUT";

        public static String DELETE = "DELETE";

        /**
         * http响应码
         */
        public static int STATUS_CODE_300 = 300;

        public static int STATUS_CODE_400 = 400;

        public static int STATUS_CODE_499 = 499;

    }

}

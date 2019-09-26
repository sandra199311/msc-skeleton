package com.sandra.msc.framework.swagger;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author sandra
 * @date 2019/9/26
 */
@Data
@ConfigurationProperties(prefix = "swagger2")
class Swagger2Properties {

    private String basePackage;

    private String title;

    private String description;

    private String version;

    private String apiName;

    private String apiKeyName;

    private String termsOfServiceUrl;

}

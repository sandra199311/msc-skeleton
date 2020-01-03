package com.sandra.msc.common.autoconfigure.swagger;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import lombok.Data;

/**
 * 
 * Swagger2Properties
 *
 * @author sandra
 * @date 2019年12月10日
 */
@Data
@Validated
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

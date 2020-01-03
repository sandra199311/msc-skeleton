package com.sandra.msc.common.autoconfigure.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author sandra
 * @date 2019/9/26
 */
@Configuration
@EnableSwagger2
@EnableConfigurationProperties({ Swagger2Properties.class })
@Profile("!prod")
@ConditionalOnProperty(name = "swagger2.enable", havingValue = "true", matchIfMissing = false)
public class Swagger2Configuration {

    @Autowired
    private Swagger2Properties swagger2Properties;

    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                //                .securitySchemes(Lists.newArrayList(this.apiKey()))
                .select().apis(RequestHandlerSelectors.basePackage(swagger2Properties.getBasePackage()))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder().title(swagger2Properties.getTitle())
                .description(swagger2Properties.getDescription())
                .termsOfServiceUrl(swagger2Properties.getTermsOfServiceUrl()).contact(new Contact("", "", ""))
                .version(swagger2Properties.getVersion()).build();
    }

    private ApiKey apiKey() {

        return new ApiKey(swagger2Properties.getApiName(), swagger2Properties.getApiKeyName(),
                ApiKeyVehicle.HEADER.getValue());
    }

}

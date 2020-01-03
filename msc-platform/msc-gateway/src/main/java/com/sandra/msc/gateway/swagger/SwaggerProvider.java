package com.sandra.msc.gateway.swagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.gateway.config.GatewayProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.support.NameUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * Swagger文档聚合配置
 *
 * @author sandra
 * @date 2019/10/12
 */
@Component
@Primary
@AllArgsConstructor
@SuppressWarnings("nls")
public class SwaggerProvider implements SwaggerResourcesProvider {

    private static final String API_URI = "/v2/api-docs";

    private final RouteLocator routeLocator;

    private final GatewayProperties gatewayProperties;

    @Override
    public List<SwaggerResource> get() {

        final List<SwaggerResource> resources = new ArrayList<>();
        final List<String> routes = new ArrayList<>();
        //取出gateway的rout
        routeLocator.getRoutes().subscribe(route -> routes.add(route.getId()));
        //结合配置的route-路径(Path)，和route过滤，只获取有效的route节点
        gatewayProperties.getRoutes().stream().filter(routeDefinition -> routes.contains(routeDefinition.getId()))
                .forEach(routeDefinition -> routeDefinition.getPredicates().stream()
                        .filter(predicateDefinition -> ("Path").equalsIgnoreCase(predicateDefinition.getName()))
                        .forEach(predicateDefinition -> resources
                                .add(swaggerResource(routeDefinition.getId(), predicateDefinition.getArgs()
                                        .get(NameUtils.GENERATED_NAME_PREFIX + "0").replace("/**", API_URI)))));
        return resources;
    }

    private SwaggerResource swaggerResource(final String name, final String location) {

        final SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion("2.0");
        return swaggerResource;
    }

}

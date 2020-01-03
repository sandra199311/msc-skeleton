package com.sandra.msc.services.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sandra.msc.services.consumer.feign.hystirx.ServiceProviderHystrix;

/**
 * 
 * ServiceProviderClient
 *
 * @author sandra
 * @date 2019年12月11日
 */
@FeignClient(value = "msc-service-provider", fallback = ServiceProviderHystrix.class)
public interface ServiceProviderClient {

    /**
     * hi
     * 
     * @return result
     */
    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String hi();
}

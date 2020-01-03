package com.sandra.msc.services.consumer.feign.hystirx;

import org.springframework.stereotype.Component;

import com.sandra.msc.services.consumer.feign.ServiceProviderClient;

/**
 * 
 * ServiceProviderHystrix
 *
 * @author sandra
 * @date 2019年12月11日
 */
@Component
public class ServiceProviderHystrix implements ServiceProviderClient {

    @Override
    public String hi() {

        return null;
    }

}

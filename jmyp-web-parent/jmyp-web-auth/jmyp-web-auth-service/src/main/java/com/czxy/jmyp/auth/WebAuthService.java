package com.czxy.jmyp.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName WebAuthService
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/13 15:08
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class WebAuthService {
    public static void main(String[] args) {
        SpringApplication.run(WebAuthService.class,args);
    }
}

package com.czxy.jmyp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @ClassName WebGatewayApplication
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/12 9:54
 * @Version 1.0
 **/
@SpringBootApplication
@EnableDiscoveryClient //注册中心客户端(通用写法)，等效 @EnableEurekaClient
@EnableZuulProxy
public class WebGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebGatewayApplication.class,args);
    }
}

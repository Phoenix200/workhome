package com.czxy.jmyp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @ClassName EurekaApplication
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/12 9:07
 * @Version 1.0
 **/

@SpringBootApplication
@EnableEurekaServer
public class WebEurekaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebEurekaServiceApplication.class,args);
    }
}
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
//        eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjYsInVzZXJuYW1lIjoi5byg5Lqa5Y2DIiwiZXhwIjoxNTQ0Njk4NzgzfQ.P9ES4lph9itujSQjVUWn7PmLNTUrpvF5Rk_S9TiSz27nuGKEcF_v6T9CuGEqWi4r80a-X4C2qC9eXWPirzBd83OJSdZH_Pu0m0wePp1HPnchGA7FrYfVjBsJHoI00wqlxD3hhLngphPyVemLVK6PCX62lh4dKYgJcBlnaMTazOU
//        eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjYsInVzZXJuYW1lIjoi5byg5Lqa5Y2DIiwiZXhwIjoxNTQ0Njk4ODI4fQ.hujOoziDkP01ASAT799MigT0uSgohI6_HHUA2yBm-V4JQqQ0TEzt8jTSgIQjh31T_ukXZ9qJfLuqbxvDsa78kV1xy9C8ho5jHhL2-meUEZhTzngE54TArEg9Y19ArNXRwD1AIBfxQolZWt3kyMHIFjc3UhkwKNacXPtYfDeia_A
    }
}

package com.czxy.jmyp.auth.client;

import com.czxy.jmyp.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName UserClient
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/13 16:49
 * @Version 1.0
 **/
@FeignClient(value = "web-service")
public interface UserClient {
    @GetMapping("query")
    ResponseEntity<User> queryUser(@RequestParam("mobile") String mobile,
                                   @RequestParam("password") String password);
}

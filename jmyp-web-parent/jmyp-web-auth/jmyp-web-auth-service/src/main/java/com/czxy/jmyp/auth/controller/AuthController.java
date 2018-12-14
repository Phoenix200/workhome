package com.czxy.jmyp.auth.controller;

import com.czxy.jmyp.auth.service.AuthService;
import com.czxy.jmyp.pojo.User;
import com.czxy.jmyp.vo.BaseResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName AuthController
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/13 16:57
 * @Version 1.0
 **/
@RestController
@RequestMapping
public class AuthController {

    @Resource
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<BaseResult> login(@RequestBody User user){
        //登陆---获得token
        User login = this.authService.login(user.getMobile(), user.getPassword());
        //有token ，返回
        System.out.println(login);
        if(StringUtils.isNotBlank(login.getToken())){
            return ResponseEntity.ok( new BaseResult(0, "登录成功").append("token",login.getToken()).append("name",login.getName()));
        }
        return ResponseEntity.ok( new BaseResult(1 , "登录失败"));
    }
}

package com.czxy.jmyp.controller;

import com.czxy.jmyp.pojo.User;
import com.czxy.jmyp.service.UserService;
import com.czxy.jmyp.vo.BaseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @ClassName UserController
 * @Description 用户方法类
 * @Author 张小仙
 * @Date 2018/12/12 16:03
 * @Version 1.0
 **/
@RestController
@RequestMapping
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 用户注册
     * @param user 输入的注册信息
     * @return  提示
     */
    @PostMapping("/regist")
    public ResponseEntity<BaseResult> regist(@RequestBody User user){
        try{
            //保存
            userService.saveUser(user);
            //提示成功
            return ResponseEntity.ok(new BaseResult(0,"保存成功"));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok(new BaseResult(1,"保存失败"));
        }
    }
    @PostMapping("/sms")
    public ResponseEntity<BaseResult> sms(@RequestBody User user){
        String randomCode  = ""+new Random().nextInt(9999-1000+1)+1000;



        if(true){
            return ResponseEntity.ok(new BaseResult(0,"发送成功"));
        }
        return ResponseEntity.ok(new BaseResult(1,"发送失败"));
    }
    @PostMapping("/login")
    public ResponseEntity<BaseResult> login(@RequestBody User user){
        if(true) {
            return ResponseEntity.ok(new BaseResult(0, "登陆成功"));
        }
        return ResponseEntity.ok(new BaseResult(1,"登陆失败"));
    }

}

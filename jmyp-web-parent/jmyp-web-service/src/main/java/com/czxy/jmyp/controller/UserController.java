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

/**
 * @ClassName UserController
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/12 16:03
 * @Version 1.0
 **/
@RestController
@RequestMapping
public class UserController {
    @Resource
    private UserService userService;

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
}

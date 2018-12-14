package com.czxy.jmyp.controller;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.czxy.jmyp.pojo.User;
import com.czxy.jmyp.service.UserService;
import com.czxy.jmyp.utils.SmsUtil;
import com.czxy.jmyp.vo.BaseResult;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
    @Resource
    private StringRedisTemplate redisTemplate;

    /**
     * 用户注册
     *
     * @param user 输入的注册信息
     * @return 提示
     */
    @PostMapping("/register")
    public ResponseEntity<BaseResult> regist(@RequestBody User user) {
        System.out.println(user);
        try {
            //保存
            userService.saveUser(user);
            //提示成功
            return ResponseEntity.ok(new BaseResult(0, "保存成功"));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.ok(new BaseResult(1, "保存失败"));
        }
    }

    @PostMapping("/sms")
    public ResponseEntity<BaseResult> sms(@RequestBody User user) {
        try {
            //生成4位随机数
            String randomCode = new Random().nextInt(9999 - 1000 + 1) + 1000 + "";
            //存放入Redis中                手机号           验证码        1    小时
            redisTemplate.opsForValue().set(user.getMobile(), randomCode, 1, TimeUnit.HOURS);
            SendSmsResponse sendSmsResponse = SmsUtil.sendSms(user.getMobile(), user.getName(), randomCode, null, "110");
            System.out.println(sendSmsResponse);
            //验证发送是否成功
            if ("OK".equalsIgnoreCase(sendSmsResponse.getCode())) {
                return ResponseEntity.ok(new BaseResult(0, "发送成功"));

            }
            return ResponseEntity.ok(new BaseResult(1, sendSmsResponse.getMessage()));
        } catch (ClientException e) {
            e.printStackTrace();
            return ResponseEntity.ok(new BaseResult(1, "发送失败"));
        }

    }

    @GetMapping("/query")
    public ResponseEntity<User> queryUser(@RequestParam("mobile") String mobile, @RequestParam("password") String password) {

        // 根据用户名查找用户信息
        User user = userService.findByMobile(mobile);
        if (user == null || !user.getPassword().equals(password)) {
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.ok(user);
    }

}

package com.czxy.jmyp.auth.service;

import com.czxy.jmyp.auth.client.UserClient;
import com.czxy.jmyp.auth.config.JwtProperties;
import com.czxy.jmyp.auth.entity.UserInfo;
import com.czxy.jmyp.auth.util.JwtUtils;
import com.czxy.jmyp.pojo.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName AuthService
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/13 16:51
 * @Version 1.0
 **/
@Service
@EnableConfigurationProperties(JwtProperties.class)
public class AuthService {

    @Resource
    private UserClient userClient;

    @Resource
    private JwtProperties jwtProperties;

    /**
     * @param mobile   手机号
     * @param password 密码
     * @return token值
     */
    public User login(String mobile, String password) {
        System.out.println(mobile);
        System.out.println(password);
        User body;
        try {
            //登陆 -查询
            body = userClient.queryUser(mobile, password).getBody();
            System.out.println(body);
            //不为空--生产token
            if (body != null) {
                 body.setToken(JwtUtils.generateToken(new UserInfo(body.getId(), body.getName()), jwtProperties.getPrivateKey(), jwtProperties.getExpire()));
                return body;
            }
            //为空
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //没有登陆成功
        return null;

    }
}

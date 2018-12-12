package com.czxy.jmyp.service;

import com.czxy.jmyp.dao.UserMapper;
import com.czxy.jmyp.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/12 16:01
 * @Version 1.0
 **/
@Service
@Transactional
public class UserService {
    @Resource
    private UserMapper userMapper;

    public void saveUser(User user) {
        userMapper.insert(user);
    }
}

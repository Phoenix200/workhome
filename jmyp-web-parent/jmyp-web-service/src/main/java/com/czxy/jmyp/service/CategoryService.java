package com.czxy.jmyp.service;

import com.czxy.jmyp.dao.CategoryMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName CategoryService
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/17 14:29
 * @Version 1.0
 **/
@Service
@Transactional
public class CategoryService  {

    @Resource
    private CategoryMapper categoryMapper;
}

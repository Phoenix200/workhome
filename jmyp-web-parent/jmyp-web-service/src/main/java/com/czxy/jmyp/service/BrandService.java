package com.czxy.jmyp.service;

import com.czxy.jmyp.dao.BrandMapper;
import com.czxy.jmyp.pojo.Brand;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName BrandService
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/18 10:43
 * @Version 1.0
 **/
@Service
@Transactional
public class BrandService {

    @Resource
    private BrandMapper brandMapper;

    public List<Brand> findAll(Integer catid){
        List<Brand> all = brandMapper.findAll(catid);
        System.out.println(all);
        return brandMapper.findAll(catid);
    }
}

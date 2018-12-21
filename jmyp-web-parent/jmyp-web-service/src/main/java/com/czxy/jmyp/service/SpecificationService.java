package com.czxy.jmyp.service;

import com.czxy.jmyp.dao.SpecificationMapper;
import com.czxy.jmyp.pojo.Specification;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName SpecificationService
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/19 8:45
 * @Version 1.0
 **/
@Service
@Transactional
public class SpecificationService {

    @Resource
    private SpecificationMapper specificationMapper;


    /**
     * 查询指定分类的所有规格
     * @param categoryId 分类id
     * @return 规格对象的集合
     */
    public List<Specification> findSpecificationByCategoryId( Integer categoryId){
        return specificationMapper.findSpecificationByCategoryId(categoryId);
    }
}

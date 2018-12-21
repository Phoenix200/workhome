package com.czxy.jmyp.controller;

import com.czxy.jmyp.pojo.Specification;
import com.czxy.jmyp.service.SpecificationService;
import com.czxy.jmyp.vo.BaseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName SpecificationMapper
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/19 8:49
 * @Version 1.0
 **/
@RestController
@RequestMapping
public class SpecificationController {


    @Resource
    private SpecificationService specificationService;


    @GetMapping("/specifications/{catId}")
    public ResponseEntity<BaseResult> findSpecificationByCategoryId(@PathVariable("catId") Integer categoryId) {
        System.out.println(categoryId);
        List<Specification> specificationByCategoryId = specificationService.findSpecificationByCategoryId(categoryId);
        System.out.println(specificationByCategoryId);
        BaseResult baseResult =new BaseResult(0,"成功").append("data",specificationByCategoryId);
        return ResponseEntity.ok(baseResult);
    }
}
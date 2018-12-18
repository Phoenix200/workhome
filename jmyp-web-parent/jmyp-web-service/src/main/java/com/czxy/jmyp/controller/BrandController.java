package com.czxy.jmyp.controller;

import com.czxy.jmyp.pojo.Brand;
import com.czxy.jmyp.service.BrandService;
import com.czxy.jmyp.vo.BaseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName BrandController
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/18 10:45
 * @Version 1.0
 **/
@RestController
@RequestMapping
public class BrandController {

    @Resource
    private BrandService brandService;

    @GetMapping("/brands/{catid}")
    public ResponseEntity<BaseResult> findAll(@PathVariable("catid") Integer catid){
        System.out.println(catid);
        List<Brand> list =brandService.findAll(catid);
        BaseResult br;
        if(list.size()>0){
            br= new BaseResult(1, "成功").append("data",list);

        }else {
           br = new BaseResult(0, "失败").append("data", null);
        }
        return ResponseEntity.ok(br);

    }
}


package com.czxy.jmyp.controller;

import com.czxy.jmyp.service.SkuService;
import com.czxy.jmyp.vo.ESData;
import com.czxy.jmyp.vo.OneSkuResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName SkuController
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/21 8:22
 * @Version 1.0
 **/
@RestController
@RequestMapping
public class SkuController {

    @Resource
    private SkuService skuService;

    @GetMapping("/esData")
    public ResponseEntity<List<ESData>> findESData(){
        System.out.println("123");
        List<ESData> esData = skuService.findESData();
        System.out.println(esData);
        return ResponseEntity.ok(esData);
    }

    @GetMapping("/goods/{skuId}")
    public ResponseEntity<OneSkuResult> findSkuById(@PathVariable("skuId") Integer skuId){
        System.out.println(skuId);
        return ResponseEntity.ok(skuService.findSkuById(skuId));
    }

}

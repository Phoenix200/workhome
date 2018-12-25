package com.czxy.jmyp.controller;

import com.czxy.jmyp.service.SkuSearchService;

import com.czxy.jmyp.vo.BaseResult;
import com.czxy.jmyp.vo.SearchRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName SkuSearchController
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/21 17:54
 * @Version 1.0
 **/
@RestController
@RequestMapping
public class SkuSearchController {

    @Resource
    private SkuSearchService skuSearchService;

    @PostMapping("/search")
    public ResponseEntity<BaseResult> search(@RequestBody SearchRequest searchRequest) {

        //1 查询
        BaseResult baseResult = this.skuSearchService.search(searchRequest);

        //2 封装
        return ResponseEntity.ok(baseResult);

    }
}

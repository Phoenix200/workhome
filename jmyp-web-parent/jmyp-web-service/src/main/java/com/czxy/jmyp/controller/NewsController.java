package com.czxy.jmyp.controller;

import com.czxy.jmyp.pojo.News;
import com.czxy.jmyp.service.NewsService;
import com.czxy.jmyp.vo.BaseResult;
import com.czxy.jmyp.vo.PageRequest;
import com.github.pagehelper.PageInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName NewsController
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/18 8:38
 * @Version 1.0
 **/
@RestController
@RequestMapping
public class NewsController {

    @Resource
    private NewsService newsService;

    @GetMapping("/news")
    public  ResponseEntity<BaseResult> findAll(PageRequest pageRequest){
//        System.out.println(pageRequest.toString());
        PageInfo<News> pageInfo =newsService.findNewByPage(pageRequest);
        BaseResult baseResult =new BaseResult(0,"成功").append("total",pageInfo.getTotal()).append("data",pageInfo.getList());
        return ResponseEntity.ok(baseResult);
    }
}

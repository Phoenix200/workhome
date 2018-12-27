package com.czxy.jmyp.controller;

import com.czxy.jmyp.service.SkuCommentService;
import com.czxy.jmyp.vo.CommentResult;
import com.czxy.jmyp.vo.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName SkuCommentController
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/25 17:03
 * @Version 1.0
 **/
@RestController
@RequestMapping
public class SkuCommentController {
    @Resource
    private SkuCommentService skuCommentService;

    @GetMapping("/comments/{spuid}")
    public ResponseEntity<Object> findCommentsByPage(@PathVariable("spuid") Integer spuid, PageRequest pageRequest){
        System.out.println(spuid+"==============");
        System.out.println(pageRequest+"================");
        CommentResult comments = skuCommentService.findComments(spuid, pageRequest);
        return ResponseEntity.ok(comments);
    }
}

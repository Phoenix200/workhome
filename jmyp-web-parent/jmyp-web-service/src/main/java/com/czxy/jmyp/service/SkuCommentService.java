package com.czxy.jmyp.service;

import com.czxy.jmyp.dao.ImpressionMapper;
import com.czxy.jmyp.dao.SkuCommentMapper;
import com.czxy.jmyp.vo.CommentResult;
import com.czxy.jmyp.vo.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName SkuCommentService
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/25 17:09
 * @Version 1.0
 **/
@Service
@Transactional
public class SkuCommentService {
    @Resource
    private SkuCommentMapper skuCommentMapper;
    @Resource
    private ImpressionMapper impressionMapper;
    public CommentResult findComments(Integer spuid, PageRequest pageRequest){

        return null;
    }
}

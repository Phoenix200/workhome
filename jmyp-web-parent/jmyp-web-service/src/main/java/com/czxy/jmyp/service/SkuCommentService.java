package com.czxy.jmyp.service;

import com.czxy.jmyp.dao.ImpressionMapper;
import com.czxy.jmyp.dao.SkuCommentMapper;
import com.czxy.jmyp.pojo.Impression;
import com.czxy.jmyp.pojo.SkuComment;
import com.czxy.jmyp.vo.CommentResult;
import com.czxy.jmyp.vo.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        CommentResult commentResult = new CommentResult();

        //查询所有印象
        List<Impression> impressionList = impressionMapper.findImpressionsBySpuid(spuid);
        commentResult.setImpressions(impressionList);
        System.out.println(impressionList);

//        List<SkuComment> commentsBySpuid = skuCommentMapper.findCommentsBySpuid(spuid);
//        System.out.println(commentsBySpuid.get(0));
        // 好评
        Integer goodCount = skuCommentMapper.findCountBySpuId(spuid,0);
        // 中评
        Integer commonCount = skuCommentMapper.findCountBySpuId(spuid,1);
        // 差评
        Integer badCount = skuCommentMapper.findCountBySpuId(spuid,2);
        //总评论
        Integer totalCount = skuCommentMapper.findNumBySpuId(spuid);
        Map<String,Object> ratio = new HashMap<>();
        ratio.put("goods", String.format("%.2f" , goodCount * 100.0 / totalCount ));
        ratio.put("common",String.format("%.2f" , commonCount * 100.0 / totalCount ));
        ratio.put("bad",String.format("%.2f" , badCount * 100.0 / totalCount ));
        commentResult.setRatio( ratio );
        Integer numBySpuId = skuCommentMapper.findNumBySpuId(spuid);
        commentResult.setCommentCount(numBySpuId);
        List<SkuComment> commentsBySpuid = skuCommentMapper.findCommentsBySpuid(spuid);
        commentResult.setComments(commentsBySpuid);
        return commentResult;
    }

}

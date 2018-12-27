package com.czxy.jmyp.vo;

import com.czxy.jmyp.pojo.Impression;
import com.czxy.jmyp.pojo.SkuComment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import java.util.List;
import java.util.Map;

/**
 * @ClassName CommentResult
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/25 17:06
 * @Version 1.0
 **/
@Data
public class CommentResult {
    private List<Impression> impressions;
    private Map<String,Object> ratio;
    @JsonProperty("comment_count")
    private Integer commentCount;
    private List<SkuComment> comments;
}

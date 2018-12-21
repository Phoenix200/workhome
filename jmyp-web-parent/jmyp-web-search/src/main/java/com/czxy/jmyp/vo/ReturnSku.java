package com.czxy.jmyp.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @ClassName ReturnSku
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/21 17:34
 * @Version 1.0
 **/
@Data
public class ReturnSku {

    private Long id;
    @JsonProperty("goods_name")
    private String goodsName;
    private Double price ;
    private String midlogo;
    @JsonProperty("comment_count")
    private Integer commentCount;
}

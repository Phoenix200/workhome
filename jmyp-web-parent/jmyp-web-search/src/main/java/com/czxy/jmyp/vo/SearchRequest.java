package com.czxy.jmyp.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

/**
 * @ClassName SearchRequest
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/21 17:42
 * @Version 1.0
 **/
@Data
public class SearchRequest {
    private String keyword;                 // 关键字搜索，预留
    @JsonProperty("cat_id")
    private Integer catId;                  // 3 级类目
    @JsonProperty("brand_id")
    private Integer brandId;                // 品牌
    @JsonProperty("spec_list")
    private Map<String,String> specList;    // 规格选项列表
    @JsonProperty("min_price")
    private Double minPrice;                //最低价格
    @JsonProperty("max_price")
    private Double maxPrice;                //最高价格
    private Integer limit;                  //限制条数
    private Integer page;                   //当前页
    @JsonProperty("sort_by")
    private String sortBy;                  //排序字段
    @JsonProperty("sort_way")
    private String sortWay;                 //排序方式 asc desc
    @JsonProperty("per_page")
    private Integer perPage;                //每页条数
}

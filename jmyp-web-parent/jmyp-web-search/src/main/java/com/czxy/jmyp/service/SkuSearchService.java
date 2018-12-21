package com.czxy.jmyp.service;

import com.czxy.jmyp.repository.SkuRepository;
import com.czxy.jmyp.vo.BaseResult;
import com.czxy.jmyp.vo.ReturnSku;
import com.czxy.jmyp.vo.SearchRequest;
import com.czxy.jmyp.vo.SearchSku;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SkuSearchService
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/21 17:38
 * @Version 1.0
 **/
@Service
public class SkuSearchService {

    @Resource
    private SkuRepository skuRepository;

    public Object search(SearchRequest req){
        //1. 数据校验如果三级分类为空
        if(req.getCatId()==null){
            return new BaseResult( 1 , "没有数据");
        }

        //2 创建查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();

        //2.1 关键字  三级类目    品牌   规格选项过滤
        //2.1.1  keyword,匹配all
        if(StringUtils.isNotBlank(req.getKeyword())){
            queryBuilder.withQuery(QueryBuilders.matchQuery("all",req.getKeyword()));
        }
        //2.1.2  CatId==3级分类
        if(req.getCatId()!=null){
            queryBuilder.withQuery(QueryBuilders.termQuery("CatId",req.getCatId()));
        }

        //2.1.3 brandId
        if(req.getBrandId()!=null){
            queryBuilder.withQuery(QueryBuilders.termQuery("brandId",req.getBrandId()));
        }

        //2.1.4 过滤条件构建器
        BoolQueryBuilder filterQueryBuilder = QueryBuilders.boolQuery();
        Map<String, String> filter = req.getSpecList();
        if(filter!=null){
            for (Map.Entry<String, String> entry : filter.entrySet()) {
                // 判断是否是数值类型
                String key = entry.getKey();
                // 判断是否是数值类型
                String value = entry.getValue();
                // 字符串类型，进行term查询
                filterQueryBuilder.must(QueryBuilders.termQuery(key, value));
            }

        }

        //2.1.5 添加价格过滤
        if(req.getMinPrice()!=null  &&   req.getMaxPrice()!=null){
            filterQueryBuilder.must(QueryBuilders.rangeQuery("price").gte(req.getMinPrice()).lt(req.getMaxPrice()));
        }
        queryBuilder.withQuery( filterQueryBuilder );


        //3  sortBy:zh 综合  xl 销量  xp 新品  jg   pj 评价
        // 排序
        if (req.getSortBy()!=null){
            if(req.getSortBy().equals("xl")&&req.getSortWay().equals("asc")){
                //销量升序
                queryBuilder.withSort(SortBuilders.fieldSort("sellerCount").order(SortOrder.ASC));
            }else  if(req.getSortBy().equals("xl")&&req.getSortWay().equals("desc")) {
                // 销量降序
                queryBuilder.withSort(SortBuilders.fieldSort("sellerCount").order(SortOrder.DESC));
            }else if(req.getSortBy().equals("jg")&&req.getSortWay().equals("asc")){
                // 价格升序
                queryBuilder.withSort(SortBuilders.fieldSort("price").order(SortOrder.ASC));
            }else  if(req.getSortBy().equals("jg")&&req.getSortWay().equals("desc")) {
                // 价格降序
                queryBuilder.withSort(SortBuilders.fieldSort("price").order(SortOrder.DESC));
            }else if(req.getSortBy().equals("pl")&&req.getSortWay().equals("asc")){
                // 评论升序
                queryBuilder.withSort(SortBuilders.fieldSort("commentCount").order(SortOrder.ASC));
            }else  if(req.getSortBy().equals("pl")&&req.getSortWay().equals("desc")) {
                // 评论降序
                queryBuilder.withSort(SortBuilders.fieldSort("commentCount").order(SortOrder.DESC));
            }else if(req.getSortBy().equals("sj")&&req.getSortWay().equals("asc")){
                // 上架时间
                queryBuilder.withSort(SortBuilders.fieldSort("onSaleTime").order(SortOrder.ASC));
            }else  if(req.getSortBy().equals("sj")&&req.getSortWay().equals("desc")) {
                // 上架时间
                queryBuilder.withSort(SortBuilders.fieldSort("onSaleTime").order(SortOrder.DESC));
            }
        }


        //4 分页 ， 【注意】 分页从0开始
        queryBuilder.withPageable(PageRequest.of(req.getPage() - 1 ,req.getPage()));

        //5 查询,获取结果
        // 5.1 查询
        Page<SearchSku> pageInfo = this.skuRepository.search(queryBuilder.build());
        // 5.2 总条数
        long total = pageInfo.getTotalElements();
        // 5.3 封装
        BaseResult result = new BaseResult(0, "成功");
        result.append("count" , total);


        // 5.4 获取返回结果 ，组装返回数据
        List<SearchSku> list = pageInfo.getContent();
        // 返回的结果
        List<ReturnSku> returnList = new ArrayList<>();
        for(SearchSku sku:list){
            ReturnSku rs = new ReturnSku();
            rs.setId(sku.getId());
            rs.setGoodsName(sku.getSkuName());
            rs.setMidlogo(sku.getLogo());
            rs.setCommentCount(sku.getCommentCount());
            rs.setPrice(sku.getPrice());

            returnList.add(rs);
        }

        result.append("data" ,returnList);

        return result;
    }
}

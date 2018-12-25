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

    public BaseResult search(SearchRequest searchRequest) {
        //SearchRequest(keyword=null, catId=76, brandId=-1, specList={}, minPrice=null, maxPrice=null, limit=null, page=1, sortBy=xl, sortWay=desc, perPage=30)
        //SearchRequest(keyword=null, catId=76, brandId=8557, specList={}, minPrice=null, maxPrice=null, limit=null, page=1, sortBy=xl, sortWay=desc, perPage=30)
        //SearchRequest(keyword=null, catId=76, brandId=8557, specList={}, minPrice=null, maxPrice=null, limit=null, page=1, sortBy=xl, sortWay=desc, perPage=30)
        System.out.println(searchRequest);
        //0 拼凑条件,使用 BoolQueryBuilder 进行条件的追加（and or）
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        //0.1 关键字（暂时不实现）
        //0.2 品牌
        if (searchRequest.getBrandId() != null) {
            boolQueryBuilder.must(QueryBuilders.termQuery("brandId", searchRequest.getBrandId()));
        }
        //0.3 规格 : 遍历map依次处理每一个规格，key有要求
        if (searchRequest.getSpecList() != null) {
            for (String key : searchRequest.getSpecList().keySet()) {
                String value = searchRequest.getSpecList().get(key);
                System.out.println(value);
                //拼凑se查询key
                String searchKey = "specs." + key + ".keyword";
                System.out.println(searchKey);
                boolQueryBuilder.must(QueryBuilders.termQuery(searchKey, value));
                boolQueryBuilder.must( QueryBuilders.termQuery(searchKey,value));
            }
        }

        //0.4 范围
        if (searchRequest.getMinPrice() != null) {
            boolQueryBuilder.must(QueryBuilders.rangeQuery("private").gte(searchRequest.getMinPrice()));
        }
        if (searchRequest.getMaxPrice() != null) {
            boolQueryBuilder.must(QueryBuilders.rangeQuery("private").lte(searchRequest.getMaxPrice()));
        }
        //0.5 分页


        //1 使用条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        if("xl".equals( searchRequest.getSortBy() ) && "desc".equals(searchRequest.getSortWay() )){
            queryBuilder.withSort( SortBuilders.fieldSort("sellerCount").order( SortOrder.DESC));
        } else if("jg".equals( searchRequest.getSortBy() ) && "desc".equals(searchRequest.getSortWay() )){
            queryBuilder.withSort( SortBuilders.fieldSort("price").order( SortOrder.DESC));
        } else if("jg".equals( searchRequest.getSortBy() ) && "asc".equals(searchRequest.getSortWay() )){
            queryBuilder.withSort( SortBuilders.fieldSort("price").order( SortOrder.ASC));
        } else if("pl".equals( searchRequest.getSortBy() ) && "desc".equals(searchRequest.getSortWay() )){
            queryBuilder.withSort( SortBuilders.fieldSort("commentCount").order( SortOrder.DESC));
        } else if("sj".equals( searchRequest.getSortBy() ) && "desc".equals(searchRequest.getSortWay() )){
            queryBuilder.withSort( SortBuilders.fieldSort("onSaleTime").order( SortOrder.DESC));
        }
        // 0.end
        queryBuilder.withQuery(boolQueryBuilder);

        //2 进行分页操作 ,【注意：从0开始】
        queryBuilder.withPageable(PageRequest.of(searchRequest.getPage() - 1, searchRequest.getPerPage()));

        //3 获得数据 -- SearchSku
        Page<SearchSku> page = this.skuRepository.search(queryBuilder.build());
        List<ReturnSku> returnList = new ArrayList<>();
        for (SearchSku searchSku : page.getContent()) {
            ReturnSku returnSku = new ReturnSku();

            returnSku.setId((long) searchSku.getId().intValue());
            returnSku.setGoodsName(searchSku.getSkuName());
            returnSku.setPrice(searchSku.getPrice());
            returnSku.setMidlogo(searchSku.getMidlogo());
            returnSku.setCommentCount(searchSku.getCommentCount());

            returnList.add(returnSku);
        }

        //4 拼凑页面需要数据 -- BaseResult ( ReturnSku)
        BaseResult baseResult = new BaseResult(0, "成功");
        baseResult.append("count", page.getTotalElements());
        baseResult.append("data", returnList);
//        System.out.println(baseResult);
        return baseResult;

    }
}

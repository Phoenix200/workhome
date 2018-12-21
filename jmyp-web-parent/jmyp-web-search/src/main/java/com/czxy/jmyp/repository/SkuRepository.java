package com.czxy.jmyp.repository;

import com.czxy.jmyp.vo.SearchSku;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @ClassName SkuRepository
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/21 10:53
 * @Version 1.0
 **/
public interface SkuRepository extends ElasticsearchRepository<SearchSku, Long> {

}

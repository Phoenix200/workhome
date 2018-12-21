package com.czxy.dao;

import com.czxy.pojo.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @ClassName ItemRepository
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/19 16:32
 * @Version 1.0
 **/
public interface ItemRepository extends ElasticsearchRepository<Item,Long> {
    List<Item> findByPriceBetween(double v, double v1);
}

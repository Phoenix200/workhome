package com.czxy.jmyp.feignclient;

import com.czxy.jmyp.vo.SearchSku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName SkuClient
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/21 10:51
 * @Version 1.0
 **/
@FeignClient(value="web-service")
@RequestMapping
public interface SkuClient {
    @GetMapping("/esData")
    ResponseEntity<List<SearchSku>> findESData();
}

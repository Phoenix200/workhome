package com.czxy.jmyp.frignclient;

import com.czxy.jmyp.WebSearchApplication;
import com.czxy.jmyp.feignclient.SkuClient;
import com.czxy.jmyp.repository.SkuRepository;
import com.czxy.jmyp.vo.SearchSku;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName skuClienTest
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/21 10:53
 * @Version 1.0
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebSearchApplication.class )
public class skuClienTest {

    @Resource
    private SkuClient skuClient;
    @Resource
    private SkuRepository skuRepository;

    @Test
    public void testUser(){

        ResponseEntity<List<SearchSku>> all=skuClient.findESData();
        this.skuRepository.saveAll(all.getBody());
    }
}

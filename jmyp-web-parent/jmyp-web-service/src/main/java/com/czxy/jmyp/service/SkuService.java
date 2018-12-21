package com.czxy.jmyp.service;

import com.alibaba.fastjson.JSON;
import com.czxy.jmyp.dao.SkuCommentMapper;
import com.czxy.jmyp.dao.SkuMapper;
import com.czxy.jmyp.pojo.Sku;
import com.czxy.jmyp.vo.ESData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SkuService
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/21 8:21
 * @Version 1.0
 **/
@Service
@Transactional
public class SkuService {

    @Resource
    private SkuMapper skuMapper;

    @Resource
    private SkuCommentMapper skuCommentMapper;

    /**
     * 查询所有sku，将数据封装到ESData中
     * @return
     */
    public List<ESData> findESData(){

        //1查询所有sku
        List<Sku> sku = skuMapper.findAllSkus();
        System.out.println(sku);
        //2提供 ESData 集合
        List<ESData> list =new ArrayList<>();
        //3处理数据
        for (Sku s:sku) {
            ESData esData = new ESData();
            //处理数据
            esData.setId(s.getId());
            esData.setLogo(s.getSpu().getLogo());
            esData.setSkuName(s.getSkuName());

            System.out.println(s.getSkuName());
            System.out.println(s.getSpecInfoIdTxt());
            System.out.println(s.getSpu().getBrand());
            System.out.println(s.getSkuName()+"   " + s.getSpecInfoIdTxt() + "   " +s.getSpu().getBrand().getBrandName());

            esData.setAll(s.getSkuName()+"   " + s.getSpecInfoIdTxt() + "   " +s.getSpu().getBrand().getBrandName());
            esData.setOnSaleTime(s.getSpu().getOnSaleTime());
            esData.setBrandId(s.getSpu().getBrandId());
            esData.setCatId(s.getSpu().getCat3Id());
            Map map = JSON.parseObject(s.getSpecInfoIdTxt(), Map.class);
            esData.setSpecs(map);
            esData.setPrice(s.getPrice());
            esData.setSpuName(s.getSpu().getSpuName());
            esData.setStock(s.getStock());
            esData.setDescription(s.getSpu().getDescription());
            esData.setPackages(s.getSpu().getPackages());
            esData.setAftersale(s.getSpu().getAftersale());
            // midlogo;
            esData.setMidlogo(s.getSpu().getLogo());
            // comment_count; 评价数
            Integer comment_count = skuCommentMapper.findNumBySpuId(s.getId());
            esData.setCommentCount(comment_count);

            //销售量
            esData.setSellerCount(10);

            list.add(esData);
        }
        //4返回
        return list;
    }
}

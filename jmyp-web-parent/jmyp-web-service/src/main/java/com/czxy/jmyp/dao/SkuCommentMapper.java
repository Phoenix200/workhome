package com.czxy.jmyp.dao;

import com.czxy.jmyp.pojo.SkuComment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * @ClassName SkuCommentMapper
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/20 15:43
 * @Version 1.0
 **/

@org.apache.ibatis.annotations.Mapper
public interface SkuCommentMapper  extends Mapper<SkuComment> {
    @Select("select count(*) from tb_sku_comment where spu_id =#{spuId}")
    public Integer findNumBySpuId(@Param("spuId") Integer spuId);


    @Select("select avg(star) from tb_sku_comment where sku_id = #{skuId}")
    public Integer findAvgStarBySkuId(@Param("skuId") Integer skuId);
}

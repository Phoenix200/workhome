package com.czxy.jmyp.dao;

import com.czxy.jmyp.pojo.SkuComment;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

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

    @Select("select count(*) from tb_sku_comment where spu_id = #{spuid} and ratio=#{integer}")
    public Integer findCountBySpuId(@Param("spuid") Integer spuid ,Integer integer);


    @Select("select * from tb_sku_comment where spu_id = #{spuid}")
    @Results({
            @Result(property = "createdAt" , column = "created_at"),
            @Result(property = "updatedAt" , column = "updated_at"),
            @Result(property = "userId" , column = "user_id"),
            @Result(property = "skuId" , column = "sku_id"),
            @Result(property = "specList" , column = "spec_list"),
            @Result(property = "user" , one = @One(select = "com.czxy.jmyp.dao.UserMapper.selectByPrimaryKey"), column = "user_id"),
    })
    public List<SkuComment> findCommentsBySpuid(@Param("spuid") Integer spuid);
}

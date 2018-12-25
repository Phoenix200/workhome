package com.czxy.jmyp.dao;

import com.czxy.jmyp.pojo.SkuPhoto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @ClassName SkuPhotoMapper
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/25 10:43
 * @Version 1.0
 **/
@org.apache.ibatis.annotations.Mapper
public interface SkuPhotoMapper extends Mapper<SkuPhoto> {

    @Select("select * from tb_sku_photo where sku_id = #{spuId}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="sku_id",property="skuId"),
            @Result(column="url",property="url")
    })
    public List<SkuPhoto> findSkuPhotoBySkuId(@Param("spuId") Integer spuId);

}

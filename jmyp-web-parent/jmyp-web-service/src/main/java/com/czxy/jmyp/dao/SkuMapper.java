package com.czxy.jmyp.dao;

import com.czxy.jmyp.pojo.Sku;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @ClassName SkuMapper
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/20 14:59
 * @Version 1.0
 **/
@org.apache.ibatis.annotations.Mapper
public interface SkuMapper extends Mapper<Sku> {
    @Select("select * from tb_sku")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column="spu_id",property="spuId"),
            @Result(column = "stock",property = "stock"),
            @Result(column = "sku_name",property = "skuName"),
            @Result(column = "spec_info_id_list",property = "specInfoIdList"),
            @Result(column="spu_id",property="spu",
                    one=@One(
                            select="com.czxy.jmyp.dao.SpuMapper.findSpuById"
                    ))
    })
    public List<Sku> findAllSkus();
}


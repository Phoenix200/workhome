package com.czxy.jmyp.dao;

import com.czxy.jmyp.pojo.Impression;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @ClassName ImpressionMapper
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/25 17:08
 * @Version 1.0
 **/

@org.apache.ibatis.annotations.Mapper
public interface ImpressionMapper extends Mapper<Impression> {


    @Select("select * from tb_impression where spu_id = #{spuid}")
    public List<Impression> findImpressionsBySpuid(@Param("spuid") Integer spuid);

}

package com.czxy.jmyp.dao;

import com.czxy.jmyp.pojo.Specification;
import lombok.Data;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @ClassName Specification
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/19 8:32
 * @Version 1.0
 **/
@org.apache.ibatis.annotations.Mapper
public interface SpecificationMapper extends Mapper<Specification> {

    @Select("select * from tb_specification where category_id = #{categoryId}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "specName",column = "spec_name"),
            @Result(property = "categoryId",column = "category_id"),
            @Result(property = "options",many = @Many(select = "com.czxy.jmyp.dao.SpecificationOptionMapper.findSpecificationOptionBySpecificationId"),column = "id"),

    })
    public List<Specification> findSpecificationByCategoryId(@Param("categoryId") Integer categoryId);
}

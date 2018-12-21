package com.czxy.jmyp.dao;

import com.czxy.jmyp.pojo.SpecificationOption;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @ClassName SpecificationOptionMapper
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/19 8:32
 * @Version 1.0
 **/
@org.apache.ibatis.annotations.Mapper
public interface SpecificationOptionMapper extends Mapper<SpecificationOption> {


    @Select("select * from tb_specification_option where spec_id =#{specId}")
    @Results({
            @Result(column="id",property="id"),
            @Result(column="spec_id",property="specId"),
            @Result(column="option_name",property="optionName"),
    })
    public List<SpecificationOption> findSpecificationOptionBySpecificationId(@Param("specId")Integer specId);
}

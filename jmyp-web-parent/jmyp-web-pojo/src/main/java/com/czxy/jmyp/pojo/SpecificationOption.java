package com.czxy.jmyp.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * @ClassName SpecificationOption
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/19 8:23
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_specification_option")
@ToString
public class SpecificationOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "spec_id")
    private Integer specId;

    @Column(name = "option_name")
    @JsonProperty("option_name")
    private String optionName;
}

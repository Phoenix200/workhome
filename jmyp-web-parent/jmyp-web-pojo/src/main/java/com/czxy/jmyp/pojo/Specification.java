package com.czxy.jmyp.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * @ClassName Specification
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/19 8:26
 * @Version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_specification")
@ToString
public class Specification {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "spec_name")
    @JsonProperty("spec_name")
    private String specName;
    @Column(name = "category_id")
    private Integer categoryId;
    @Transient
    private Category category;
    @Transient
    private List<SpecificationOption> options;
}

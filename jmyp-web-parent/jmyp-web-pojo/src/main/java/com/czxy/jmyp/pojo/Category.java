package com.czxy.jmyp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Category
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/17 11:31
 * @Version 1.0
 **/
@Table(name = "tb_category")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Category {

    @Id
    private  Integer id;

    @Column(name = "cat_name")
    private String catName;

    @Column(name = "parent_id")
    private Integer parentId;
    @Column(name = "is_parent")
    private Integer isParent;

    private List<Category> children=new ArrayList<>();

}

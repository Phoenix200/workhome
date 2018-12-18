package com.czxy.jmyp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * @ClassName Brand
 * @Description 品牌管理
 * @Author 张小仙
 * @Date 2018/12/18 10:38
 * @Version 1.0
 **/
@Table(name = "tb_brand")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Brand {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name="brand_name")
    private String brandName;
    @Column(name="logo")
    private String logo;
}
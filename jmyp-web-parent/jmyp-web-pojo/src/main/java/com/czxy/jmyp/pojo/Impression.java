package com.czxy.jmyp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @ClassName Impression
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/25 17:05
 * @Version 1.0
 **/
@Table(name = "tb_impression")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Impression {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Integer count;
    private Integer spu_id;
    private Integer sku_id;
}

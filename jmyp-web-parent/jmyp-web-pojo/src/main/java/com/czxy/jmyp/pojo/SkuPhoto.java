package com.czxy.jmyp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * @ClassName Sku
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/20 11:34
 * @Version 1.0
 **/
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_sku_photo")
public class SkuPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sku_id")
    private Integer skuId;
    @Transient
    private Sku sku;
    @Column(name="url")
    private String url;
}

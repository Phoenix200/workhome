package com.czxy.jmyp.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

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
    @Column(name = "spu_id")
    @JsonProperty("spu_id")
    private Integer spuId;
    @Column(name = "sku_id")
    @JsonProperty("sku_id")
    private Integer skuId;
}

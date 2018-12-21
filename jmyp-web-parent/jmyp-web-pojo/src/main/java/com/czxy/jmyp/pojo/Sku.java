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
@Table(name = "tb_sku")
public class Sku {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="stock")
    private Integer stock;
    @Column(name = "spu_id")
    private Integer spuId;
    @Transient
    private Spu spu;
    @Column(name = "sku_name")
    private String skuName;
    @Column(name="images")
    private String images;
    @Column(name="price")
    private Double price;

    //1:1|2:6|6:22
    @Column(name="spec_info_id_list")
    private String specInfoIdList;
    //规格列表码,格式：{"机身颜色":"白色","内存":"3GB","机身存储":"16GB"}
    @Column(name="spec_info_id_txt")
    private String specInfoIdTxt;
}

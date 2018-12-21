package com.czxy.jmyp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @ClassName SkuComment
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/20 11:46
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_sku_comment")
public class SkuComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="created_at")
    private Timestamp createdAt;
    @Column(name="updated_at")
    private Timestamp updatedAt;

    @Column(name="user_id")
    private Integer userId;
    @Transient
    private User user;

    @Column(name="spu_id")
    private Integer spuId;
    @Transient
    private Spu spu;

    @Column(name="sku_id")
    private Integer skuId;
    @Transient
    private Spu sku;


    @Column(name="ratio")
    private String ratio;

    @Column(name="spec_list")
    private String specList;


    @Column(name="content")
    private String content;
    @Column(name="star")
    private Integer star;
    @Column(name="isshow")
    private String isShow;

    @Column(name="sn")
    private String sn;
}

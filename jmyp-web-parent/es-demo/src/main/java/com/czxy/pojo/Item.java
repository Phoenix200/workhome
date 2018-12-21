package com.czxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @ClassName Item
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/19 11:39
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "iten" ,type = "docs")
public class Item {

    @Id
    private Long id;
    @Field(type = FieldType.Text ,analyzer = "ik_max_word")
    private String title; 			//标题
    @Field(type = FieldType.Keyword)
    private String category;		//分类
    @Field(type = FieldType.Keyword)
    private String brand; 			//品牌
    @Field(type = FieldType.Double)
    private Double price; 			//价格
    @Field(index = false,type = FieldType.Keyword)
    private String images; 		//图片地址
}

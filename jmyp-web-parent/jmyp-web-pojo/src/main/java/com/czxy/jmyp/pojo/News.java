package com.czxy.jmyp.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName News
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/17 15:52
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "tb_news")
public class News {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "author")
    private String author;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "updated_at")
    private Date updatedAt;

}

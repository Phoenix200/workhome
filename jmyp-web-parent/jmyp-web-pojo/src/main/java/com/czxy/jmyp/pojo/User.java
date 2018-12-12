package com.czxy.jmyp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.security.Timestamp;

/**
 * @ClassName tb_user
 * @Description 用户类
 * @Author 张小仙
 * @Date 2018/12/12 10:56
 * @Version 1.0
 **/

@Table(name = "tb_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "face")
    private String face;

    @Column(name = "expriece")
    private Integer expriece;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @Transient
    private String code;
    @Transient
    private String password_confirm;

}
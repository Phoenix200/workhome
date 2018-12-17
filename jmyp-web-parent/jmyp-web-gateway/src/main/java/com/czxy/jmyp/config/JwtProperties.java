package com.czxy.jmyp.config;

import com.czxy.jmyp.auth.util.RasUtils;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.security.PublicKey;

/**
 * @ClassName JwtProperties
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/17 8:22
 * @Version 1.0
 **/
@Data
@ConfigurationProperties(prefix="sc.jwt")
public class JwtProperties {


    private String pubKeyPath;// 公钥

    private PublicKey publicKey; // 公钥


    private static final Logger logger = LoggerFactory.getLogger(JwtProperties.class);

    @PostConstruct
    public void init(){
        try {
            // 获取公钥和私钥
            this.publicKey = RasUtils.getPublicKey(pubKeyPath);
        } catch (Exception e) {
            logger.error("初始化公钥失败！", e);
            throw new RuntimeException();
        }
    }
}
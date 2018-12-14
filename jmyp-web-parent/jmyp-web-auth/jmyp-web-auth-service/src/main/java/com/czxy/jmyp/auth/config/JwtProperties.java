package com.czxy.jmyp.auth.config;

import com.czxy.jmyp.auth.util.RasUtils;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import java.io.File;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * 存放的是application.yaml的自定义内容
 *
 * @ClassName JwtProperties
 * @Description TODO
 * @Author 张小仙
 * @Date 2018/12/13 16:07
 * @Version 1.0
 **/
@Data
@ConfigurationProperties(prefix = "sc.jwt")
public class JwtProperties {

    private String secret; // 密钥

    private String pubKeyPath;// 公钥

    private String priKeyPath;// 私钥

    private int expire;     // token过期时间

    private PublicKey publicKey; // 公钥

    private PrivateKey privateKey; // 私钥

    //进行初始化
    @PostConstruct
    public void init() {
        try {
            //路径   -->对象   (如果不存在，创建一次)
            //1获得私钥或公钥的文件
            File pubFile = new File(this.pubKeyPath);
            File priFile = new File(this.priKeyPath);
            //2.文件不存在，生产一对
            if (!pubFile.exists() || !priFile.exists()) {
                RasUtils.generateKey(this.pubKeyPath, this.priKeyPath, this.secret);
            }
            // 获取公钥和私钥
            this.publicKey = RasUtils.getPublicKey(pubKeyPath);
            this.privateKey = RasUtils.getPrivateKey(priKeyPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


//    private static final Logger logger = LoggerFactory.getLogger(JwtProperties.class);

}

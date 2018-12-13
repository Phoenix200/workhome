package com.czxy.jmyp.config;

import com.czxy.jmyp.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @ClassName RedisConfig
 * @Description Redis的配置
 * @Author 张小仙
 * @Date 2018/12/13 10:30
 * @Version 1.0
 **/
@Configuration
public class RedisConfig {

    @Bean
    public StringRedisTemplate  redisTemplate(RedisConnectionFactory connectionFactory){
        return new StringRedisTemplate(connectionFactory);
    }
}

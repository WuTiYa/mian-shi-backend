package com.sun.mianshi.config;

import lombok.Data;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.redis")//要读取的配置文件的前缀
@Data
public class RedissonConfig {
    //redis链接地址
    private String host;
    //redis的端口号
    private Integer port;
    //redis的库号
    private Integer database;
    //redis的密码
    private String password;
    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://" + host + ":" + port )
                .setDatabase(database)
                .setPassword(password);
        return Redisson.create(config);
    }

}

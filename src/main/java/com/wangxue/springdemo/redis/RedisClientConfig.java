package com.wangxue.springdemo.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Collections;

@Configuration
public class RedisClientConfig {

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }

    @Bean
    public RedisConnectionFactory redisConnectionFactory(RedisConfiguration redisConfiguration) {
        LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisConfiguration);
        lettuceConnectionFactory.setEagerInitialization(false);
        return lettuceConnectionFactory;
    }

    @Bean
    public RedisConfiguration redisConfiguration() {
        return new RedisClusterConfiguration(Collections.singleton("redis.address:6379"));
    }
}

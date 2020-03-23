package com.pp.sandbox.mockserver.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.stereotype.Component;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class EmbeddedRedisServer {

    private static RedisServer redisServer;

    private final RedisProperties redis;

    @Autowired
    public EmbeddedRedisServer(RedisProperties redis) {
        this.redis = redis;
    }

    @PostConstruct
    private void startRedisServer() {
        if (redisServer == null) {
            redisServer = RedisServer.builder()
                    .port(redis.getPort())
                    .setting("requirepass " + redis.getPassword())
                    .build();
        }

        if (redisServer.isActive()) {
            System.out.println("Embedded Redis server is already running on port " + redis.getPort());
        } else {
            redisServer.start();
            System.out.println("Started embedded Redis server on port " + redis.getPort());
        }
    }

    @PreDestroy
    private void stopRedisServer() {
        if (redisServer == null) return;
        redisServer.stop();
        System.out.println("Stopped embedded Redis server");
    }

    public RedisServer getRedisServer() {
        return redisServer;
    }
}

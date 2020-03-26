package com.pp.sandbox.mockserver.controller;

import io.lettuce.core.RedisClient;
import io.lettuce.core.ScriptOutputType;
import io.lettuce.core.api.StatefulRedisConnection;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/redis")
public class RedisController {

    private static RedisScript<Long> limiterScript = readLimiterScript();


    @RequestMapping("/incr")
    private String incr() {
        return "DONE(" + incrLimiter() + ")";
    }

    public Long incrLimiter() {
        RedisClient redisClient = RedisClient.create("redis://redis@localhost:6379");
        StatefulRedisConnection connection = redisClient.connect();
        Long value = (Long) connection.sync()
                .eval(limiterScript.getScriptAsString(), ScriptOutputType.INTEGER,
                        new String[] {"test"}, new String[] {"2"});
        System.out.println("=== Redis count: " + value);
        return value;
    }

    private static RedisScript<Long> readLimiterScript() {
        try {
            if (RedisController.limiterScript == null) {
                String scriptSource = new ResourceScriptSource(new ClassPathResource("redis/limiter_incr.lua"))
                        .getScriptAsString();
                RedisController.limiterScript = RedisScript.of(scriptSource, Long.class);
            }
         } catch (IOException exception) {
            System.out.println("=== Error: " + exception);
        }
        return RedisController.limiterScript;
    }
}

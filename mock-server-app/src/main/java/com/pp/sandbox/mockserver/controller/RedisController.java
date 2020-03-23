package com.pp.sandbox.mockserver.controller;

import io.lettuce.core.RedisClient;
import io.lettuce.core.ScriptOutputType;
import io.lettuce.core.api.StatefulRedisConnection;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RedisController {

    private String incrementCommand = "value = INCR(v2:ip)\n"+
            "    IF value == 1 THEN\n"+
            "        EXPIRE(ip,1)\n"+
            "    END\n" +
            "    return value";


    @RequestMapping("/redis")
    private String incr() {
        RedisClient redisClient = RedisClient.create("redis://redis@localhost:6379");
        StatefulRedisConnection connection = redisClient.connect();
        Integer value = (Integer)connection.sync().eval("", ScriptOutputType.INTEGER);

        return "DONE(" + value + ")";
    }

}

package com.pp.sandbox.mockserver.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockController {

    @Value("${mock.sleep.time}")
    private long sleepTime;

    @RequestMapping("/mock/{id}")
    private String mock(@PathVariable Integer id) throws InterruptedException {
        System.out.println("=== Come with " + id);
        double rnd = Math.random();
        long timeout = (long) (rnd * sleepTime);
        System.out.println("=== " + timeout + ":  " + id);
        Thread.sleep(timeout);
        return "DONE(" + id + ")";
    }
}

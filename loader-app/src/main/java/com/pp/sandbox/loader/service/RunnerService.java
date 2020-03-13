package com.pp.sandbox.loader.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RunnerService {
    @Value("${load.param.time}")
    private Integer period;

    @Scheduled(initialDelayString = "#{1000/${load.param.requestsPerSecond}}")
    public void loadTrigger() {
        System.out.println("===== " + System.currentTimeMillis());
    }
}

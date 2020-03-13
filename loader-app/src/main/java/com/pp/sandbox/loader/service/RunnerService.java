package com.pp.sandbox.loader.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RunnerService {
    @Value("${load.param.period}/${load.param.requestsPerSecond}")
    private Integer period;

    @Value("${load.param.requestsPerSecond}")
    private Integer requestsPerSecond;

    @Scheduled(initialDelayString = "1000")
    public void loadTrigger(int period, int req) {
        System.out.println("===== " + System.currentTimeMillis());
    }
}

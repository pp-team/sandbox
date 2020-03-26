package com.pp.sanbox.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    final private ThreadPoolTaskExecutor serviceExecutor;

    @Autowired
    public TestService( ThreadPoolTaskExecutor serviceExecutor) {
        this.serviceExecutor = serviceExecutor;
    }

    public String prepareResponse() {


        return "";
    }
}

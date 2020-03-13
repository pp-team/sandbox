package com.pp.sandbox.loader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerBean implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("===== " + System.currentTimeMillis());
    }
}

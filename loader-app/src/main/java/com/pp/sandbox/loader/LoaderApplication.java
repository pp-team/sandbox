package com.pp.sandbox.loader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@SpringBootApplication
public class LoaderApplication {
    private static ApplicationContext appContext;

    public static void main(String[] args) {
        appContext = SpringApplication.run(LoaderApplication.class, args);
    }

    @Scheduled(fixedDelayString = "${load.time.period:10}000")
    private void closeApplication() {
        if(appContext != null) {
            ((ConfigurableApplicationContext) appContext).close();
        }
    }
}

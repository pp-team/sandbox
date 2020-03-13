package com.pp.sanbox.server.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class TestController {
    @Value("${backend.system.url}/mock")
    private String mockUrl;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        long start = System.currentTimeMillis();

        String response = (String) IntStream.range(0, 10).parallel().mapToObj(e-> sendRequest(e))
                .collect(Collectors.joining( ", " ));

        long stop = System.currentTimeMillis();
        return "OK with - " + response + " \n time:" + (stop - start);
    }

    private String sendRequest(int id) {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForEntity(mockUrl + "/" + id, String.class).getBody();
        return response;
    }
}

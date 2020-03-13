package com.pp.sandbox.loader.controller;

import com.pp.sandbox.loader.service.RunnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoadRunnerController {
    @Autowired
    private RunnerService runnerService;

    @Value("${load.param.period}")
    private Integer period;

    @Value("${load.param.requestsPerSecond}")
    private Integer requestsPerSecond;

    @RequestMapping(value = "/loadFire", method = RequestMethod.GET)
    public String loadFireDefault() {
        runnerService.runLoad(period, requestsPerSecond);
        return "OK with";
    }

    @RequestMapping(value = "/loadFire/{period}/{requestsPerSecond}", method = RequestMethod.GET)
    public String loadFireWithParams(@PathVariable(value = "20") Integer period,
                       @PathVariable(value = "10") Integer requestsPerSecond) {
        runnerService.runLoad(period, requestsPerSecond);
        return "OK with";
    }

}

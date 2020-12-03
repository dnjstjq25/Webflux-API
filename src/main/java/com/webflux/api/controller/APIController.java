package com.webflux.api.controller;

import com.webflux.api.model.Version;
import com.webflux.api.service.APIService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class APIController {

    private final APIService apiService;


    public APIController(APIService apiService) {
        this.apiService = apiService;
    }

    @RequestMapping(value = "/version", method = RequestMethod.GET, produces = "application/json")
    public Mono<Version> version() throws Exception {

        return apiService.versionSelect();
    }

}

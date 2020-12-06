package com.webflux.api.controller;

import com.webflux.api.model.Member;
import com.webflux.api.model.Version;
import com.webflux.api.service.APIService;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class APIController {

    private final APIService apiService;


    public APIController(APIService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/version")
    public Mono<Version> version() throws Exception {

        return apiService.versionSelect();
    }

    @PostMapping("/login")
    public Mono<Member> login(@RequestBody Member member) throws Exception {

        return apiService.login(member);
    }

    @PostMapping("/memberRegister")
    public Mono<Member> register(@RequestBody Member member) throws Exception {

        return apiService.register(member);
    }

    @PostMapping("/memberDelete")
    public Mono<Void> delete(@RequestBody Member member) throws Exception {

        return apiService.delete(member);
    }
}

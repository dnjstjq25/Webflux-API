package com.webflux.api.controller;

import com.webflux.api.model.Car;
import com.webflux.api.model.Member;
import com.webflux.api.model.Version;
import com.webflux.api.service.APIService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
public class APIController {
    //사용할 서비스 선언
    private final APIService apiService;
    //서비스 초기화
    public APIController(APIService apiService) {
        this.apiService = apiService;
    }

    //버전체크
    @GetMapping("/version")
    public Mono<Map<String, Object>> version() throws Exception {

        return apiService.versionSelect();
    }

    //로그인
    @PostMapping("/login")
    public Mono<Member> login(@RequestBody Member member) throws Exception {

        return apiService.login(member);
    }

    //회원가입 또는 회원정보 수정
    @PostMapping("/memberRegister")
    public Mono<Member> register(@RequestBody Member member) throws Exception {

        return apiService.register(member);
    }

    //회원탈퇴
    @PostMapping("/memberDelete")
    public Mono<Void> delete(@RequestBody Member member) throws Exception {

        return apiService.delete(member);
    }

    //전체차량조회
    @GetMapping(value = "/allCar")
    public Flux<Car> allCar() {

        return apiService.allCar();
    }
    //특정차량조회
    @PostMapping(value = "/oneCar")
    public Mono<Car> oneCar(@RequestBody Car car){

        return apiService.oneCar(car);
    }

}

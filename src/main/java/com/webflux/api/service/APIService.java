package com.webflux.api.service;

import com.webflux.api.mapper.CarRepository;
import com.webflux.api.mapper.MemberRepository;
import com.webflux.api.mapper.VersionRepository;
import com.webflux.api.model.Car;
import com.webflux.api.model.Member;
import com.webflux.api.model.Version;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
public class APIService {

    private final VersionRepository versionRepository;
    private final MemberRepository memberRepository;
    private final CarRepository carRepository;

    public APIService(VersionRepository versionRepository, MemberRepository memberRepository, CarRepository carRepository) {
        this.versionRepository = versionRepository;
        this.memberRepository = memberRepository;
        this.carRepository = carRepository;
    }

    //버전체크
    public Mono<Version> versionSelect() {

        return versionRepository.versionSelect();
    }
    //로그인
    public Mono<Member> login(Member member) {

        return memberRepository.login(member);
    }
    //회원가입 또는 회원정보 수정
    public Mono<Member> register(Member member) {

        return memberRepository.save(member); //insert, update를 처리(기본키가 있을 때)
    }
    //회원탈퇴
    public Mono<Void> delete(Member member) {

        return memberRepository.delete(member);
    }
    //전체차량조회
    public Flux<Car> allCar() {
        Flux<Car> allCar = carRepository.findAll();
        List<Car> blocked = allCar.collectList().block();
        /*log.info(blocked.toString());*/
        blocked.forEach(item -> log.info("user : {}", item));

        return allCar;
    }
    //특정차량조회
    public Mono<Car> oneCar(Car car) {

        String car_number = car.getCar_number();

        return carRepository.findOneCar(car_number);
    }

}

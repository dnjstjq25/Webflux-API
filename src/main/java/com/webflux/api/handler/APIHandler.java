package com.webflux.api.handler;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.webflux.api.model.Member;
import com.webflux.api.model.Version;
import com.webflux.api.repository.CarRepository;
import com.webflux.api.repository.MemberRepository;
import com.webflux.api.repository.VersionRepository;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Subscriber;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.springframework.web.reactive.function.BodyExtractors.toMono;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Slf4j
@Component
public class APIHandler {

    private final VersionRepository versionRepository;
    private final CarRepository carRepository;
    private final MemberRepository memberRepository;

    public APIHandler(VersionRepository versionRepository, CarRepository carRepository, MemberRepository memberRepository) {
        this.versionRepository = versionRepository;
        this.carRepository = carRepository;
        this.memberRepository = memberRepository;
    }

    public Mono<ServerResponse> version(ServerRequest serverRequest) {
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(versionRepository.versionSelect(), Version.class);
    }

    public Mono<ServerResponse> cars(ServerRequest request) {
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(carRepository.findAll(), List.class);
    }

    public Mono<ServerResponse> login(ServerRequest request) { //미완성
        Mono<Member> member = request.body(toMono(Member.class));

        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(memberRepository.login(member), List.class);


    }
}

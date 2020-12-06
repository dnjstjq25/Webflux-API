package com.webflux.api.service;

import com.webflux.api.mapper.MemberRepository;
import com.webflux.api.mapper.VersionRepository;
import com.webflux.api.model.Member;
import com.webflux.api.model.Version;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class APIService {

    private final VersionRepository versionRepository;
    private final MemberRepository memberRepository;

    public APIService(VersionRepository versionRepository, MemberRepository memberRepository) {
        this.versionRepository = versionRepository;
        this.memberRepository = memberRepository;
    }

    public Mono<Version> versionSelect() {

        return versionRepository.versionSelect();
    }

    public Mono<Member> login(Member member) {

        return memberRepository.login(member);
    }

    public Mono<Member> register(Member member) {

        return memberRepository.save(member); //insert, update를 처리(기본키가 있을 때)
    }

    public Mono<Void> delete(Member member) {

        return memberRepository.delete(member);
    }

}

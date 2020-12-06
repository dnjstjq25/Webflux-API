package com.webflux.api.mapper;

import com.webflux.api.model.Member;
import com.webflux.api.model.Version;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface MemberRepository extends R2dbcRepository<Member, String> {

    @Query("select * from tb_member where userid = :#{#member.userid} and password = :#{#member.password}")
    Mono<Member> login(@Param("member") Member member);
}

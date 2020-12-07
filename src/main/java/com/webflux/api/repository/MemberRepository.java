package com.webflux.api.repository;

import com.webflux.api.model.Member;
import org.omg.CORBA.ServerRequest;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface MemberRepository extends R2dbcRepository<Member, String> {

    @Query("select * from tb_member where userid = :userid and password :password")
    Mono<Member> login(Mono<Member> member);
}

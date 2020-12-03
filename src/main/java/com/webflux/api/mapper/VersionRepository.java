package com.webflux.api.mapper;

import com.webflux.api.model.Version;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface VersionRepository extends R2dbcRepository<Version, String> {

    @Query("select * from tb_version")
    Mono<Version> versionSelect();
}

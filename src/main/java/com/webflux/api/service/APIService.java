package com.webflux.api.service;

import com.webflux.api.mapper.VersionRepository;
import com.webflux.api.model.Version;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class APIService {

    private final VersionRepository versionRepository;

    public APIService(VersionRepository versionRepository) {
        this.versionRepository = versionRepository;
    }

    public Mono<Version> versionSelect() {

        return versionRepository.versionSelect();
    }

}

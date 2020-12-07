package com.webflux.api.version;

import com.webflux.api.car.CarRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class VersionHandler {

    private final VersionRepository versionRepository;

    public VersionHandler(VersionRepository versionRepository) {
        this.versionRepository = versionRepository;
    }

    public Mono<ServerResponse> version(ServerRequest serverRequest) {

        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(versionRepository.versionSelect(), Version.class);
    }
}

package com.webflux.api;

import com.webflux.api.mapper.CarRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class CarHandler {

    private final CarRepository carRepository;

    public CarHandler(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Mono<ServerResponse> list(ServerRequest serverRequest) {

        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(carRepository.findAll(), List.class);
    }

}

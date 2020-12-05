package com.webflux.api;

import com.webflux.api.mapper.CarRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CarRoute {

    CarRepository carRepository; //레포지토리 선언
    CarHandler carHandler = new CarHandler(carRepository);

    public RouterFunction<ServerResponse> carRouter = route()
                .GET("/allCars", accept(MediaType.APPLICATION_JSON), carHandler::list)
                .build();
}
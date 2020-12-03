package com.webflux.api;

import com.webflux.api.mapper.CarRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.EntityResponse;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import static org.springframework.web.servlet.function.ServerResponse.ok;

@Configuration
public class CarRoute {

    CarRepository carRepository;
    CarHandler carHandler = new CarHandler(carRepository);

    public RouterFunction<ServerResponse> carRouter = route()
                .GET("/allcars", accept(MediaType.APPLICATION_JSON), carHandler::list)
                .build();
}
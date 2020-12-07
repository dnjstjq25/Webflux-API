package com.webflux.api;

import com.webflux.api.mapper.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Slf4j
@Configuration
public class CarRoute {

   @Bean
   public RouterFunction<ServerResponse> carRouterFunction(CarHandler carHandler) {

       return RouterFunctions.route(GET("cars").and(accept(MediaType.APPLICATION_JSON)), carHandler::list);

   }
}
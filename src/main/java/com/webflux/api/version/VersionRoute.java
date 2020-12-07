package com.webflux.api.version;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Slf4j
@Configuration
public class VersionRoute {

   @Bean
   public RouterFunction<ServerResponse> versionRouterFunction(VersionHandler versionHandler) {

       return RouterFunctions.route(GET("version").and(accept(MediaType.APPLICATION_JSON)), versionHandler::version);

   }
}
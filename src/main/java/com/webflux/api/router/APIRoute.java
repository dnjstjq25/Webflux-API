package com.webflux.api.router;

import com.webflux.api.handler.APIHandler;
import com.webflux.api.model.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Slf4j
@Configuration
public class APIRoute {

   @Bean
   public RouterFunction<ServerResponse> versionRouterFunction(APIHandler apiHandler) {
       return RouterFunctions.route(GET("version").and(accept(MediaType.APPLICATION_JSON)), apiHandler::version)
               .andRoute(GET("cars").and(accept(MediaType.APPLICATION_JSON)), apiHandler::cars)
               .andRoute(POST("login").and(accept(MediaType.APPLICATION_JSON)), apiHandler::login);

   }
}
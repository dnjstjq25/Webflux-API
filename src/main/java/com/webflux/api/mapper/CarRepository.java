package com.webflux.api.mapper;

import com.webflux.api.model.Car;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CarRepository extends R2dbcRepository<Car, String> {

    @Query("select * from tb_car where car_number = :car_number")
    Mono<Car> findOneCar(String car_number);
}

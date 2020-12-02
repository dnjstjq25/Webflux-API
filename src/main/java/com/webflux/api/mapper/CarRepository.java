package com.webflux.api.mapper;

import com.webflux.api.model.Car;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CarRepository extends R2dbcRepository<Car, String> {

    @Query("select * from tb_cars where car_number_id = :carNumberId")
    Mono<Car> findOneCar(String carNumberId);
}

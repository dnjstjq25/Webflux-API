package com.webflux.api.car;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CarRepository extends R2dbcRepository<Car, String> { //R2dbcRepository<테이블, 자료형>
    //Flux의 경우 findAll()로 다 불러 올 수 있지만
    //Mono의 경우 findById를 사용하여 여러 형태로 리턴을 해봤지만 데이터가 나오지 않아 따로 쿼리문 작성
    //Flux도 쿼리문을 따로 작성해야 할 필요가 있을 때 이런 형식으로 작성하면 된다.
    @Query("select * from tb_car where car_number = :car_number")
    Mono<Car> findOneCar(String car_number);
}

package com.webflux.api.service;

import com.webflux.api.mapper.CarRepository;
import com.webflux.api.model.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
public class CarService {

    private final CarRepository carRepository;


    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Flux<Car> allCar() {
        Flux<Car> allCar = carRepository.findAll();
        List<Car> blocked = allCar.collectList().block();
        /*log.info(blocked.toString());*/
        blocked.forEach(item -> log.info("user : {}", item));

        return allCar;
    }

    public Mono<Car> oneCar(Car car) {

        String car_number = car.getCar_number();

        return carRepository.findOneCar(car_number);
    }
}

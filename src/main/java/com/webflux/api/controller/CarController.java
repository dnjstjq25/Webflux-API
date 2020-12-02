package com.webflux.api.controller;

import com.webflux.api.model.Car;
import com.webflux.api.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/allCar")
    public Flux<Car> allCar() {

        return carService.allCar();
    }

    @PostMapping(value = "/oneCar")
    public Mono<Car> oneCar(@RequestBody Car car) {
        return carService.oneCar(car);
    }
}

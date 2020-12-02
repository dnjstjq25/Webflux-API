package com.webflux.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("tb_cars")
public class Car {
    @Id
    private String car_id;
    private String car_number_id;
    private String vehicle_id;
}

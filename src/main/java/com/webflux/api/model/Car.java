package com.webflux.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("tb_car")
public class Car {
    @Id
    private String car_number;
    private String car_name;
    private String car_status;
    private String car_remark;
}
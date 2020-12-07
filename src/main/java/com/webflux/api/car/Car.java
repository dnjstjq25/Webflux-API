package com.webflux.api.car;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("tb_car") //r2dbc에서 언더바가 들어간 이름의 테이블을 인식을 잘 못하기 때문에 따로 설정
public class Car {
    @Id
    private String car_number;
    private String car_name;
    private String car_status;
    private String car_remark;
}
package com.webflux.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("tb_member")
public class Member {
    @Id
    private String userid;
    private String password;
    private String name;
    private String mobile;
    private String email;
    private String zip_code;
    private String address;
    private String address_detail;
    private String enabled;
    private String authorization;
    private String service;
    private String agency_code;
}


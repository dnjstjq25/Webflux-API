package com.webflux.api.model;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("tb_version")
public class Version {
    private String version_id;
    private String updated;
    private String version;
    private String up_url;
    private String up_title;
    private String up_info;
    private String pop;
    private String pop_url;
}

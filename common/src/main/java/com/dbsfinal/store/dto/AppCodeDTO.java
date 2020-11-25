package com.dbsfinal.store.dto;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AppCodeDTO {

    private Integer appCodeId;
    private String code;
    private String description;
    private Integer status;
}

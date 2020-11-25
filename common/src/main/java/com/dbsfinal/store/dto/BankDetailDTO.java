package com.dbsfinal.store.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
/**
 * Response structure bank data
 */
public class BankDetailDTO {

    private Integer id;

    private Integer bankId;

    private Integer status;

    private String createdBy;

    private LocalDateTime createdDatetime;

    private String modifiedBy;

    private LocalDateTime modifiedDatetime;

}

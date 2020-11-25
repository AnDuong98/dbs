package com.dbsfinal.store.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO extends AbstractDTO{
    private int addressId;
    private String title;
    private String Phone;
}

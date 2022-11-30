package com.webmovieticket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetailsDTO extends BaseDTO {
    private String name;
    private String email;
    private String mobile;
    private String address;
}

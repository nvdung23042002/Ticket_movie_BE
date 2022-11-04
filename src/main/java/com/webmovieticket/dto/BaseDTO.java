package com.webmovieticket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDTO {
    private Long id;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private Boolean isPresent = true;
}

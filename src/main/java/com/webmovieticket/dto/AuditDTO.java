package com.webmovieticket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditDTO {
    private Integer sumAmount;
    private Integer sumNumberSeat;
}

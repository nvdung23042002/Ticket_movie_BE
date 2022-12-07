package com.webmovieticket.dto.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResDTO {
    String status;
    String message;
    String url;

    List<Long> ticketsId;
    Long userId;
}

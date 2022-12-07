package com.webmovieticket.dto.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    Long id;
    String description;
    String bankCode;
    List<Long> ticketsId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentDTO that = (PaymentDTO) o;
        return description.equals(that.description) && ticketsId.equals(that.ticketsId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, ticketsId);
    }
}

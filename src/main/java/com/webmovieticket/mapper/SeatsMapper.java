package com.webmovieticket.mapper;

import com.webmovieticket.dto.SeatsDTO;
import com.webmovieticket.models.Seats;
import org.springframework.stereotype.Component;

@Component
public class SeatsMapper {

    public SeatsDTO returnDTO(Seats seats) {

        SeatsDTO seatsDTO = new SeatsDTO();

        seatsDTO.setSeat_id(seats.getSeat_id());
        seatsDTO.setSeat_name(seats.getSeat_name());
        seatsDTO.setTd_id(seats.getTd_id());

        return seatsDTO;
    }

    public Seats returnEntity(SeatsDTO seatsDTO) {
        Seats seats = new Seats();

        seats.setSeat_id(seatsDTO.getSeat_id());
        seats.setSeat_name(seatsDTO.getSeat_name());
        seats.setTd_id(seatsDTO.getTd_id());

        return seats;
    }
}

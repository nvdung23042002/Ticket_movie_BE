package com.webmovieticket.mapper;

import com.webmovieticket.dto.SeatSessionDTO;
import com.webmovieticket.models.SeatSession;
import org.springframework.stereotype.Component;

@Component
public class SeatSessionMapper {

    public SeatSessionDTO returnDTO (SeatSession seatSession) {

        SeatSessionDTO seatSessionDTO = new SeatSessionDTO();

        seatSessionDTO.setId(seatSession.getId());
        seatSessionDTO.setTime(seatSession.getTime());
        seatSessionDTO.setDate(seatSession.getDate());
        seatSessionDTO.setTimestamp(seatSession.getTimestamp());
        seatSessionDTO.setIp(seatSession.getIp());

        return seatSessionDTO;
    }

    public SeatSession returnEntity (SeatSessionDTO seatSessionDTO) {

        SeatSession seatSession = new SeatSession();

        seatSession.setId(seatSessionDTO.getId());
        seatSession.setTime(seatSessionDTO.getTime());
        seatSession.setDate(seatSessionDTO.getDate());
        seatSession.setTimestamp(seatSessionDTO.getTimestamp());
        seatSession.setIp(seatSessionDTO.getIp());

        return seatSession;
    }
}

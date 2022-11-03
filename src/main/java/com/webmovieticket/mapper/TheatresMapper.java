package com.webmovieticket.mapper;

import com.webmovieticket.dto.TheatresDTO;
import com.webmovieticket.models.Theatres;
import org.springframework.stereotype.Component;

@Component
public class TheatresMapper {

    public TheatresDTO returnDTO(Theatres theatres) {

        TheatresDTO theatresDTO = new TheatresDTO();

        theatresDTO.setId(theatres.getId());
        theatresDTO.setName(theatres.getName());
        theatresDTO.setAddress(theatres.getAddress());
        theatresDTO.setEmail(theatres.getEmail());
        theatresDTO.setMobile(theatres.getMobile());
        theatresDTO.setStatus(theatres.getStatus());
        theatresDTO.setType(theatres.getType());
        theatresDTO.setNotifications(theatres.getNotifications());

        return theatresDTO;
    }

    public Theatres returnEntity(TheatresDTO theatresDTO) {

        Theatres theatres = new Theatres();

        theatres.setId(theatresDTO.getId());
        theatres.setName(theatresDTO.getName());
        theatres.setAddress(theatresDTO.getAddress());
        theatres.setEmail(theatresDTO.getEmail());
        theatres.setMobile(theatresDTO.getMobile());
        theatres.setStatus(theatresDTO.getStatus());
        theatres.setType(theatresDTO.getType());
        theatres.setNotifications(theatresDTO.getNotifications());

        return theatres;
    }
}

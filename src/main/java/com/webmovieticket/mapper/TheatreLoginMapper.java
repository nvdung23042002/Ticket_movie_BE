package com.webmovieticket.mapper;

import com.webmovieticket.dto.TheatreLoginDTO;
import com.webmovieticket.models.TheatreLogin;
import org.springframework.stereotype.Component;

@Component
public class TheatreLoginMapper {

    public TheatreLoginDTO returnDTO(TheatreLogin theatreLogin) {

        TheatreLoginDTO theatreLoginDTO = new TheatreLoginDTO();

        theatreLoginDTO.setId(theatreLogin.getId());
        theatreLoginDTO.setUsername(theatreLogin.getUsername());
        theatreLoginDTO.setPassword(theatreLogin.getPassword());

        return theatreLoginDTO;
    }

    public TheatreLogin returnEntity(TheatreLoginDTO theatreLoginDTO) {

        TheatreLogin theatreLogin = new TheatreLogin();

        theatreLogin.setId(theatreLoginDTO.getId());
        theatreLogin.setUsername(theatreLoginDTO.getUsername());
        theatreLogin.setPassword(theatreLoginDTO.getPassword());

        return theatreLogin;
    }
}

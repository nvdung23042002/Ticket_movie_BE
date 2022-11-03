package com.webmovieticket.service;

import com.webmovieticket.dto.TheatreLoginDTO;
import com.webmovieticket.mapper.TheatreLoginMapper;
import com.webmovieticket.models.TheatreLogin;
import com.webmovieticket.repository.TheatreLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheatreLoginService {

    @Autowired
    private TheatreLoginMapper theatreLoginMapper;

    @Autowired
    private TheatreLoginRepository theatreLoginRepository;

    public List<TheatreLoginDTO> findAll() {
        return theatreLoginRepository.findAll().stream().map(
                theatreLogin -> theatreLoginMapper.returnDTO(theatreLogin)).collect(Collectors.toList());
    }

    public TheatreLoginDTO findById(Long id) {
        return theatreLoginMapper.returnDTO(theatreLoginRepository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    public void addTheatreLogin(TheatreLogin theatreLogin){
        theatreLoginRepository.save(theatreLogin);
    }

    public void updateTheatreLogin(Long id, TheatreLogin theatreLogin) {

        TheatreLogin oldTheatreLogin = theatreLoginRepository.findById(id).orElseGet(() -> null);

        if (oldTheatreLogin != null) {
            oldTheatreLogin.setUsername(theatreLogin.getUsername());
            oldTheatreLogin.setPassword(theatreLogin.getPassword());

            theatreLoginRepository.save(oldTheatreLogin);
        }
    }

    public void deleteTheatreLogin(Long id) {
        theatreLoginRepository.deleteById(id);
    }
}

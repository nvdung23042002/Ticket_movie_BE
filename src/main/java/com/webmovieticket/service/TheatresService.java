package com.webmovieticket.service;

import com.webmovieticket.dto.TheatresDTO;
import com.webmovieticket.mapper.TheatresMapper;
import com.webmovieticket.models.Theatres;
import com.webmovieticket.repository.TheatresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheatresService {

    @Autowired
    private TheatresMapper theatresMapper;

    @Autowired
    private TheatresRepository theatresRepository;

    public List<TheatresDTO> findAll() {
        return theatresRepository.findAll().stream().map(
                theatres -> theatresMapper.returnDTO(theatres)).collect(Collectors.toList());
    }

    public TheatresDTO findById(Long id) {
        return theatresMapper.returnDTO(theatresRepository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    public void addTheatres(Theatres theatres) {
        theatresRepository.save(theatres);
    }

    public void updateTheatres(Long id, Theatres theatres) {

        Theatres oldTheatres = theatresRepository.findById(id).orElseGet(() -> null);

        if (oldTheatres != null) {
            oldTheatres.setName(theatres.getName());
            oldTheatres.setAddress(theatres.getAddress());
            oldTheatres.setEmail(theatres.getEmail());
            oldTheatres.setMobile(theatres.getMobile());
            oldTheatres.setStatus(theatres.getStatus());
            oldTheatres.setType(theatres.getType());
            oldTheatres.setNotifications(theatres.getNotifications());

            theatresRepository.save(oldTheatres);
        }
    }

    public void deleteTheatres(Long id) {
        theatresRepository.deleteById(id);
    }
}

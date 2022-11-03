package com.webmovieticket.service;

import com.webmovieticket.dto.SeatsDTO;
import com.webmovieticket.mapper.SeatsMapper;
import com.webmovieticket.models.Seats;
import com.webmovieticket.repository.SeatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatsService {

    @Autowired
    private SeatsMapper seatsMapper;

    @Autowired
    private SeatsRepository seatsRepository;

    public List<SeatsDTO> findAll() {
        return seatsRepository.findAll().stream().map(
                seats -> seatsMapper.returnDTO(seats)).collect(Collectors.toList());
    }

    public SeatsDTO findById(Long id) {
        return seatsMapper.returnDTO(seatsRepository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    public void addSeats(Seats seats) {
        seatsRepository.save(seats);
    }

    public void updateSeats(Long id, Seats seats) {

        Seats oldSeats = seatsRepository.findById(id).orElseGet(() -> null);

        if (oldSeats != null) {
            oldSeats.setSeat_name(seats.getSeat_name());
            oldSeats.setTd_id(seats.getTd_id());

            seatsRepository.save(oldSeats);
        }
    }

    public void deleteSeats(Long id) {
        seatsRepository.deleteById(id);
    }
}

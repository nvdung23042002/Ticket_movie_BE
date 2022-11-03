package com.webmovieticket.service;

import com.webmovieticket.dto.SeatSessionDTO;
import com.webmovieticket.mapper.SeatSessionMapper;
import com.webmovieticket.models.SeatSession;
import com.webmovieticket.repository.SeatSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatSessionService {

    @Autowired
    private SeatSessionMapper seatSessionMapper;

    @Autowired
    private SeatSessionRepository seatSessionRepository;

    public List<SeatSessionDTO> findAll() {
        return seatSessionRepository.findAll().stream().map(
                seatSession -> seatSessionMapper.returnDTO(seatSession)).collect(Collectors.toList());
    }

    public SeatSessionDTO findById(Long id) {
        return seatSessionMapper.returnDTO(seatSessionRepository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    public void addSeatSession(SeatSession seatSession) {
        seatSessionRepository.save(seatSession);
    }

    public void updateSeatSesstion(Long id, SeatSession seatSession) {

        SeatSession oldSeatSession = seatSessionRepository.findById(id).orElseGet(() -> null);

        if(oldSeatSession != null) {
            oldSeatSession.setTime(seatSession.getTime());
            oldSeatSession.setDate(seatSession.getDate());
            oldSeatSession.setTimestamp(seatSession.getTimestamp());
            oldSeatSession.setIp(seatSession.getIp());

            seatSessionRepository.save(oldSeatSession);
        }
    }

    public void deleteSession(Long id) {
        seatSessionRepository.deleteById(id);
    }
}

package com.webmovieticket.controller;

import com.webmovieticket.dto.SeatSessionDTO;
import com.webmovieticket.models.SeatSession;
import com.webmovieticket.service.SeatSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class SeatSessionController {

    @Autowired
    private SeatSessionService seatSessionService;

    @GetMapping("seatSession")
    public List<SeatSessionDTO> findAll() {
        return seatSessionService.findAll();
    }

    @GetMapping("seatSession/{id}")
    public SeatSessionDTO findById(@PathVariable Long id) {
        return seatSessionService.findById(id);
    }

    @PostMapping("seatSession")
    public void addSeatSession(@RequestBody SeatSession seatSession) {
        seatSessionService.addSeatSession(seatSession);
    }

    @PutMapping("seatSession/{id}")
    public void updateSeatSession(@PathVariable Long id,@RequestBody SeatSession seatSession) {
        seatSessionService.updateSeatSesstion(id, seatSession);
    }

    @DeleteMapping("seatSession/{id}")
    public void deleteSeatSession(@PathVariable Long id) {
        seatSessionService.deleteSession(id);
    }
}

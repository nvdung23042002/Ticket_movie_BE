package com.webmovieticket.controller;

import com.webmovieticket.dto.SeatsDTO;
import com.webmovieticket.models.Seats;
import com.webmovieticket.service.SeatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class SeatsController {

    @Autowired
    private SeatsService seatsService;

    @GetMapping("seats")
    public List<SeatsDTO> findAll() {
        return seatsService.findAll();
    }

    @GetMapping("seats/{id}")
    public SeatsDTO findById(@PathVariable Long id) {
        return seatsService.findById(id);
    }

    @PostMapping("seats")
    public void addSeats(@RequestBody Seats seats) {
        seatsService.addSeats(seats);
    }

    @PutMapping("seats/{id}")
    public void updateSeats(@PathVariable Long id,@RequestBody Seats seats) {
        seatsService.updateSeats(id, seats);
    }

    @DeleteMapping("seats/{id}")
    public void deleteSeats(@PathVariable Long id) {
        seatsService.deleteSeats(id);
    }
}

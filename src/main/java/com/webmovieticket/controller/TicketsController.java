package com.webmovieticket.controller;

import com.webmovieticket.dto.TicketsDTO;
import com.webmovieticket.repository.TicketsRepository;
import com.webmovieticket.service.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "/test/tickets")
public class TicketsController {

    @Autowired
    private TicketsService ticketsService;

    @Autowired
    private TicketsRepository ticketsRepository;

    @GetMapping("")
    public List<TicketsDTO> getTickets(@RequestBody TicketsDTO ticketsDTO) {
        return ticketsService.getTicket(ticketsDTO.getCinemaName(), ticketsDTO.getRoomName(), ticketsDTO.getMovieName(), ticketsDTO.getShowDate(), ticketsDTO.getShowTime());
    }

    @PostMapping("")
    public List<TicketsDTO> insert(@RequestBody TicketsDTO ticketsDTO) {
        return ticketsService.insert(ticketsDTO.getCinemaName(), ticketsDTO.getRoomName(), ticketsDTO.getMovieName(), ticketsDTO.getShowDate(), ticketsDTO.getShowTime(), ticketsDTO.getCategory(), ticketsDTO.getPrice());
    }

    @DeleteMapping("")
    public void delete(@RequestBody TicketsDTO ticketsDTO) {
        ticketsService.delete(ticketsDTO.getCinemaName(), ticketsDTO.getRoomName(), ticketsDTO.getMovieName(), ticketsDTO.getShowDate(), ticketsDTO.getShowTime());
    }
}

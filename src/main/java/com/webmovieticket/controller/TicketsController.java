package com.webmovieticket.controller;

import com.webmovieticket.dto.TicketsDTO;
import com.webmovieticket.dto.TicketsRequest;
import com.webmovieticket.models.Tickets;
import com.webmovieticket.repository.TicketsRepository;
import com.webmovieticket.service.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<TicketsDTO> getTickets(@RequestBody TicketsRequest ticketsRequest) {
        return ticketsService.getTicket(ticketsRequest.getCinemasId(), ticketsRequest.getRoomId(), ticketsRequest.getMovieId(), ticketsRequest.getShowDate(), ticketsRequest.getShowTime());
    }

    @PostMapping("")
    public ResponseEntity<?> insert(@RequestBody TicketsRequest ticketsRequest) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ticketsService.insert(ticketsRequest.getCinemasId(), ticketsRequest.getRoomId(), ticketsRequest.getMovieId(), ticketsRequest.getShowDate(), ticketsRequest.getShowTime(), ticketsRequest.getCategory(), ticketsRequest.getPrice()));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("can not found cinemaId or roomId or movieId");
        }

    }

    @DeleteMapping("")
    public void delete(@RequestBody TicketsRequest ticketsRequest) {
        ticketsService.delete(ticketsRequest.getCinemasId(), ticketsRequest.getRoomId(), ticketsRequest.getMovieId(), ticketsRequest.getShowDate(), ticketsRequest.getShowTime());
    }
}
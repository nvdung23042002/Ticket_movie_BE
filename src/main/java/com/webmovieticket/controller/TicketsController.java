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

    @GetMapping("")
    public List<TicketsDTO> getTickets(@RequestBody TicketsRequest ticketsRequest) {
        return ticketsService.getTicket(ticketsRequest.getCinemasId(), ticketsRequest.getRoomId(), ticketsRequest.getMovieId(), ticketsRequest.getShowDate(), ticketsRequest.getShowMonth(), ticketsRequest.getShowTime());
    }

    @PostMapping("")
    public ResponseEntity<?> insert(@RequestBody TicketsRequest ticketsRequest) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ticketsService.insert(ticketsRequest.getCinemasId(), ticketsRequest.getRoomId(), ticketsRequest.getMovieId(), ticketsRequest.getShowDate(), ticketsRequest.getShowMonth(), ticketsRequest.getShowTime(), ticketsRequest.getCategory(), ticketsRequest.getPrice()));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("can not found cinemaId or roomId or movieId");
        }

    }

    @DeleteMapping("")
    public void delete(@RequestBody TicketsRequest ticketsRequest) {
        ticketsService.delete(ticketsRequest.getCinemasId(), ticketsRequest.getRoomId(), ticketsRequest.getMovieId(), ticketsRequest.getShowDate(), ticketsRequest.getShowMonth(), ticketsRequest.getShowTime());
    }

    @GetMapping("/userid/{userId}")
    public ResponseEntity<?> getTicketsByUserId(@PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(ticketsService.getTicketsByUserId(userId));
    }

    @GetMapping("/audit")
    public ResponseEntity<?> getAudit(@RequestBody TicketsRequest ticketsRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(ticketsService.getAudit(ticketsRequest.getCinemasId(), ticketsRequest.getRoomId(), ticketsRequest.getMovieId(), ticketsRequest.getShowDate(), ticketsRequest.getShowMonth(), ticketsRequest.getShowTime()));
    }

    @GetMapping("/movieId/{movieId}")
    public List<TicketsDTO> getAll(@PathVariable Long movieId) {
        return ticketsService.getAll(movieId);
    }
}

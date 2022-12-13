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

    @PutMapping("")
    public List<TicketsDTO> getTickets(@RequestBody TicketsRequest ticketsRequest) {
        return ticketsService.getTicket(ticketsRequest.getCinemasId(), ticketsRequest.getRoomId(), ticketsRequest.getMovieId(), ticketsRequest.getShowDate(), ticketsRequest.getShowMonth(), ticketsRequest.getShowTime());
    }

//    @GetMapping("")
//    public List<TicketsDTO> getTickets(
//            @RequestParam(value = "cinemaId", required = false) Long cinemaId,
//            @RequestParam(value = "roomId", required = false) Long roomId,
//            @RequestParam(value = "movieId", required = false) Long movieId,
//            @RequestParam(value = "showDate", required = false) String showDate,
//            @RequestParam(value = "showMonth", required = false) String showMonth,
//            @RequestParam(value = "showTime", required = false) String showTime
//    ) {
//        return ticketsService.getTicket(cinemaId, roomId, movieId, showDate, showMonth, showTime);
//    }

    @PostMapping("")
    public ResponseEntity<?> insert(@RequestBody TicketsRequest ticketsRequest) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ticketsService.insert(ticketsRequest.getCinemasId(), ticketsRequest.getRoomId(), ticketsRequest.getMovieId(), ticketsRequest.getShowDate(), ticketsRequest.getShowMonth(), ticketsRequest.getShowTime(), ticketsRequest.getCategory(), ticketsRequest.getPrice()));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("can not found cinemaId or roomId or movieId");
        }

    }

//    Xoá vé
    @DeleteMapping("")
    public void delete(@RequestBody TicketsRequest ticketsRequest) {
        ticketsService.delete(ticketsRequest.getCinemasId(), ticketsRequest.getRoomId(), ticketsRequest.getMovieId(), ticketsRequest.getShowDate(), ticketsRequest.getShowMonth(), ticketsRequest.getShowTime());
    }

//    Lấy ra các vé User đã mua
    @GetMapping("/userid/{userId}")
    public ResponseEntity<?> getTicketsByUserId(@PathVariable Long userId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ticketsService.getTicketsByUserId(userId));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.OK).body("cannot user By id");
        }

    }

    //    Doanh thu và số vé bán được trong 1 buổi chiếu phim.
//    @GetMapping("/audit")
//    public ResponseEntity<?> getAudit(@RequestBody TicketsRequest ticketsRequest) {
//        return ResponseEntity.status(HttpStatus.OK).body(ticketsService.getAudit(ticketsRequest.getCinemasId(), ticketsRequest.getRoomId(), ticketsRequest.getMovieId(), ticketsRequest.getShowDate(), ticketsRequest.getShowMonth(), ticketsRequest.getShowTime()));
//    }

    @GetMapping("/movieId/{movieId}")
    public List<TicketsDTO> getAll(@PathVariable Long movieId) {
        return ticketsService.getAll(movieId);
    }

    //    Doanh thu và số vé bán được của 1 phim
    @GetMapping("/auditByid/{movieId}")
    public ResponseEntity<?> getAuditById(@PathVariable Long movieId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ticketsService.getAuditByMovie(movieId));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.OK).body("cannot movie By id");
        }
    }
}

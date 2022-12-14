package com.webmovieticket.service;

import com.webmovieticket.dto.AuditDTO;
import com.webmovieticket.dto.TicketsDTO;
import com.webmovieticket.mapper.TicketsMapper;
import com.webmovieticket.models.*;
import com.webmovieticket.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketsService {
    @Autowired
    private TicketsRepository ticketsRepository;

    @Autowired
    private SeatsRepository seatsRepository;

    @Autowired
    private CinemasRepository cinemasRepository;

    @Autowired
    private CinemaRoomRepository cinemaRoomRepository;

    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    private TicketsMapper ticketsMapper;

//    Danh sách các vé trong 1 buổi chiếu phim.
    @Transactional
    public List<TicketsDTO> getTicket(Long cinemaId, Long roomId, Long movieId, String showDate, String showMonth, String showTime) {
        return ticketsRepository.getTickets(cinemaId, roomId, movieId, showDate, showMonth, showTime).stream().map(tickets -> ticketsMapper.toDto(tickets)).collect(Collectors.toList());
    }

//    Thêm vé cho 1 buổi xem phim.
    @Transactional
    public List<TicketsDTO> insert(Long cinemaId, Long roomId, Long movieId, String showDate, String showMonth, String showTime, String category, Integer price) {
//        List<TicketsDTO> oldTicketsDTOList = TicketsService.this.getTicket(cinemaId, roomId, movieId, showDate, showMonth, showTime);
        List<Tickets> oldTickets = ticketsRepository.getTicketsBySuatChieu(cinemaId, roomId, showDate, showMonth, showTime);
        if (oldTickets.size() > 0) {
            return null;
        }
        else {
            List<TicketsDTO> ticketsDTOList = new ArrayList<>();
            for (Seats seats : seatsRepository.findAll()) {
                Tickets tickets = new Tickets();
                tickets.setCinemas(cinemasRepository.findById(cinemaId).orElseThrow(() -> new RuntimeException()));
                tickets.setCinemaRoom(cinemaRoomRepository.findById(roomId).orElseThrow(() -> new RuntimeException()));
                tickets.setMovies(moviesRepository.findById(movieId).orElseThrow(() -> new RuntimeException()));
                tickets.setShowDate(showDate);
                tickets.setShowMonth(showMonth);
                tickets.setShowTime(showTime);
                tickets.setCategory(category);
                tickets.setSeats(seats);
                tickets.setCategory(category);
                tickets.setPrice(price);

                ticketsRepository.save(tickets);
                ticketsDTOList.add(ticketsMapper.toDto(tickets));
            }
            return ticketsDTOList;
        }
    }

//    Xoá vé phim.
    @Transactional
    public void delete(Long cinemaId, Long roomId, Long movieId, String showDate, String showMonth, String showTime) {
        List<TicketsDTO> ticketsDTOList = TicketsService.this.getTicket(cinemaId, roomId, movieId, showDate, showMonth, showTime);
        for (TicketsDTO ticketsDTO : ticketsDTOList) {
            ticketsRepository.deleteById(ticketsDTO.getId());
        }
    }

    @Transactional
    public List<TicketsDTO> getTicketsByUserId(Long userId) {
        return ticketsRepository.getTicketsByUserId(userId).stream().map(tickets -> ticketsMapper.toDto(tickets)).collect(Collectors.toList());
    }

//    Doanh thu và số vé bán được trong 1 buổi chiếu phim.
//    public AuditDTO getAudit(Long cinemaId, Long roomId, Long movieId, String showDate, String showMonth, String showTime) {
//        AuditDTO auditDTO = new AuditDTO();
//        Integer sumAmount = 0;
//        Integer sumNumberSeat = 0;
//        for (TicketsDTO ticketsDTO : this.getTicket(cinemaId, roomId, movieId, showDate, showMonth, showTime)) {
//            if (ticketsDTO.getPaymentStatus()) {
//                sumAmount += ticketsDTO.getPrice();
//                sumNumberSeat += 1;
//            }
//        }
//        auditDTO.setSumAmount(sumAmount);
//        auditDTO.setSumNumberSeat(sumNumberSeat);
//        return auditDTO;
//    }

    //    Doanh thu và số vé bán được của 1 phim
    public AuditDTO getAuditByMovie(Long movieId) {
        List<Object[]> objects = ticketsRepository.getAuditByMovie(movieId);
        return new AuditDTO(Integer.parseInt(objects.get(0)[0].toString()), Integer.parseInt(objects.get(0)[1].toString()));
    }

    @Transactional
    public List<TicketsDTO> getAll(Long movieId) {
        return ticketsRepository.getAll(movieId).stream().map(tickets -> ticketsMapper.toDto(tickets)).collect(Collectors.toList());
    }
}

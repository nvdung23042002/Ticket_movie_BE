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
    public List<TicketsDTO> getTicket(Long cinemaId, Long roomId, Long movieId, String showDate, String showMonth, String showTime) {

        List<Object[]> ticketList = ticketsRepository.getTickets(cinemaId, roomId, movieId, showDate, showMonth, showTime);
        List<TicketsDTO> ticketsDTOList = new ArrayList<>();

        for(Object[] obj : ticketList) {
            TicketsDTO ticketsDTO = new TicketsDTO();

            if (obj[0] != null) {
                ticketsDTO.setId(Long.parseLong(obj[0].toString()));
            }
            if (obj[1] != null) {
                ticketsDTO.setPrice(Integer.parseInt(obj[1].toString()));
            }
            if (obj[2] != null) {
                ticketsDTO.setShowDate(obj[2].toString());
            }

            if (obj[3] != null) {
                ticketsDTO.setShowMonth(obj[3].toString());
            }

            if (obj[4] != null) {
                ticketsDTO.setShowTime(obj[4].toString());
            }
            if (obj[5] != null) {
                ticketsDTO.setPaymentStatus(Boolean.parseBoolean(obj[5].toString()));
            }
            if (obj[6] != null) {
                ticketsDTO.setMovieName(obj[6].toString());
            }
            if (obj[7] != null) {
                ticketsDTO.setCinemaName(obj[7].toString());
            }
            if (obj[8] != null) {
                ticketsDTO.setRoomName(obj[8].toString());
            }
            if (obj[9] != null) {
                ticketsDTO.setSeatName(obj[9].toString());
            }
            ticketsDTOList.add(ticketsDTO);
        }
        return ticketsDTOList;
    }

//    Thêm vé cho 1 buổi xem phim.
    @Transactional
    public List<TicketsDTO> insert(Long cinemaId, Long roomId, Long movieId, String showDate, String showMonth, String showTime, String category, Integer price) {
        List<TicketsDTO> oldTicketsDTOList = TicketsService.this.getTicket(cinemaId, roomId, movieId, showDate, showMonth, showTime);
        if (oldTicketsDTOList.size() > 0) {
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
        List<TicketsDTO> results = new ArrayList<>();
        for (Tickets tickets : ticketsRepository.getTicketsByUserId(userId)) {
            results.add(ticketsMapper.toDto(tickets));
        }
        return results;
    }

    public AuditDTO getAudit(Long cinemaId, Long roomId, Long movieId, String showDate, String showMonth, String showTime) {
        AuditDTO auditDTO = new AuditDTO();
        Integer sumAmount = 0;
        Integer sumNumberSeat = 0;
        for (TicketsDTO ticketsDTO : this.getTicket(cinemaId, roomId, movieId, showDate, showMonth, showTime)) {
            if (ticketsDTO.getPaymentStatus()) {
                sumAmount += ticketsDTO.getPrice();
                sumNumberSeat += 1;
            }
        }
        auditDTO.setSumAmount(sumAmount);
        auditDTO.setSumNumberSeat(sumNumberSeat);
        return auditDTO;
    }

    public List<TicketsDTO> getAll(Long movieId) {

        List<Object[]> ticketList = ticketsRepository.getAll(movieId);
        List<TicketsDTO> ticketsDTOList = new ArrayList<>();

        for(Object[] obj : ticketList) {
            TicketsDTO ticketsDTO = new TicketsDTO();

            if (obj[0] != null) {
                ticketsDTO.setId(Long.parseLong(obj[0].toString()));
            }
            if (obj[1] != null) {
                ticketsDTO.setPrice(Integer.parseInt(obj[1].toString()));
            }
            if (obj[2] != null) {
                ticketsDTO.setShowDate(obj[2].toString());
            }

            if (obj[3] != null) {
                ticketsDTO.setShowMonth(obj[3].toString());
            }

            if (obj[4] != null) {
                ticketsDTO.setShowTime(obj[4].toString());
            }
            if (obj[5] != null) {
                ticketsDTO.setPaymentStatus(Boolean.parseBoolean(obj[5].toString()));
            }
            if (obj[6] != null) {
                ticketsDTO.setMovieName(obj[6].toString());
            }
            if (obj[7] != null) {
                ticketsDTO.setCinemaName(obj[7].toString());
            }
            if (obj[8] != null) {
                ticketsDTO.setRoomName(obj[8].toString());
            }
            if (obj[9] != null) {
                ticketsDTO.setSeatName(obj[9].toString());
            }
            ticketsDTOList.add(ticketsDTO);
        }
        return ticketsDTOList;
    }
}

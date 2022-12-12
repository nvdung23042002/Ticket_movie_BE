package com.webmovieticket.mapper;

import com.webmovieticket.dto.TicketsDTO;
import com.webmovieticket.models.Tickets;
import com.webmovieticket.repository.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketsMapper {

    @Autowired
    private TicketsRepository ticketsRepository;

    public TicketsDTO toDto(Tickets tickets) {
        TicketsDTO result = new TicketsDTO();

        if (tickets.getId() != null) {
            result.setId(tickets.getId());
        }

        if (tickets.getIsPresent() != null) {
            result.setIsPresent(tickets.getIsPresent());
        }

        if (tickets.getMovies() != null) {
            result.setMovieName(tickets.getMovies().getName());
        }

        if (tickets.getCinemas() != null) {
            result.setCinemaName(tickets.getCinemas().getCinemaName());
        }

        if (tickets.getCinemaRoom() != null) {
            result.setRoomName(tickets.getCinemaRoom().getRoomName());
        }

        if (tickets.getSeats() != null) {
            result.setSeatName(tickets.getSeats().getSeatName());
        }

        if (tickets.getShowDate() != null) {
            result.setShowDate(tickets.getShowDate());
        }

        if (tickets.getShowMonth() != null) {
            result.setShowMonth(tickets.getShowMonth());
        }

        if (tickets.getShowTime() != null) {
            result.setShowTime(tickets.getShowTime());
        }

        if (tickets.getCategory() != null) {
            result.setCategory(tickets.getCategory());
        }

        if (tickets.getPrice() != null) {
            result.setPrice(tickets.getPrice());
        }

        if (tickets.getUser() != null) {
            result.setCustomerId(tickets.getUser().getId());
        }

        if (tickets.getPaymentStatus() != null) {
            result.setPaymentStatus(tickets.getPaymentStatus());
        }

        if (tickets.getPaymentDate() != null) {
            result.setPaymentDate(tickets.getPaymentDate());
        }

        if (tickets.getUser() != null) {
            result.setUserId(tickets.getUser().getId());
        }


        return result;
    }

    public Tickets toEntity(TicketsDTO ticketsDTO) {
        Tickets result = new Tickets();

        result.setIsPresent(ticketsDTO.getIsPresent());

        result.setShowDate(ticketsDTO.getShowDate());
        result.setShowTime(ticketsDTO.getShowTime());
        result.setCategory(ticketsDTO.getCategory());
        result.setPrice(ticketsDTO.getPrice());
        result.setPaymentStatus(ticketsDTO.getPaymentStatus());
        result.setPaymentDate(ticketsDTO.getPaymentDate());

        return result;
    }

//    public TicketsDTO update(Tickets oldTickets, Tickets newTickets) {
//
//        if (newTickets.getIsPresent() != null) {
//            oldTickets.setIsPresent(newTickets.getIsPresent());
//        }
//
//        if (newTickets.getMovies().getName() != null) {
//            oldTickets.setMovieName(newTickets.getMovies().getName());
//        }
//
//        if (newTickets.getCinemas().getCinemaName() != null) {
//            oldTickets.setCinemaName(newTickets.getCinemas().getCinemaName());
//        }
//
//        if (newTickets.getCinemaRoom().getRoomName() != null) {
//            oldTickets.setRoomName(newTickets.getCinemaRoom().getRoomName());
//        }
//
//        if (newTickets.getSeats().getSeatName() != null) {
//            oldTickets.setSeatName(newTickets.getSeats().getSeatName());
//        }
//
//        if (newTickets.getShowDate() != null) {
//            oldTickets.setShowDate(newTickets.getShowDate());
//        }
//
//        if (newTickets.getShowTime() != null) {
//            oldTickets.setShowTime(newTickets.getShowTime());
//        }
//
//        if (newTickets.getCategory() != null) {
//            oldTickets.setCategory(newTickets.getCategory());
//        }
//
//        if (newTickets.getPrice() != null) {
//            oldTickets.setPrice(newTickets.getPrice());
//        }
//
//        if (newTickets.getPrice() != null) {
//            oldTickets.setPrice(newTickets.getPrice());
//        }
//
//        if (newTickets.getUser() != null) {
//            oldTickets.setCustomerId(newTickets.getUser().getId());
//        }
//
//        if (newTickets.getPaymentStatus() != null) {
//            oldTickets.setPaymentStatus(newTickets.getPaymentStatus());
//        }
//
//        if (newTickets.getPaymentDate() != null) {
//            oldTickets.setPaymentDate(newTickets.getPaymentDate());
//        }
//
//        return oldTickets;
//    }
}

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

        result.setId(tickets.getId());
        result.setCreatedAt(tickets.getCreatedAt());
        result.setDeletedAt(tickets.getDeletedAt());
        result.setIsPresent(tickets.getIsPresent());

        result.setMovieName(tickets.getMovies().getName());
        result.setCinemaName(tickets.getCinemas().getCinemaName());
        result.setRoomName(tickets.getCinemaRoom().getRoomName());
        result.setSeatName(tickets.getSeats().getSeatName());

        result.setShowDate(tickets.getShowDate());
        result.setShowTime(tickets.getShowTime());
        result.setCategory(tickets.getCategory());
        result.setPrice(tickets.getPrice());
        result.setCustomerId(tickets.getCustomerId());
        result.setPaymentStatus(tickets.getPaymentStatus());
        result.setPaymentDate(tickets.getPaymentDate());

        return result;
    }

    public Tickets toEntity(TicketsDTO ticketsDTO) {
        Tickets result = new Tickets();

        result.setCreatedAt(ticketsDTO.getCreatedAt());
        result.setDeletedAt(ticketsDTO.getDeletedAt());
        result.setIsPresent(ticketsDTO.getIsPresent());

        result.setShowDate(ticketsDTO.getShowDate());
        result.setShowTime(ticketsDTO.getShowTime());
        result.setCategory(ticketsDTO.getCategory());
        result.setPrice(ticketsDTO.getPrice());
        result.setCustomerId(ticketsDTO.getCustomerId());
        result.setPaymentStatus(ticketsDTO.getPaymentStatus());
        result.setPaymentDate(ticketsDTO.getPaymentDate());

        return result;
    }

    public TicketsDTO update(Tickets oldTickets, Tickets newTickets) {

        oldTickets.setCreatedAt(newTickets.getCreatedAt());
        oldTickets.setDeletedAt(newTickets.getDeletedAt());
        oldTickets.setIsPresent(newTickets.getIsPresent());

        oldTickets.setMovies(newTickets.getMovies());
        oldTickets.setCinemas(newTickets.getCinemas());
        oldTickets.setSeats(newTickets.getSeats());
        oldTickets.setCinemaRoom(newTickets.getCinemaRoom());

        oldTickets.setShowDate(newTickets.getShowDate());
        oldTickets.setShowTime(newTickets.getShowTime());
        oldTickets.setCategory(newTickets.getCategory());
        oldTickets.setPrice(newTickets.getPrice());
        oldTickets.setCustomerId(newTickets.getCustomerId());
        oldTickets.setPaymentStatus(newTickets.getPaymentStatus());
        oldTickets.setPaymentDate(newTickets.getPaymentDate());

        return TicketsMapper.this.toDto(oldTickets);
    }
}

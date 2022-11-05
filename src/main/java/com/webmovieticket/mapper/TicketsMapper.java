package com.webmovieticket.mapper;

import com.webmovieticket.dto.TicketsDTO;
import com.webmovieticket.models.Tickets;
import org.springframework.stereotype.Component;

@Component
public class TicketsMapper {

    public TicketsDTO toDto(Tickets tickets) {
        TicketsDTO result = new TicketsDTO();

        result.setId(tickets.getId());
        result.setCreatedAt(tickets.getCreatedAt());
        result.setDeletedAt(tickets.getDeletedAt());
        result.setIsPresent(tickets.getIsPresent());
        result.setSeatName(tickets.getSeatName());
        result.setShowDate(tickets.getShowDate());
        result.setShowTime(tickets.getShowTime());
        result.setCategory(tickets.getCategory());
        result.setTheaterId(tickets.getTheaterId());
        result.setLocalId(tickets.getLocalId());
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
        result.setSeatName(ticketsDTO.getSeatName());
        result.setShowDate(ticketsDTO.getShowDate());
        result.setShowTime(ticketsDTO.getShowTime());
        result.setCategory(ticketsDTO.getCategory());
        result.setTheaterId(ticketsDTO.getTheaterId());
        result.setLocalId(ticketsDTO.getLocalId());
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
        oldTickets.setSeatName(newTickets.getSeatName());
        oldTickets.setShowDate(newTickets.getShowDate());
        oldTickets.setShowTime(newTickets.getShowTime());
        oldTickets.setCategory(newTickets.getCategory());
        oldTickets.setTheaterId(newTickets.getTheaterId());
        oldTickets.setLocalId(newTickets.getLocalId());
        oldTickets.setPrice(newTickets.getPrice());
        oldTickets.setCustomerId(newTickets.getCustomerId());
        oldTickets.setPaymentStatus(newTickets.getPaymentStatus());
        oldTickets.setPaymentDate(newTickets.getPaymentDate());

        return TicketsMapper.this.toDto(oldTickets);
    }
}

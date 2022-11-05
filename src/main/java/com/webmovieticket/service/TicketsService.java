package com.webmovieticket.service;

import com.webmovieticket.dto.TicketsDTO;
import com.webmovieticket.mapper.TicketsMapper;
import com.webmovieticket.models.Tickets;
import com.webmovieticket.repository.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketsService {
    @Autowired
    private TicketsRepository ticketsRepository;

    @Autowired
    private TicketsMapper ticketsMapper;

    public List<TicketsDTO> findAll() {
        return ticketsRepository.findAll().stream().map(
                tickets -> ticketsMapper.toDto(tickets)).collect(Collectors.toList());
    }

    public TicketsDTO findById(Long id) {
        return ticketsMapper.toDto(
                ticketsRepository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    @Transactional
    public TicketsDTO insert(Tickets tickets) {
        return ticketsMapper.toDto(ticketsRepository.save(tickets));
    }

    public TicketsDTO update(Long id, Tickets tickets) {
        Tickets oldTickets = ticketsRepository.findById(id).orElseGet(() -> null);
        if (oldTickets != null) {
            return ticketsMapper.update(oldTickets, tickets);
        } else {
            return null;
        }
    }

    @Transactional
    public void delete(Long[] ids) {
        for (Long id : ids) {
            ticketsRepository.deleteById(id);
        }
    }
}

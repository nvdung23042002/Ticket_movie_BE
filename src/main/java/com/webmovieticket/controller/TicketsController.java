package com.webmovieticket.controller;

import com.webmovieticket.dto.TicketsDTO;
import com.webmovieticket.models.Tickets;
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

    @GetMapping("")
    public List<TicketsDTO> findAll() {
        return ticketsService.findAll();
    }

    @GetMapping("/{id}")
    public TicketsDTO findById(@PathVariable Long id) {
        return ticketsService.findById(id);
    }

    @PostMapping("")
    public TicketsDTO insert(@RequestBody Tickets tickets) {
        return ticketsService.insert(tickets);
    }

    @PutMapping("/{id}")
    public TicketsDTO update(@PathVariable Long id, @RequestBody Tickets tickets) {
        return ticketsService.update(id, tickets);
    }

    @DeleteMapping("")
    public void delete(@RequestBody Long[] ids) {
        ticketsService.delete(ids);
    }
}

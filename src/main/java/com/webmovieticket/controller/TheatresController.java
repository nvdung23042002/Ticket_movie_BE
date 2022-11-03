package com.webmovieticket.controller;

import com.webmovieticket.dto.TheatresDTO;
import com.webmovieticket.models.Theatres;
import com.webmovieticket.service.TheatresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TheatresController {

    @Autowired
    private TheatresService theatresService;

    @GetMapping("theatres")
    public List<TheatresDTO> findAll() {
        return theatresService.findAll();
    }

    @GetMapping("theatres/{id}")
    public TheatresDTO findById(@PathVariable Long id) {
        return theatresService.findById(id);
    }

    @PostMapping("theatres")
    public void addTheatres(@RequestBody Theatres theatres) {
        theatresService.addTheatres(theatres);
    }

    @PutMapping("theatres/{id}")
    public void updateTheatres(@PathVariable Long id,@RequestBody Theatres theatres) {
        theatresService.updateTheatres(id, theatres);
    }

    @DeleteMapping("theatres/{id}")
    public void deleteTheatres(@PathVariable Long id) {
        theatresService.deleteTheatres(id);
    }
}


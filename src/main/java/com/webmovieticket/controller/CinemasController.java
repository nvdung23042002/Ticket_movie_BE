package com.webmovieticket.controller;

import com.webmovieticket.models.Cinemas;
import com.webmovieticket.repository.CinemasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "test/cinemas")
public class CinemasController {
    @Autowired
    private CinemasRepository cinemasRepository;

    @GetMapping("")
    public List<Cinemas> getAllCinemas() {
        return cinemasRepository.findAll();
    }
}

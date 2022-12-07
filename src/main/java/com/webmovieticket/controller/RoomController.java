package com.webmovieticket.controller;

import com.webmovieticket.models.CinemaRoom;
import com.webmovieticket.repository.CinemaRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "test/room")
public class RoomController {
    @Autowired
    private CinemaRoomRepository cinemaRoomRepository;

    @GetMapping("")
    public List<CinemaRoom> findAll() {
        return cinemaRoomRepository.findAll();
    }
}

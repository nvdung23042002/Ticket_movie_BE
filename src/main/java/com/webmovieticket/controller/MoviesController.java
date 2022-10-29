package com.webmovieticket.controller;

import com.webmovieticket.dto.MoviesDTO;
import com.webmovieticket.dto.ResponseObject;
import com.webmovieticket.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "api/v1/movies")
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping("")
    public ResponseEntity<ResponseObject> getAllMovies() {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "query success!", moviesService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getMoviesById(@PathVariable Long id) {
        return moviesService.findById(id);
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> insertMovies(@RequestBody MoviesDTO moviesDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "update success!", moviesService.save(moviesDTO)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateMovies(@RequestBody MoviesDTO moviesDTO, @PathVariable Long id) {
        moviesDTO.setId(id);

        return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "update success!", moviesService.save(moviesDTO)));
    }
}

package com.webmovieticket.service;

import com.webmovieticket.dto.MoviesDTO;
import com.webmovieticket.dto.ResponseObject;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MoviesService {
    public List<MoviesDTO> findAll();
    public ResponseEntity<ResponseObject> findById(Long id);
    List<MoviesDTO> findByName(String name);
    public MoviesDTO save(MoviesDTO moviesDTO);
    public void delete(Long[] ids);
}

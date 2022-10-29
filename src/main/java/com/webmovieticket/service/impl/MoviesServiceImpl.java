package com.webmovieticket.service.impl;

import com.webmovieticket.dto.MoviesDTO;
import com.webmovieticket.dto.ResponseObject;
import com.webmovieticket.models.Movies;
import com.webmovieticket.repository.MoviesRepository;
import com.webmovieticket.service.MoviesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
public class MoviesServiceImpl implements MoviesService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MoviesRepository moviesRepository;

    @Override
    public List<MoviesDTO> findAll() {
        return moviesRepository.findAll().stream().map(movies -> modelMapper.map(movies, MoviesDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<ResponseObject> findById(Long id) {
        Movies movies = moviesRepository.findById(id).orElseGet(() -> null);
        if (movies != null) {
            System.out.println("getname: " + movies.getName());
            MoviesDTO moviesDTO = modelMapper.map(movies, MoviesDTO.class);
            System.out.println("getnameDTO: " + moviesDTO.getName());
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "query success!", modelMapper.map(movies, MoviesDTO.class)));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("failed", "cannot find movies by id = " + id, ""));
        }
    }

    @Override
    public List<MoviesDTO> findByName(String name) {
        List<Movies> moviesList = moviesRepository.findByName(name);
        return moviesList.stream().map(movies -> modelMapper.map(movies, MoviesDTO.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MoviesDTO save(MoviesDTO moviesDTO) {
        Movies movies = modelMapper.map(moviesDTO, Movies.class);
        if (moviesDTO.getId() != null) {
            Movies oldmovies = moviesRepository.findById(moviesDTO.getId()).orElseThrow(() -> new RuntimeException());
            modelMapper.map(movies, oldmovies);
            System.out.println("hello update");
            System.out.println("iddto : " + moviesDTO.getId());
            System.out.println("id : " + movies.getId());
            return modelMapper.map(moviesRepository.save(oldmovies), MoviesDTO.class);
        }
        System.out.println("hello insert");
        return modelMapper.map(moviesRepository.save(movies), MoviesDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long[] ids) {
        for (Long id : ids) {
            moviesRepository.deleteById(id);
        }
    }
}

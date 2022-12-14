package com.webmovieticket.service;

import com.webmovieticket.dto.MoviesDTO;
import com.webmovieticket.mapper.MoviesMapper;
import com.webmovieticket.models.Movies;
import com.webmovieticket.models.Tickets;
import com.webmovieticket.repository.MoviesRepository;
import com.webmovieticket.repository.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class MoviesService  {

    @Autowired
    private MoviesMapper moviesMapper;

    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    private TicketsRepository ticketsRepository;

    public List<MoviesDTO> findAll() {
        return moviesRepository.findAll().stream().map(
                movies -> moviesMapper.toDto(movies)).collect(Collectors.toList()
        );
    }

    public MoviesDTO findById(Long id) {
        return moviesMapper.toDto(moviesRepository.findById(id).orElseThrow(() -> new RuntimeException()));
    }

    public List<MoviesDTO> findByRating(int ratingSize) {
        return moviesRepository.findMoviesByRating(ratingSize).stream().map(
                movies -> moviesMapper.toDto(movies)).collect(Collectors.toList());
    }

    @Transactional
    public MoviesDTO insert(Movies movies) {
        return moviesMapper.toDto(moviesRepository.save(movies));
    }

    @Transactional
    public MoviesDTO update(Long id, Movies movies) {
        Movies oldMovies = moviesRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return moviesMapper.toDto(moviesRepository.save(moviesMapper.update(oldMovies, movies)));
    }

//    Xoá nhiều phim
    @Transactional
    public void delete(Long[] ids) {
        for (Long id : ids) {
            moviesRepository.deleteById(id);
        }
    }

//    Xoá 1 phim

//    Company company = companyRepository.findById(id).orElseThrow(() -> new RuntimeException());
//            for (JobPost jobPost : jobPostRepository.findAllByCompany(company)) {
//        jobPostRepository.delete(jobPost);
//    }
//            companyRepository.deleteById(id);
    @Transactional
    public void deleteById(Long id) {
        Movies movies = moviesRepository.findById(id).orElseThrow(() -> new RuntimeException());
        for (Tickets tickets : ticketsRepository.findAllByMovies(movies)) {
            ticketsRepository.delete(tickets);
        }
        moviesRepository.deleteById(id);
    }
}

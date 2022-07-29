package com.dh.catalogservice.service.impl;

import com.dh.catalogservice.repository.MovieRepository;
import com.dh.catalogservice.repository.SerieRepository;
import com.dh.catalogservice.dto.CatalogDTO;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import com.dh.catalogservice.service.CatalogService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final SerieRepository serieRepository;
    private final MovieRepository movieRepository;

    @Override
    public Movie getMovieById(String movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }

    @Override
    @CircuitBreaker(name="catalogServiceCircuitBreaker")
    @Retry(name="catalogServiceCircuitBreaker")
    public CatalogDTO getCatalogByGenre(String genre) {
        List<Movie> movies = movieRepository.findAllByGenre(genre);
        List<Serie> series = serieRepository.findAllByGenre(genre);
        return new CatalogDTO(genre.toUpperCase(),movies,series);
    }

    @Override
    @CircuitBreaker(name="catalogServiceCircuitBreaker")
    @Retry(name="catalogServiceCircuitBreaker")
    public void addNewMovie(Movie movie){
        movieRepository.save(movie);
    }

    @Override
    @CircuitBreaker(name="catalogServiceCircuitBreaker")
    @Retry(name="catalogServiceCircuitBreaker")
    public void addNewSerie(Serie serie) {
        serieRepository.save(serie);
    }

}
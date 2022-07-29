package com.dh.movieservice.service.impl;

import com.dh.movieservice.repository.MovieRepository;
import com.dh.movieservice.model.Movie;
import com.dh.movieservice.service.MovieService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private RabbitTemplate rabbitTemplate;

    @Override
    @CircuitBreaker(name="movie-service")
    @Retry(name="movie-service")
    public List<Movie> getAllByGenre(String genre) {
        return movieRepository.findAllByGenre(genre);
    }

    @Override
    @CircuitBreaker(name="movie-service")
    @Retry(name="movie-service")
    public Movie getMovieById(Integer movieId) {
        return movieRepository.findById(movieId).orElse(null);
    }

    @Override
    @CircuitBreaker(name="movie-service")
    @Retry(name="movie-service")
    public Movie saveMovie(Movie movie) {
        String movieNameAux = movie.getName();
        movie.setName(movieNameAux.toLowerCase());
        Movie movieSaved = movieRepository.save(movie);
        rabbitTemplate.convertAndSend("MovieServiceQueue",movie);
        return movieSaved;
    }
}

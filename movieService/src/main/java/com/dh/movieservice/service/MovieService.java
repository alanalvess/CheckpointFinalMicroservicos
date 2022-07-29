package com.dh.movieservice.service;

import com.dh.movieservice.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllByGenre(String genre);

    Movie getMovieById(Integer movieId);

    Movie saveMovie(Movie movie);
}

package com.alanalves.movieservice.service;

import com.alanalves.movieservice.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAllByGenre(String genre);

    Movie getMovieById(Integer movieId);

    Movie saveMovie(Movie movie);
}

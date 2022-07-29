package com.dh.catalogservice.service;

import com.dh.catalogservice.dto.CatalogDTO;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;

public interface CatalogService {

    Movie getMovieById(String movieId);

    CatalogDTO getCatalogByGenre(String genre);

    void addNewMovie(Movie movie);

    void addNewSerie(Serie serie);
}

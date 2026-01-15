package com.alanalves.catalogservice.service;

import com.alanalves.catalogservice.dto.CatalogDTO;
import com.alanalves.catalogservice.dto.MovieDTO;
import com.alanalves.catalogservice.dto.SerieDTO;

public interface CatalogService {

    MovieDTO getMovieById(Integer movieId);

    SerieDTO getSerieById(Integer serieId);

    CatalogDTO getCatalogByGenre(String genre);

}

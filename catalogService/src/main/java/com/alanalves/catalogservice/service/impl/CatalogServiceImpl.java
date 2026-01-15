package com.alanalves.catalogservice.service.impl;

import com.alanalves.catalogservice.dto.MovieDTO;
import com.alanalves.catalogservice.dto.SerieDTO;
import com.alanalves.catalogservice.repository.MovieFeignClient;
import com.alanalves.catalogservice.repository.SerieFeignClient;
import com.alanalves.catalogservice.dto.CatalogDTO;
import com.alanalves.catalogservice.service.CatalogService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CatalogServiceImpl implements CatalogService {

    private final SerieFeignClient serieFeignClient;
    private final MovieFeignClient movieFeignClient;

    @Override
    public MovieDTO getMovieById(Integer movieId) {
        return movieFeignClient.getMovieById(movieId);
    }

    @Override
    public SerieDTO getSerieById(Integer serieId) {
        return serieFeignClient.getSeriesById(serieId);
    }

    @Override
    @CircuitBreaker(name="catalogServiceCircuitBreaker")
    @Retry(name="catalogServiceCircuitBreaker")
    public CatalogDTO getCatalogByGenre(String genre) {
        List<MovieDTO> movieDTOS = movieFeignClient.getMoviesByGenre(genre);
        List<SerieDTO> series = serieFeignClient.getSeriesByGenre(genre);
        return new CatalogDTO(genre.toUpperCase(), movieDTOS,series);
    }

}
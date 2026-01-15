package com.alanalves.catalogservice.repository;

import com.alanalves.catalogservice.dto.SerieDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "SERIE-SERVICE")
public interface SerieFeignClient {

    @GetMapping("/series/genre/{genreName}")
    List<SerieDTO> getSeriesByGenre(@PathVariable String genre);

    @GetMapping("/series/{serieId}")
    SerieDTO getSeriesById(@PathVariable Integer serieId);
}


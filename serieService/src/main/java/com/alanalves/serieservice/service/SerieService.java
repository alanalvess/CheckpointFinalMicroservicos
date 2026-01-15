package com.alanalves.serieservice.service;

import com.alanalves.serieservice.model.Serie;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SerieService {
    List<Serie> getSeriesByGenre(String genre);

    List<Serie> getSeries();

    Serie getSerieById(Integer serieId);

    Serie saveSerie(Serie serie);
}

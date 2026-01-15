package com.alanalves.serieservice.service.impl;

import com.alanalves.serieservice.repository.ChapterRepository;
import com.alanalves.serieservice.repository.SeasonRepository;
import com.alanalves.serieservice.repository.SerieRepository;
import com.alanalves.serieservice.model.Chapter;
import com.alanalves.serieservice.model.Season;
import com.alanalves.serieservice.model.Serie;
import com.alanalves.serieservice.service.SerieService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SerieServiceImpl implements SerieService {

    private RabbitTemplate rabbitTemplate;

    private final SerieRepository serieRepository;

    private final SeasonRepository seasonRepository;
    private final ChapterRepository chapterRepository;


    @Override
    @CircuitBreaker(name="serie-service")
    @Retry(name="serie-service")
    public List<Serie> getSeriesByGenre(String genre) {
        return serieRepository.findAllByGenre(genre);
    }

    @Override
    @CircuitBreaker(name="serie-service")
    @Retry(name="serie-service")
    public List<Serie> getSeries() {
        return serieRepository.findAll();
    }

    @Override
    @CircuitBreaker(name="serie-service")
    @Retry(name="serie-service")
    public Serie getSerieById(Integer serieId) {
        return serieRepository.findById(serieId).orElse(null);
    }

    @Override
    @CircuitBreaker(name="serie-service")
    @Retry(name="serie-service")
    public Serie saveSerie(Serie serie) {
        List<Season> seasonsToBeCreated = serie.getSeasons().stream().filter(season -> season.getId() == null).collect(Collectors.toList());

        for(Season season : seasonsToBeCreated){
            if(!season.getChapters().isEmpty()) {
                for(Chapter chapter : season.getChapters()){
                    Chapter chapterToAux = new Chapter();
                    chapterToAux = chapterRepository.save(chapter);
                    chapter.setId(chapterToAux.getId());
                }
            }
        }

        List<Season> seasonsSaved = seasonsToBeCreated.stream().map(seasonRepository::save).collect(Collectors.toList());

        serie.getSeasons().clear();
        serie.getSeasons().addAll(seasonsSaved);
        rabbitTemplate.convertAndSend("SerieServiceQueue",serie);
        return serieRepository.save(serie);
    }
}

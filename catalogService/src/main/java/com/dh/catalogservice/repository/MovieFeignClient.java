package com.dh.catalogservice.repository;

import com.dh.catalogservice.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "MOVIE-SERVICE")
public interface MovieFeignClient {

    @GetMapping("/movie/{genre}")
    List<Movie> getMoviesByGenre(@PathVariable String genre);

    @GetMapping("/movie/id/{movieId}")
    Movie getMovieById(@PathVariable Long movieId);

    @PostMapping("/movie/save")
    Movie saveNewMovie(@RequestBody Movie movie);
}

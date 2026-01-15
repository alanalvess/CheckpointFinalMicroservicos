package com.alanalves.catalogservice.repository;

import com.alanalves.catalogservice.dto.MovieDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "MOVIE-SERVICE")
public interface MovieFeignClient {

    @GetMapping("/movie/{genre}")
    List<MovieDTO> getMoviesByGenre(@PathVariable String genre);

    @GetMapping("/movie/id/{movieId}")
    MovieDTO getMovieById(@PathVariable Integer movieId);
}

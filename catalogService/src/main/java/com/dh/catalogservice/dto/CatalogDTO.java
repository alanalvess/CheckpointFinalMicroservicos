package com.dh.catalogservice.dto;

import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.model.Serie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CatalogDTO {

    String name;
    List<Movie> movies;
    List<Serie> series;

}

package com.alanalves.serieservice.repository;

import com.alanalves.serieservice.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Integer> {

    List<Serie> findAllByGenre(String genre);
}

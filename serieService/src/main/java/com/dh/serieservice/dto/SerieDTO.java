package com.dh.serieservice.dto;

import com.dh.serieservice.model.Season;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SerieDTO {

    private String id;
    private String name;
    private String genre;
    private List<Season> seasons;
}

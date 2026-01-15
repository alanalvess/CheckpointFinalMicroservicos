package com.alanalves.serieservice.dto;

import com.alanalves.serieservice.model.Chapter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SeasonDTO {

    private Integer id;

    private Integer seasonNumber;

    private List<Chapter> chapters;
}

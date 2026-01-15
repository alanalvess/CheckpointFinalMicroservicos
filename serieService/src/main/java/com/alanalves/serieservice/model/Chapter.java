package com.alanalves.serieservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "chapters")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Chapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;


    private Integer number;
    private String urlStream;

    @ManyToOne
    @JoinColumn(name = "season_id", nullable = false)
    private Season season;

}

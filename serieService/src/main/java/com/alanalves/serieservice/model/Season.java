package com.alanalves.serieservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "seasons")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer seasonNumber;

    @OneToMany(mappedBy = "season")
    private List<Chapter> chapters;

    @ManyToOne
    @JoinColumn(name = "serie_id", nullable = false)
    private Serie serie;
}

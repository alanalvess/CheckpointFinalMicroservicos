package com.alanalves.serieservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "series")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String genre;

    @OneToMany(mappedBy = "serie")
    private List<Season> seasons;

}

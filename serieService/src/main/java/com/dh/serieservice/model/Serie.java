package com.dh.serieservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "series")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Serie {

    @Id
    private String id;
    private String name;

    @Indexed
    private String genre;
    private List<Season> seasons;

}

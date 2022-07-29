package com.dh.serieservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "seasons")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Season {

    @Id
    private String id;

    private Integer seasonNumber;
    private List<Chapter> chapters;
}

package com.dh.serieservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChapterDTO {
    private ObjectId id;
    private String name;
    private Integer number;
    private String urlStream;
}

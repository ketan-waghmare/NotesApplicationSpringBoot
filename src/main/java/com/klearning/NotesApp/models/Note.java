package com.klearning.NotesApp.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;
import java.time.LocalDateTime;

@Data
@Document(collection ="notes")
@Getter
@Setter
public class Note {

    @Id
    private ObjectId id;
    private String title;
    private String description;
    private LocalDateTime createdAt = LocalDateTime.now();
}

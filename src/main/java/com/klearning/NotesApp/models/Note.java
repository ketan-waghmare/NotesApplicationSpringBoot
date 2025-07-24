package com.klearning.NotesApp.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.annotation.Documented;

@Data
@Document(collection ="notes")
@Getter
@Setter
public class Note {

    @Id
    private ObjectId id;
    private String title;
    private String description;
    // add time as createdAt
}

package com.klearning.NotesApp.models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "users")
public class User {

    @Id
    private ObjectId id;
    private String userName;
    private String email;
    private String password;
}

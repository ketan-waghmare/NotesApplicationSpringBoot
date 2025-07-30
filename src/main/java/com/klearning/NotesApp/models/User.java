package com.klearning.NotesApp.models;

import com.mongodb.annotations.NotThreadSafe;
import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "users")
public class User {

    @Id
    private ObjectId id;

    @Indexed
    @NonNull
    private String userName;
    private String email;
    @NonNull
    private String password;

    @DBRef
    private List<Note> noteList = new ArrayList<>();
}

package com.klearning.NotesApp.repository;

import com.klearning.NotesApp.models.Note;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface NoteRepository extends MongoRepository<Note, ObjectId> {
}

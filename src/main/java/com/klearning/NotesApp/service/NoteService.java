package com.klearning.NotesApp.service;

import com.klearning.NotesApp.models.Note;
import com.klearning.NotesApp.repository.NoteRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public Note createNote(@RequestBody Note note) {
        return noteRepository.save(note);
    }

    public ResponseEntity<?> getAllNotes() {
        return new ResponseEntity<>(noteRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> findNoteById(ObjectId objectId) {
        Optional<Note> findByIdNote = noteRepository.findById(objectId);
        return new ResponseEntity<>(findByIdNote,HttpStatus.OK);
    }

    public ResponseEntity<Note> updateNote(ObjectId objectId, Note note) {
        Note existing = noteRepository.findById(objectId).orElseThrow();
        existing.setTitle(note.getTitle());
        existing.setDescription(note.getDescription());
        return ResponseEntity.ok(noteRepository.save(existing));
    }

    public boolean deleteNote(ObjectId id) {
        noteRepository.deleteById(id);
        return true;
    }
}

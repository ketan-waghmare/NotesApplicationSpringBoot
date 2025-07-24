package com.klearning.NotesApp.controller;


import com.klearning.NotesApp.models.Note;
import com.klearning.NotesApp.service.NoteService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notes")
public class NotesController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/greeting")
    public String greeting() {
        return "Hello from notesApp";
    }

    @PostMapping("/create-note")
    public ResponseEntity<?> createNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.createNote(note), HttpStatus.OK);
    }

    @GetMapping("/get-notes")
    public ResponseEntity<?> getAllNotes() {
       return noteService.getAllNotes();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findNoteById(@PathVariable ObjectId id) {
        return noteService.findNoteById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateNote(@PathVariable ObjectId id, @RequestBody Note note) {
        return noteService.updateNote(id,note);
    }

    @DeleteMapping("{id}")
    public boolean deleteNoteById(@PathVariable ObjectId id) {
        return noteService.deleteNote(id);
    }

}

package com.klearning.NotesApp.controller;


import com.klearning.NotesApp.models.Note;
import com.klearning.NotesApp.models.User;
import com.klearning.NotesApp.service.NoteService;
import com.klearning.NotesApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/notes")
public class NotesController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private UserService userService;

    @GetMapping("/greeting")
    public String greeting() {
        return "Hello from notesApp";
    }

    @PostMapping("/create-note")
    public ResponseEntity<?> createNote(@RequestBody Note note) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        noteService.createNote(note,userName);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getNotesForUsers() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findByUserName(userName);
        List<Note> noteList = user.getNoteList();
        if(noteList != null && !noteList.isEmpty()) {
            return new ResponseEntity<>(noteList, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/id/{noteId}")
    public ResponseEntity<?> getNoteById(@PathVariable ObjectId noteId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        User user = userService.findByUserName(name);
        List<Note> noteList = user.getNoteList().stream().filter(x -> x.getId().equals(noteId)).toList();
        if(!noteList.isEmpty()) {
            Optional<Note> note = noteService.findNoteById(noteId);
            if(note.isPresent()) {
                return new ResponseEntity<>(note.get(),HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/id/{noteId}")
    public ResponseEntity<?> deletNoteById(@PathVariable ObjectId noteId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        boolean removed = noteService.deleteNotById(noteId,userName);
        if(removed)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/id/{noteId}")
    public ResponseEntity<?> updateNoteById(
            @PathVariable ObjectId noteId,
            @RequestBody Note newNote
    ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = userService.findByUserName(userName);
        List<Note> list = user.getNoteList().stream().filter(x -> x.getId().equals(noteId)).toList();
        if(!list .isEmpty()) {
            Optional<Note> noteById = noteService.findNoteById(noteId);
            if(noteById.isPresent()) {
                Note oldNote = noteById.get();
                oldNote.setTitle(newNote.getTitle() != null && !newNote.getTitle().isEmpty() ? newNote.getTitle() : oldNote.getTitle());
                oldNote.setDescription(newNote.getDescription() != null && !newNote.getDescription().isEmpty() ? newNote.getDescription() : oldNote.getDescription());
                return new ResponseEntity<>(oldNote, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}

package com.klearning.NotesApp.service;

import com.klearning.NotesApp.models.Note;
import com.klearning.NotesApp.models.User;
import com.klearning.NotesApp.repository.NoteRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public void createNote(Note note,String userName) {
        try{
            User user = userService.findByUserName(userName);
            Note savedNote = noteRepository.save(note);
            user.getNoteList().add(savedNote);
            userService.saveUser(user);
        } catch (Exception e) {
            System.out.println("Exception_while_saving = "+e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<?> getAllNotes() {
        return new ResponseEntity<>(noteRepository.findAll(), HttpStatus.OK);
    }

    public Optional<Note> findNoteById(ObjectId objectId) {
        return noteRepository.findById(objectId);
    }

    public ResponseEntity<Note> updateNote(ObjectId objectId, Note note) {
        Note existing = noteRepository.findById(objectId).orElseThrow();
        existing.setTitle(note.getTitle());
        existing.setDescription(note.getDescription());
        return ResponseEntity.ok(noteRepository.save(existing));
    }

    @Transactional
    public boolean deleteNotById(ObjectId id, String userName) {
        boolean removed = false;
        try {
            User user = userService.findByUserName(userName);
            removed = user.getNoteList().removeIf(x -> x.getId().equals(id));
            if(removed) {
                userService.saveUser(user);
                noteRepository.deleteById(id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong..!!");
        }
        return removed;
    }
}

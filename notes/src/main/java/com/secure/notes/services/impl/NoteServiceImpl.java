package com.secure.notes.services.impl;

import com.secure.notes.models.Note;
import com.secure.notes.repositories.AuditLogRepository;
import com.secure.notes.services.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.secure.notes.repositories.NoteRepository;
import com.secure.notes.services.NoteService;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private AuditLogService auditLogService;

    @Override
    public Note createNoteForUser(String username, String content) {
        Note note=new Note();
        note.setContent(content);
        note.setOwnerUsername(username);
        Note savedNote= noteRepository.save(note);
        auditLogService.logNoteCreation(username,savedNote);
        return savedNote;
    }

    @Override
    public Note updateNoteForUser(Long noteId, String content, String username) {
        Note note= noteRepository.findById(noteId).orElseThrow(()->new RuntimeException("Note not Found"));
        note.setContent(content);
        Note savedNote= noteRepository.save(note);
        auditLogService.logNoteUpdate(username,savedNote);
        return savedNote;
    }

    @Override
    public void deleteNoteForUser(Long noteId, String username) {
        Note note=noteRepository.findById(noteId).orElseThrow(()->new RuntimeException("Note not Found"));
        noteRepository.delete(note);
        auditLogService.logNoteDeletion(username,noteId);
    }

    @Override
    public List<Note> getNotesForUser(String username) {
        return noteRepository.findByOwnerUsername(username);
    }
}

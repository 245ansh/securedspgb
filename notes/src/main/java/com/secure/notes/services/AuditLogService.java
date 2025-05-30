package com.secure.notes.services;

import com.secure.notes.models.AuditLog;
import com.secure.notes.models.Note;

import java.util.List;

public interface AuditLogService {
    void logNoteDeletion(String username, Long noteId);
    void logNoteCreation(String username, Note note);
    void logNoteUpdate(String username, Note note);
    List<AuditLog> getAllAuditLogs();
    List<AuditLog> getAuditLogsForNoteId(Long id);
}

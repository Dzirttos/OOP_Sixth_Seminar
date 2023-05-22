package controllers;

import java.util.List;

import model.NoteBook;
import model.Notes;

public class NotesController {
    private final NoteBook noteBook;

    public NotesController(NoteBook noteBook) {
        this.noteBook = noteBook;
    }

    public void saveNote(Notes note) {
        NoteBook.createNote(note);
    }

    public Notes readNote(String noteId) throws Exception {
        List<Notes> allNotes = noteBook.getAllNotes();
        for (Notes note : allNotes) {
            if (note.getId().equals(noteId)) {
                return note;
            }
        }
        throw new Exception("\u001B[31mNote is not found!\u001B[37m");
    }

    public List<Notes> getNotes() {
        return noteBook.getAllNotes();
    }

    public void updateNote(Notes updatedNote) {
        noteBook.createNote(updatedNote);
    }

    public void deleteNote(String noteId) {
        noteBook.deleteNote(noteId);
    }
}

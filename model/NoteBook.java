package model;

import java.util.List;

public interface NoteBook {
    List<Notes> getAllNotes();
    String createNote(Notes note);

    void updateNote(Notes note);
    void deleteNote(String id);
}

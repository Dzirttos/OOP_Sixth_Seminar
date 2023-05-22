package model;

import java.util.List;

public interface NoteBook {
    List<Notes> getAllNotes();
    String createNote(Notes notes);

    void updateNote(Notes notes);
    void deleteNote(String id);
}

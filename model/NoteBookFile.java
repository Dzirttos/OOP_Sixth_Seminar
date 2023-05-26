package model;

import java.util.ArrayList;
import java.util.List;

public class NoteBookFile implements NoteBook {

    private NotesMapper notesMapper;


    // public void NotesMapper(NotesMapper notesMapper) {
    //     this.notesMapper = new NotesMapper();
    // }

    public NotesMapper getNotesMapper() {
        return notesMapper = new NotesMapper();
    }

    private NotesOperation notesOperation;

    public NoteBookFile(NotesOperation notesOperation) {
        this.notesOperation = notesOperation;
    }

    @Override
    public List<Notes> getAllNotes() {
        List<String> lines = notesOperation.readAllLines();
        List<Notes> notes = new ArrayList<>();
        for (String line : lines) {
            notes.add(getNotesMapper().map(line));
        }
        return notes;
    }

    @Override
    public String createNote(Notes note) {
        List<Notes> notes = getAllNotes();
        int max = 0;
        for (Notes item : notes) {
            int id = Integer.parseInt(item.getId());
            if (max < id) {
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        note.setId(id);
        notes.add(note);
        saveAllNotes(notes);
        return id;

    }

    private void saveAllNotes(List<Notes> notes) {
        List<String> lines = new ArrayList<>();
        for (Notes item : notes) {
            lines.add(notesMapper.map(item));
        }
        notesOperation.saveAllLines(lines);

    }

    @Override
    public void updateNote(Notes updatedNote) {
        List<Notes> notes = this.getAllNotes();
        for (Notes note : notes) {
            if (note.getId().equals(updatedNote.getId())) {
                note.setHeadline(updatedNote.getHeadline());
                note.setText(updatedNote.getText());
                note.setDateOfFilling(updatedNote.getDateOfFilling());
            }
        }
        saveAllNotes(notes);
    }

    @Override
    public void deleteNote(String id) {
        List<Notes> notes = this.getAllNotes();
        for (Notes note : notes) {
            if (note.getId().equals(id))
                notes.remove(note);
        }
        saveAllNotes(notes);
    }

}

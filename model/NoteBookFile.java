package model;

import java.util.ArrayList;
import java.util.List;

public class NoteBookFile implements NoteBook{
   
    private NotesMapper notesMapper;

    public NotesMapper getNotesMapper() {
        return notesMapper;
    }

    // public void setNotesMapper(NotesMapper notesMapper) {
    //     this.notesMapper = notesMapper;
    // }

    private NotesOperation notesOperation;

    public NotesOperation getNotesOperation() {
        return notesOperation;
    }

    @Override
    public List<Notes> getAllNotes() {
        List<String> lines = notesOperation.readAllLines();
        List<Notes> allNotes = new ArrayList<>();
        for (String line : lines) {
            allNotes.add(notesMapper.map(line));
        }
        return allNotes;
    }


    @Override
    public String createNote(Notes note) {
        List<Notes> allNotes = getAllNotes();
        int max = 0;
        for (Notes item : allNotes){
            int id = Integer.parseInt(item.getId());
            if (max < id) max = id;
        }
        int newId = max + 1;
        String id = String.format("%s", newId);
        note.setId(id);
        allNotes.add(note);
        saveAllNotes(allNotes);
        return id;

    }
    

    private void saveAllNotes(List<Notes> allNotes) {
        List<String> lines = new ArrayList<>();
        for (Notes item : allNotes){
            lines.add(notesMapper.map(item));
        }
        notesOperation.saveAllLines(lines);

    }


    @Override
    public void updateNote(Notes updatedNote) {
        List<Notes> allNotes = this.getAllNotes();
        for (Notes note : allNotes){
            if(note.getId().equals(updatedNote.getId())){
                note.setHeadline(updatedNote.getHeadline());
                note.setText(updatedNote.getText());
                note.setDateOfFilling(updatedNote.getDateOfFilling());
            }
        }
        saveAllNotes(allNotes);
    }

    @Override
    public void deleteNote(String id) {
        List<Notes> allNotes = this.getAllNotes();
        for (Notes note : allNotes){
            if (note.getId().equals(id)) allNotes.remove(note);
        }
        saveAllNotes(allNotes);
    }
    

}

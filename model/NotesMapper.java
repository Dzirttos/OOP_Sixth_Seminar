package model;


public class NotesMapper {
    public String map(Notes note){
        return String.format("s%,s%,s%,s%,", note.getId(), note.getHeadline(), note.getText(), note.getDateOfFilling());
    }
    
    public Notes map(String line){
        String[] lines = line.split(" || ");
        return new Notes(lines[0], lines[1], lines[2], lines[3]);
    }
}
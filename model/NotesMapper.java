package model;


public class NotesMapper {
    public String map(Notes notes){
        return String.format("s%,s%,s%,s%,", notes.getId(), notes.getHeadline(), notes.getText(), notes.getDateOfFilling());
    }
    
    public Notes map(String line){
        String[] lines = line.split(" || ");
        return new Notes(lines[0], lines[1], lines[2], lines[3]);
    }
}
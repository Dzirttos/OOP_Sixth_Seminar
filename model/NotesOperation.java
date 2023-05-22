package model;

import java.util.List;

public interface NotesOperation {
    List<String> readAllLines();

    void saveAllLines(List<String> lines);
}

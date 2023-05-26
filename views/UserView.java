package views;

import java.util.List;
import java.util.Scanner;

import controllers.NotesController;
import model.Notes;

public class UserView {

    private NotesController notesController;

    public UserView(NotesController notesController) {
        this.notesController = notesController;
    }

    private Validation validate = new Validation();

    public void commandsList() {
        System.out.println("\u001B[32mList of available commands: \n" +
                "NONE - does nothing\n" +
                "READ - show note headline and it's text via id\n" +
                "CREATE - create a new note\n" +
                "UPDATE - modify current note\n" +
                "LIST - show list of all notes\n" +
                "DELETE - delete specific note via id\n" +
                "EXIT - exit the programm\n\u001B[37m");
    }

    public void run() {
        Commands com = Commands.NONE;

        while (true) {
            try {
                String command = startUI("Please enter a command: ");
                com = Commands.valueOf(command.toUpperCase());

                if (com == Commands.EXIT)
                    return;

                switch (com) {
                    case READ:
                        readNote();
                        break;
                    case CREATE:
                        createNote();
                        break;
                    case UPDATE:
                        updateNote();
                        break;
                    case LIST:
                        printAllNotes();
                        break;
                    case DELETE:
                        deleteNote();
                        // break;
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String startUI(String message) {
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        return in.nextLine();
    }

    private String readNote() {
        String id = startUI("Note id: ");
        try {
            Notes note = notesController.readNote(id);
            System.out.println(note);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return id;
    }

    private Notes inputNote() {
        String headline;
        String text;
        String dateOfFilling;
        headline = startUI("Enter the headline: ");
        text = startUI("Please enter your text for the note: ");
        do {
            dateOfFilling = startUI("Please enter the date of filling in DD.MM.YYYY format: ");
        } while (validate.checkDateOfFilling(dateOfFilling));

        return new Notes(headline, text, dateOfFilling);
    }

    private void createNote() {
        notesController.saveNote(inputNote());
    }

    private void updateNote() {
        String id = readNote();
        Notes updatedNote = inputNote();
        updatedNote.setId(id);
        notesController.updateNote(updatedNote);
    }

    private void deleteNote() throws Exception {
        String noteId = readNote();
        notesController.deleteNote(noteId);
    }

    private void printAllNotes() {
        List<Notes> notes = notesController.getNotes();
        for (Notes note : notes) {
            System.out.println(note);
        }
    }
}

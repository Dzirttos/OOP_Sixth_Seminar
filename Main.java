import controllers.NotesController;
import model.NoteBook;
import model.NoteBookFile;
import model.NotesOperation;
import model.NotesOperationImpl;
import views.UserView;

/**
* Написать проект, "Записки", содержащий работу с записками из консоли 
(можно прочитать все записки, создать одну записку, отредактировать записку, удалить, и прочитать одну записку по ID). 
Записка содержит в себе как минимум 3 поля Id, заголовок и текст, можно добавить дату. 
Хранение по вашему выбору, можно в текстовом файле (или каждая записка в одном файле, как вам удобнее).
 */
public class Main {

    public static void main(String[] args) {
        System.out.print("\033[H\033[J");

        NotesOperation notesOperation = new NotesOperationImpl("notes.txt");
        NoteBook noteBook = new NoteBookFile(notesOperation);
        NotesController controller = new NotesController(noteBook);
        UserView view = new UserView(controller);
        view.commandsList();
        view.run();

    }
}
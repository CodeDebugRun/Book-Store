package BookStore01;

// Removed unused import java.util.Scanner;
// Import Map if it were used directly here, but it's accessed via SelectBook

public class Runner {

    public static void main(String[] args) {
        // Load books from CSV or get default list, and assign to SelectBook.bookListMap.
        SelectBook.bookListMap = BookDataManager.loadBooks();

        // If bookListMap is empty after load (e.g. books.csv doesn't exist and createDefaultBookList also returned empty or was modified not to return much)
        // you might want to ensure there's some data or inform the user.
        // For now, we assume loadBooks handles the logic of returning a usable map (either from CSV or default).

        MainMenu.selectOption();

        // Note: Saving books is handled in MainMenu's exit option.
        // If the application could terminate in other ways, saving might be needed elsewhere too.
    }

}

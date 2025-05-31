package BookStore01;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Collections; // For Collections.max

public class AdminOperations {

    public static void addNewBook() {
        Scanner scanner = new Scanner(System.in);
        String isbn = "";
        String title = "";
        String author = "";
        int yearPublished = 0;
        double price = 0.0;
        int stock = 0;
        boolean validInput;

        System.out.println("\n--- Yeni Kitap Ekleme ---");

        // Get ISBN
        System.out.print("ISBN: ");
        isbn = scanner.nextLine();

        // Get Title
        System.out.print("Baslik: ");
        title = scanner.nextLine();

        // Get Author
        System.out.print("Yazar: ");
        author = scanner.nextLine();

        // Get Year Published
        validInput = false;
        while (!validInput) {
            System.out.print("Basim Yili: ");
            try {
                yearPublished = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (yearPublished > 0 && yearPublished <= java.time.Year.now().getValue() + 1) { // Basic validation for year
                    validInput = true;
                } else {
                    System.out.println("Gecersiz yil. Lutfen gecerli bir yil girin.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Gecersiz giris. Lutfen sayisal bir yil girin.");
                scanner.nextLine(); // Consume invalid input
            }
        }

        // Get Price
        validInput = false;
        while (!validInput) {
            System.out.print("Fiyat: ");
            try {
                price = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                if (price >= 0) {
                    validInput = true;
                } else {
                    System.out.println("Fiyat negatif olamaz. Lutfen gecerli bir fiyat girin.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Gecersiz giris. Lutfen sayisal bir fiyat girin (örn: 25.99).");
                scanner.nextLine(); // Consume invalid input
            }
        }

        // Get Stock
        validInput = false;
        while (!validInput) {
            System.out.print("Stok Adedi: ");
            try {
                stock = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (stock >= 0) {
                    validInput = true;
                } else {
                    System.out.println("Stok negatif olamaz. Lutfen gecerli bir stok adedi girin.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Gecersiz giris. Lutfen sayisal bir stok adedi girin.");
                scanner.nextLine(); // Consume invalid input
            }
        }

        Book newBook = new Book(isbn, title, author, yearPublished, price, stock);

        // Generate new unique ID
        int newBookId = 1001; // Default if map is empty
        if (!SelectBook.bookListMap.isEmpty()) {
            newBookId = Collections.max(SelectBook.bookListMap.keySet()) + 1;
        }

        // Ensure the generated ID is truly unique in case of manual deletions or non-sequential additions in the future.
        // This is a simple approach; a more robust system might use UUIDs or database sequences.
        while(SelectBook.bookListMap.containsKey(newBookId)){
            newBookId++;
        }


        SelectBook.bookListMap.put(newBookId, newBook);

        System.out.println("\nKitap basariyla eklendi: ID " + newBookId + " - " + newBook.getTitle());
        System.out.println(newBook.toString()); // Show details of the added book

        System.out.println();
        MainMenu.selectOption();
    }
}

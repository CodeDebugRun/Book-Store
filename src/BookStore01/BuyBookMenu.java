package BookStore01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BuyBookMenu {

    // Modified to accept a Book object
    public static void buyMenu(Book selectedBook) {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        // Displaying the selected book's title might be a good idea here
        System.out.println("Sectiginiz kitap: " + selectedBook.getTitle());
        System.out.println("Ne yapmak istersiniz?");
        String buyOptionsMenu = "**************************\n " +
                "1. Kitabi satin al\n " +
                "2. Istek listesine ekle\n " +
                "3. Ana menuye don\n " +
                "4. Cikis\n " +
                "**************************\n ";

        int selectedBuyOption = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println(buyOptionsMenu);
            System.out.print("Lutfen seciminizi giriniz: ");
            try {
                selectedBuyOption = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (selectedBuyOption >= 1 && selectedBuyOption <= 4) {
                    validInput = true;
                } else {
                    System.out.println("Gecersiz secenek. Lutfen 1 ile 4 arasinda bir numara girin.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Gecersiz giris. Lutfen bir numara girin.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        switch (selectedBuyOption) {
            case 1:
                BuyBookSelection.buyListedBook(selectedBook); // Pass selectedBook
                break;
            case 2:
                BuyBookSelection.addToWishList(selectedBook); // Pass selectedBook
                break;
            case 3:
                BuyBookSelection.returnToMainMenu(); // No book needed here
                break;
            case 4:
                System.out.println("Ziyaretiniz icin tesekkurler");
                break;
        }
    }
}

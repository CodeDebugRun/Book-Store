package BookStore01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {

    public static void selectOption() {
        Scanner scanner = new Scanner(System.in);
        String optionsMenu = "**************************\n " +
                "1. ISBN ile kitap secme\n " +
                "2. Isim ile kitap secme\n " +
                "3. Basim yili ile kitap secme\n " +
                "4. ID ile kitap secme\n " +
                "5. Yazar ile kitap secme\n " +
                "6. Yeni kitap ekle (Admin)\n " + // New option
                "7. Cikis\n " +                  // Exit option updated
                "**************************\n ";

        int selectedOption = 0;
        boolean validInput = false;
        int maxOption = 7; // Updated max option for validation

        while (!validInput) {
            System.out.println(optionsMenu);
            System.out.print("Lutfen seciminizi girin : ");
            try {
                selectedOption = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (selectedOption >= 1 && selectedOption <= maxOption) {
                    validInput = true;
                } else {
                    System.out.println("Gecersiz secenek. Lutfen 1 ile " + maxOption + " arasinda bir numara girin.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Gecersiz giris. Lutfen bir numara girin.");
                scanner.nextLine(); // Consume the invalid input
            }
        }

        switch (selectedOption) {
            case 1:
                SelectBook.SelectBookWithISBN();
                break;
            case 2:
                SelectBook.SelectBookWithName();
                break;
            case 3:
                SelectBook.SelectBookWithYearPublished();
                break;
            case 4:
                SelectBook.SelectBookWithIdNumber();
                break;
            case 5:
                SelectBook.SelectBookWithAuthor();
                break;
            case 6: // New case for adding book
                AdminOperations.addNewBook();
                break;
            case 7: // Updated case for exit
                BookDataManager.saveBooks(SelectBook.bookListMap); // Save books before exiting
                System.out.println("Ziyaretiniz icin tesekkur ederiz. Veriler kaydedildi.");
                // scanner.close(); // Consider closing the main application scanner here if it's passed around or static to this class
                break;
        }
    }
}

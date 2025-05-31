package BookStore01;

import java.util.*;

public class SelectBook {
    static Scanner scanner = new Scanner(System.in);
    // Initialized as an empty map. Runner will load data into it.
    public static Map<Integer, Book> bookListMap = new TreeMap<>();

    public static void SelectBookWithISBN() {
        System.out.print("ISBN numarasini giriniz : ");
        String isbnNumber = scanner.next();
        scanner.nextLine(); // Consume newline
        boolean found = false;
        for (Map.Entry<Integer, Book> entry : bookListMap.entrySet()) {
            Book book = entry.getValue();
            if (book.getIsbn().equalsIgnoreCase(isbnNumber)) {
                System.out.println(book);
                BuyBookMenu.buyMenu(book); // Pass the found book
                found = true;
                return;
            }
        }
        if (!found) {
            System.out.println("ISBN " + isbnNumber + " olan kitap bulunamadi");
            MainMenu.selectOption();
        }
    }

    public static void SelectBookWithName() {
        System.out.print("Kitap adini giriniz :  ");
        String bookName = scanner.nextLine();
        // No need for the isEmpty check if we consistently use nextLine for string inputs
        // and consume newlines after nextInt/next/nextDouble.
        boolean found = false;
        for (Map.Entry<Integer, Book> entry : bookListMap.entrySet()) {
            Book book = entry.getValue();
            if (book.getTitle().toLowerCase().contains(bookName.toLowerCase())) {
                System.out.println(book);
                BuyBookMenu.buyMenu(book); // Pass the found book
                found = true;
                return;
            }
        }
        if (!found) {
            System.out.println(bookName + " adinda kitap bulunamadi");
            MainMenu.selectOption();
        }
    }

    public static void SelectBookWithYearPublished() {
        System.out.print("Basim yili giriniz :  ");
        int yearPublished = 0;
        if (scanner.hasNextInt()){
            yearPublished = scanner.nextInt();
            scanner.nextLine(); // consume newline
        } else {
            System.out.println("Gecersiz yil formati.");
            scanner.nextLine(); // consume invalid input
            MainMenu.selectOption();
            return;
        }

        boolean found = false;
        for (Map.Entry<Integer, Book> entry : bookListMap.entrySet()) {
            Book book = entry.getValue();
            if (book.getYearPublished() == yearPublished) {
                System.out.println(book);
                BuyBookMenu.buyMenu(book); // Pass the found book
                found = true;
                return;
            }
        }
        if (!found) {
            System.out.println(yearPublished + " yilinda basilan kitap bulunamadi");
            MainMenu.selectOption();
        }
    }

    public static void SelectBookWithIdNumber() {
        System.out.print("ID numarasini giriniz :  ");
        int idNumber = 0;
        if(scanner.hasNextInt()){
            idNumber = scanner.nextInt();
            scanner.nextLine(); // consume newline
        } else {
            System.out.println("Gecersiz ID formati.");
            scanner.nextLine(); // consume invalid input
            MainMenu.selectOption();
            return;
        }

        Book book = bookListMap.get(idNumber);
        if (book != null) {
            System.out.println(book);
            BuyBookMenu.buyMenu(book); // Pass the found book
        } else {
            System.out.println("ID number " + idNumber + " olan kitap bulunamadi");
            MainMenu.selectOption();
        }
    }

    public static void SelectBookWithAuthor() {
        System.out.print("Yazar adini giriniz :  ");
        String authorName = scanner.nextLine();
        boolean found = false;
        for (Map.Entry<Integer, Book> entry : bookListMap.entrySet()) {
            Book book = entry.getValue();
            if (book.getAuthor().toLowerCase().contains(authorName.toLowerCase())) {
                System.out.println(book);
                BuyBookMenu.buyMenu(book); // Pass the found book
                found = true;
                return;
            }
        }
        if (!found) {
            System.out.println(authorName + "'a ait kitap bulunamadi");
            MainMenu.selectOption();
        }
    }
}

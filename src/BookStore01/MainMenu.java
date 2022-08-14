package BookStore01;

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
                "6. Cikis\n " +
                "**************************\n ";


        System.out.println(optionsMenu);
        System.out.println("Lutfen seciminizi girin : ");
        int selectedOption = scanner.nextInt();

        switch (selectedOption) {
            case 1 : SelectBook.SelectBookWithISBN();
                break;
            case 2 : SelectBook.SelectBookWithName();
                break;
            case 3 : SelectBook.SelectBookWithYearPublished();
                break;
            case 4 : SelectBook.SelectBookWithIdNumber();
                break;
            case 5 : SelectBook.SelectBookWithAuthor();
                break;
            case 6 :
                System.out.println("Ziyaretiniz icin tesekkur ederiz.");;
                break;
            default:
                System.out.println("Gecerli bir secim girin");

        }
    }
}

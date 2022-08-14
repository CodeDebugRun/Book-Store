package BookStore01;

import java.util.Scanner;

public class BuyBookMenu {

    public static void buyMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Aradiginiz kitap stokta var. Ne yapmak istersiniz.");
        String buyOptionsMenu = "**************************\n " +
                "1. Kitabi satin al\n " +
                "2. Istek listesine ekle\n " +
                "3. Ana menuye don\n " +
                "4. Cikis\n " +
                "**************************\n ";
        System.out.println(buyOptionsMenu);
        System.out.println("Lutfen seciminizi giriniz. ");
        int selectedBuyOption = scanner.nextInt();

        switch (selectedBuyOption) {
            case 1 : BuyBookSelection.buyListedBook();
                break;
            case 2 : BuyBookSelection.addToWishList();
                break;
            case 3 : BuyBookSelection.returnToMainMenu();
                break;
            case 4 : System.out.println("Ziyaretiniz icin tesekkurler");
                break;
            default:
                System.out.println("Gecerli bir secim girin");
    }
}
}

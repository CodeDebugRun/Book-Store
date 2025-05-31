package BookStore01;

public class BuyBookSelection {
    public static void buyListedBook(Book selectedBook) {
        System.out.println("Processing purchase for: " + selectedBook.getTitle()); // Initial message

        if (selectedBook.getStock() > 0) {
            selectedBook.setStock(selectedBook.getStock() - 1);
            System.out.println("You have successfully purchased '" + selectedBook.getTitle() + "'.");
            System.out.println("Remaining stock: " + selectedBook.getStock());
        } else {
            System.out.println("Sorry, '" + selectedBook.getTitle() + "' is currently out of stock.");
        }

        // TODO: In a real application, payment processing would happen before decrementing stock.
        // TODO: Consider if there are other actions after a purchase attempt (e.g., show receipt, different menu).

        System.out.println(); // Add a blank line for better readability before returning to menu
        MainMenu.selectOption(); // Return to main menu
    }

    public static void addToWishList(Book selectedBook) {
        // TODO: In a real application, this would involve storing the book in a user-specific list.
        System.out.println("'" + selectedBook.getTitle() + "' has been added to your wishlist.");

        System.out.println(); // Add a blank line for better readability
        MainMenu.selectOption(); // Return to main menu
    }

    public static void returnToMainMenu() {
        MainMenu.selectOption();
    }
}

# Bookstore Management Application

## Description
A simple Java console application for managing a bookstore. It allows users to browse, search, "buy" books (which updates stock counts), and add new books to the inventory. Book data is persisted in a `books.csv` file.

## Features
*   Browse and search for books by:
    *   ISBN
    *   Title
    *   Author
    *   Publication Year
    *   Internal ID
*   Add new books to the store's inventory (Admin function).
*   "Purchase" books: If a book is in stock, its stock count is decremented.
*   Add books to a wishlist (conceptual: currently prints a confirmation message).
*   Data Persistence: The list of books and their current stock levels are saved to `books.csv` when the application exits and loaded from this file on startup. If `books.csv` is not found, a default list of books is loaded.

## How to Build and Run

### Prerequisites
*   Java Development Kit (JDK) installed (e.g., JDK 11 or newer).

### Compilation
1.  Open a terminal or command prompt.
2.  Navigate to the `src` directory of the project:
    ```bash
    cd src
    ```
3.  Compile the Java files. This command will place the `.class` files alongside the `.java` files within the `BookStore01` directory:
    ```bash
    javac BookStore01/*.java
    ```
4.  Navigate back to the project root directory:
    ```bash
    cd ..
    ```

### Running the Application
1.  Ensure you are in the project root directory (the directory containing the `src` folder and this `README.md`).
2.  Run the application using the following command:
    ```bash
    java -cp src BookStore01.Runner
    ```
    (The `-cp src` part tells Java to look for classes starting from the `src` directory).

## Project Structure
*   `src/BookStore01/Runner.java`: The main entry point of the application.
*   `src/BookStore01/Book.java`: Defines the `Book` object, representing a book's attributes (ISBN, title, author, year, price, stock).
*   `src/BookStore01/MainMenu.java`: Manages the main menu interactions and navigation.
*   `src/BookStore01/SelectBook.java`: Handles the logic for searching/selecting books based on different criteria.
*   `src/BookStore01/BuyBookMenu.java`: Manages the menu presented to the user after a book is selected (buy, wishlist, etc.).
*   `src/BookStore01/BuyBookSelection.java`: Contains the logic for purchasing a book or adding it to the wishlist.
*   `src/BookStore01/AdminOperations.java`: Contains administrative functions, such as adding new books.
*   `src/BookStore01/CreateMap.java`: Provides a default, hardcoded list of books (used if `books.csv` is not found).
*   `src/BookStore01/BookDataManager.java`: Handles saving book data to `books.csv` and loading it from the file.
*   `books.csv`: (Generated in the project root after running and exiting) Stores the book inventory.

## To-Do/Future Enhancements
*   More robust error handling for file operations and user input.
*   Implementation of a user accounts system.
*   Actual persistence for wishlists (e.g., per user).
*   More complex search options (e.g., price range, multiple criteria).
*   A graphical user interface (GUI) instead of a console interface.
*   Unit tests for various components.
*   More detailed logging.
*   Refactor scanner usage to a single instance or dependency injection.

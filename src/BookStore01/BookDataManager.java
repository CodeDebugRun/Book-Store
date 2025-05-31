package BookStore01;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class BookDataManager {

    private static final String FILENAME = "books.csv";

    public static Map<Integer, Book> loadBooks() {
        Map<Integer, Book> booksMap = new TreeMap<>();
        File file = new File(FILENAME);

        if (!file.exists()) {
            System.out.println("'" + FILENAME + "' not found. Loading default book list.");
            return CreateMap.createDefaultBookList();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty() || line.startsWith("#")) { // Skip empty lines or comments
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length == 7) { // bookId,isbn,title,author,yearPublished,price,stock
                    try {
                        int bookId = Integer.parseInt(parts[0].trim());
                        String isbn = parts[1].trim();
                        String title = parts[2].trim();
                        String author = parts[3].trim();
                        int yearPublished = Integer.parseInt(parts[4].trim());
                        double price = Double.parseDouble(parts[5].trim());
                        int stock = Integer.parseInt(parts[6].trim());

                        booksMap.put(bookId, new Book(isbn, title, author, yearPublished, price, stock));
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing number in line: " + line + " - " + e.getMessage() + ". Skipping line.");
                    }
                } else {
                    System.err.println("Malformed line in " + FILENAME + ": " + line + ". Skipping line. Expected 7 parts.");
                }
            }
            System.out.println("Books loaded successfully from '" + FILENAME + "'.");
        } catch (FileNotFoundException e) {
            // This case should ideally be caught by file.exists() check, but as a fallback:
            System.err.println("Error: '" + FILENAME + "' not found during read attempt. " + e.getMessage());
            System.out.println("Loading default book list.");
            return CreateMap.createDefaultBookList();
        } catch (IOException e) {
            System.err.println("Error reading from '" + FILENAME + "': " + e.getMessage());
            System.out.println("Loading default book list as a fallback.");
            return CreateMap.createDefaultBookList(); // Fallback to default if read error
        }

        // If the file existed but was empty or only had malformed lines, booksMap might be empty.
        // Consider if this scenario also requires loading default books. For now, an empty map is returned.
        if (booksMap.isEmpty() && file.length() > 0) { // File had content but nothing valid was parsed
             System.out.println("No valid book data found in '" + FILENAME + "'. Consider checking the file format.");
        } else if (booksMap.isEmpty() && file.length() == 0) { // File was empty
             System.out.println("'" + FILENAME + "' is empty. Starting with an empty book list or loading defaults if preferred.");
             // Optionally, return CreateMap.createDefaultBookList(); here too if an empty CSV means "use defaults"
        }

        return booksMap;
    }

    public static void saveBooks(Map<Integer, Book> booksMap) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
            // Optional: Write a header line
            // bw.write("BookID,ISBN,Title,Author,YearPublished,Price,Stock\n");
            for (Map.Entry<Integer, Book> entry : booksMap.entrySet()) {
                Integer bookId = entry.getKey();
                Book book = entry.getValue();
                String line = String.join(",",
                        String.valueOf(bookId),
                        book.getIsbn(),
                        book.getTitle(),
                        book.getAuthor(),
                        String.valueOf(book.getYearPublished()),
                        String.valueOf(book.getPrice()),
                        String.valueOf(book.getStock())
                );
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Books saved successfully to '" + FILENAME + "'.");
        } catch (IOException e) {
            System.err.println("Error saving books to '" + FILENAME + "': " + e.getMessage());
        }
    }
}

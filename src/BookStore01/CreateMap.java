package BookStore01;

import java.util.Map;
import java.util.TreeMap;

public class CreateMap {

    public static Map<Integer, Book> createDefaultBookList() { // Renamed method
        Map<Integer, Book> bookListMap = new TreeMap<>();
        Map<Integer, String> bookData = new TreeMap<>();

        bookData.put(1005, "985425, Melekler ve Şeytanlar, Dan Brown, 2008, 15, 1, 14"); // Assuming price is 15, stock is 1 (original had 7 fields)
        bookData.put(1006, "982365, Origin, Dan Brown, 2001, 5, 150"); // Assuming price 5, stock 150 (original had 8 fields - likely error, taking first 6)
        bookData.put(1001, "215425, Pinokyo, Carlo Colladi, 2017, 10, 100"); // Assuming price 10, stock 100
        bookData.put(1002, "123456, Digital Kale, Dan brown, 2001, 2, 50");  // Assuming price 2, stock 50
        bookData.put(1003, "987654, Silinis, Hess Greatsonn, 2008, 5, 75");   // Assuming price 5, stock 75
        bookData.put(1004, "123459, 3 un cekilisi, stephen king, 2010, 15, 74"); // Assuming price 15, stock 74
        bookData.put(1007, "987653, Cehennem, don brown, 2008, 6, 14");      // Assuming price 6, stock 14
        bookData.put(1008, "987652, Harry potter 1, J. K. Rowling, 2001, 5, 10"); // Assuming price 5, stock 10
        bookData.put(1009, "987651, Harry potter 2, J. K. Rowling, 2002, 5, 10"); // Assuming price 5, stock 10
        bookData.put(1010, "987650, Harry potter 3, J. K. Rowling, 2003, 5, 10"); // Assuming price 5, stock 10
        bookData.put(1011, "987655, Harry potter 4, J. K. Rowling, 2004, 5, 10"); // Assuming price 5, stock 10
        bookData.put(1012, "987656, Harry potter 5, J. K. Rowling, 2006, 5, 10"); // Assuming price 5, stock 10
        bookData.put(1013, "987657, Harry potter 6, J. K. Rowling, 2008"); // Missing price and stock

        for (Map.Entry<Integer, String> entry : bookData.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            String[] parts = value.split(",\\s*");

            // Declare and initialize with defaults or safe values from parts
            String isbn = (parts.length > 0) ? parts[0].trim() : "N/A_ISBN";
            String title = (parts.length > 1) ? parts[1].trim() : "N/A_Title";
            String author = (parts.length > 2) ? parts[2].trim() : "N/A_Author";

            int yearPublished = 0; // Default
            double price = 0.0;    // Default
            int stock = 0;        // Default

            try {
                // Attempt to parse year, price, stock
                // These will throw NumberFormatException if parts[index] is not a valid number string
                // or ArrayIndexOutOfBoundsException if parts.length is too small for a given index.

                if (parts.length > 3) {
                    yearPublished = Integer.parseInt(parts[3].trim());
                } else {
                    // For book 1013, year is present but price/stock are not.
                    // If year is absolutely mandatory and missing for other entries, this logic might need adjustment.
                    // For now, if year is missing (parts.length <=3), it remains 0 (default).
                    // If it's present but not parsable, NumberFormatException will be caught.
                    if (key != 1013) { // Book 1013 has year, but not price/stock. Others might be more problematic if year is missing.
                         System.err.println("Warning: Year missing for book ID " + key + " (" + title + "). Using default year 0.");
                    } else if (parts.length > 3) { // Ensure part[3] exists for 1013 before parsing
                         yearPublished = Integer.parseInt(parts[3].trim());
                    } else {
                        // This means for 1013, parts[3] (year) is missing.
                        System.err.println("Critical: Year missing for book ID " + key + " (" + title + ") where it was expected. Using default year 0.");
                    }
                }

                if (parts.length > 4) {
                    price = Double.parseDouble(parts[4].trim());
                } // else price remains 0.0 (default)

                if (parts.length > 5) {
                    stock = Integer.parseInt(parts[5].trim());
                } // else stock remains 0 (default)

                // If there are more parts than expected (e.g. book 1005, 1006), they are ignored by this logic.
                bookListMap.put(key, new Book(isbn, title, author, yearPublished, price, stock));

            } catch (NumberFormatException e) {
                // title is now in scope and initialized
                System.err.println("Error parsing number for book ID " + key + " (" + title + "): " + e.getMessage() + ". Using default values for affected fields.");
                // Create book with any successfully parsed string fields and default numeric values
                // yearPublished, price, stock will retain their defaults (0, 0.0, 0) if their specific parsing failed.
                bookListMap.put(key, new Book(isbn, title, author, yearPublished, price, stock));
            } catch (ArrayIndexOutOfBoundsException e) {
                // This catch block handles cases where essential parts (e.g., year for a non-1013 book if we made it mandatory) are missing.
                // title is in scope and initialized.
                System.err.println("Error (missing data fields) for book ID " + key + " (" + title + "): " + e.getMessage() + ". Using default values for missing fields.");
                // Create book with what was parsed and defaults.
                bookListMap.put(key, new Book(isbn, title, author, yearPublished, price, stock));
            }
        }
        return bookListMap;
    }
}







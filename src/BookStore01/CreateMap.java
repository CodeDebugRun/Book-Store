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

            try {
                String isbn = parts[0];
                String title = parts[1];
                String author = parts[2];
                int yearPublished = Integer.parseInt(parts[3]);
                double price = 0.0; // Default price
                int stock = 0;     // Default stock

                if (parts.length > 4) {
                    price = Double.parseDouble(parts[4]);
                }
                if (parts.length > 5) {
                    stock = Integer.parseInt(parts[5]);
                }
                // If there are more parts than expected (e.g. book 1005, 1006), they are ignored.

                bookListMap.put(key, new Book(isbn, title, author, yearPublished, price, stock));

            } catch (NumberFormatException e) {
                System.err.println("Error parsing number for book ID " + key + " (" + title + "): " + e.getMessage() + ". Using default values for price/stock if applicable.");
                 // Attempt to create book with default price/stock if year was parsed
                if (parts.length >= 4) {
                    try {
                        String isbn = parts[0];
                        String title = parts[1];
                        String author = parts[2];
                        int yearPublished = Integer.parseInt(parts[3]);
                        bookListMap.put(key, new Book(isbn, title, author, yearPublished, 0.0, 0));
                    } catch (Exception innerEx) {
                        System.err.println("Further error creating book object for ID " + key + " even with defaults: " + innerEx.getMessage());
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                 System.err.println("Error parsing data for book ID " + key + ": Not enough data fields. " + e.getMessage() + ". Attempting to create with available data and defaults.");
                 // Handle cases like book 1013 specifically or if absolutely necessary fields are missing
                if (parts.length >= 4) { // Minimum: isbn, title, author, year
                    String isbn = parts[0];
                    String title = parts[1];
                    String author = parts[2];
                    int yearPublished = Integer.parseInt(parts[3]); // Assuming year is always present if length is 4
                    bookListMap.put(key, new Book(isbn, title, author, yearPublished, 0.0, 0));
                } else if (parts.length >= 3) { // isbn, title, author - year missing
                     String isbn = parts[0];
                     String title = parts[1];
                     String author = parts[2];
                     // Year is not available, cannot create a valid book object as per current constructor.
                     // Or modify Book constructor or use a default year. For now, skip or log error.
                     System.err.println("Cannot create book for ID " + key + ": year is missing.");
                }
                // Add more specific handling if needed
            }
        }
        return bookListMap;
    }
}







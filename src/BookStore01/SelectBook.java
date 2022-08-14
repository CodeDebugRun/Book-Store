package BookStore01;

import java.util.*;

public class SelectBook {
    static Scanner scanner = new Scanner(System.in);
    static Map<Integer, String> bookListMap = CreateMap.createNewBookList();
    static Set<Map.Entry<Integer,String>> bookListSet = bookListMap.entrySet();

    static String entryValue;
    static Integer entryKey;
    static List<String> entryList = new ArrayList<>();
    static String [] entryArr;

   /* public static void AssignEntriesToList(){
        for (Map.Entry<Integer,String> w : bookListSet) {
            entryValue = w.getValue();
            entryArr = entryValue.split(", ");
            }
    }*/


    public static void SelectBookWithISBN() {
        System.out.print("ISBN numarasini giriniz : ");
        int isbnNumber = scanner.nextInt();
        for (Map.Entry<Integer,String> w : bookListSet) {
            entryValue = w.getValue();
            entryArr = entryValue.split(", ");
            if(entryArr[0].equalsIgnoreCase(String.valueOf(isbnNumber))){
                System.out.println(w.getValue());
            }
        }
    }

    public static void SelectBookWithName() {
        System.out.print("Kitap adini giriniz :  ");
        String bookName = scanner.next();
        for (Map.Entry<Integer,String> w : bookListSet) {
            entryValue = w.getValue();
            entryArr = entryValue.split(", ");
            if (entryArr[1].contains(bookName)) {
                System.out.println(w.getValue());
            }
        }
    }

    public static void SelectBookWithYearPublished() {
        System.out.print("Basim yili giriniz :  ");
        int yearPublished = scanner.nextInt();
        for (Map.Entry<Integer,String> w : bookListSet) {
            entryValue = w.getValue();
            entryArr = entryValue.split(", ");
            if (entryArr[3].contains(String.valueOf(yearPublished))) {
                System.out.println(w.getValue());
            }
        }
    }

    public static void SelectBookWithIdNumber() {
        System.out.print("ID numarasini giriniz :  ");
        int idNumber = scanner.nextInt();
        for (Map.Entry<Integer,String> w : bookListSet) {
            entryValue = w.getValue();
            entryKey = w.getKey();
            entryArr = entryValue.split(", ");

            if (entryKey == idNumber) {
                System.out.println(bookListMap.get(entryKey));
            }
        }

    }
}

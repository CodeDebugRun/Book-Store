package BookStoreSinan;

import java.util.*;

public class Methodlar extends AnaMenu {
    int kalanStok;
    int satilanKitap;
    int gelenStok;
    static int kitap;
    static Map<Integer, String> kitapListMap2 = kitapListMapOlustur();
    static Scanner scan = new Scanner(System.in);
    static List<Integer> sepetList=new ArrayList<>();
    static public Map<Integer, String> kitapListMapOlustur() {
        Map<Integer, String> kitapListMap2 = new HashMap<>();
        kitapListMap2.put(1001, "Pinokya, Carlo Colladi, 2017, 10, 100, 5, 95");
        kitapListMap2.put(1002, "Digital Kale, Don Brown, 2001, 2, 50, 10, 40");
        kitapListMap2.put(1003, "Silinis, Hess Greatsen, 2008, 5, 75, 35, 40");
        kitapListMap2.put(1004, "3 un Cekilisi, Stephen King, 2010, 15, 74, 44, 30");
        kitapListMap2.put(1005, "Melekler ve Seytanlar, Don Brown, 2008, 15, 150, 10, 140");
        kitapListMap2.put(1008, "Harry Poter1, J.K.Rowling., 2001, 5, 10, 1, 9");
        kitapListMap2.put(1009, "Harry Poter2, J.K.Rowling., 2002, 5, 10, 1, 9");
        kitapListMap2.put(1010, "Harry Poter3, J.K.Rowling., 2003, 5, 10, 1, 9");
        kitapListMap2.put(1011, "Harry Poter4, J.K.Rowling., 2004, 5, 10, 1, 9");
        kitapListMap2.put(1012, "Harry Poter5, J.K.Rowling., 2006, 5, 10, 1, 9");
        kitapListMap2.put(1013, "Harry Poter6, J.K.Rowling., 2008, 5, 10, 1, 9");
        kitapListMap2.put(1006, "Origin, Don Brown, 2001, 5, 10, 7 ,3");
        kitapListMap2.put(1007, "Cehennem, Don Brown, 2008, 5, 10, 9 ,1");
        return kitapListMap2;
    }
    public static void kitapAraisimden() {
        Map<Integer, String> kitapListMap2 = new HashMap<>();
        System.out.println("aramak istediginiz id, isim yazar,basim yili veya baski girinz:");
        String isimSecim = scan.nextLine();
        Set<Map.Entry<Integer, String>> entrySeti = kitapListMap2.entrySet();
        String entryValue;
        String[] entryArr;
        List<Integer> kitapList = new ArrayList<>();
        int secim = 0;
        //int kitap = 0;
        int y = 1;
        for (Map.Entry<Integer, String> each : entrySeti) {
            entryValue = each.getValue();
            entryArr = entryValue.split(", ");
            for (int i = 0; i < entryArr.length; i++) {
                if (entryArr[i].contains(isimSecim)) {
                    System.out.println(y + ". " + entryArr[0] + " " + entryArr[1] + " " + entryArr[2] + " " + entryArr[3]);
                    kitap = each.getKey();
                    kitapList.add(each.getKey());
                    y++;
                }
            }
        }
        if ((y >= 2)) {
            System.out.println("Lutfen almak istediginiz kitabi giriniz");
            secim = scan.nextInt();
            System.out.println("almak istediginiz kitap" + kitapList.get(secim-1));
            kitap = kitapList.get(secim-1);
        }
        try {
            if (kitapListMap2.containsKey(Integer.parseInt(isimSecim))) {
                System.out.println("kitapListMap.equals(kitapList) = " + kitapListMap2.get(Integer.parseInt(isimSecim)));
                //   kitap id sinden bulma ayarlanacak
            }
        } catch (Exception e) {
            if ((kitap == 0))
                System.out.println("Aradiginiz kitap bulunamamistir.");
        }
        satinAlma();}
    public static void kalanStok() {
        // Map<Integer, String> kitapListMap2 = kitapListMapOlustur();
        String arr[] = kitapListMap2.get(kitap).split(", ");
        int kalanStok = Integer.parseInt(arr[6]);
        System.out.println("kitabindan kalan " + kalanStok);
    }
    public static void satinAlma() {
        System.out.println("Lutfen secim yapiniz");
        System.out.println("1. Satin alma");
        System.out.println("2. Bir ust menuye donme");
        int secim= scan.nextInt();
        switch (secim){
            case 1:
                sepetList.add(kitap);
                System.out.println("Sepete yeni kitap eklemek icin Y ye basiniz odeme sayafasina gitmek icin Q ya basiniz");
                String sepetCikis= scan.next();
                if (sepetCikis.equals("Y"))
                    kitapAraisimden();
                // odeme method eklenecek
                break;
            case 2:
// menu eklenecek
                break;
            default:
                System.out.println("Lutfen tekrar secim yapiniz");
                satinAlma();
        }
    }
}
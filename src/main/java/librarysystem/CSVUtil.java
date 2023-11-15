package librarysystem;

import java.io.*;
import java.util.*;

public class CSVUtil {

    public static void saveBooksToCSV(Map<String, Book> books, String fileName) throws IOException {
        try (PrintWriter pw = new PrintWriter(new File(fileName))) {
            for (Book book : books.values()) {
                pw.println(book.getIsbn() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.isBorrowed());
            }
        }
    }

    public static Map<String, Book> loadBooksFromCSV(String fileName) throws IOException {
        Map<String, Book> books = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                Book book = new Book(data[1], data[2], data[0]);
                book.setBorrowed(Boolean.parseBoolean(data[3]));
                books.put(data[0], book);
                System.out.println("Loaded book: " + book); // Debug
            }
        }
        return books;
    }

    public static void saveCDsToCSV(Map<String, CD> cds, String fileName) throws IOException {
        try (PrintWriter pw = new PrintWriter(new File(fileName))) {
            for (CD cd : cds.values()) {
                pw.println(cd.getTitle() + "," + cd.getArtist() + "," + cd.getProducer() + "," + cd.getPlayTime() + "," + cd.isAvailable());
            }
        }
    }

    public static Map<String, CD> loadCDsFromCSV(String fileName) throws IOException {
        Map<String, CD> cds = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                CD cd = new CD(data[0], data[1], data[2], Double.parseDouble(data[3]));
                cd.setAvailable(Boolean.parseBoolean(data[4]));
                cds.put(data[0], cd);
            }
        }
        return cds;
    }

    public static void saveMembersToCSV(Map<Integer, Member> members, String fileName) throws IOException {
        try (PrintWriter pw = new PrintWriter(new File(fileName))) {
            for (Member member : members.values()) {
                pw.println(member.getMemberId() + "," + member.getName());
            }
        }
    }

    public static Map<Integer, Member> loadMembersFromCSV(String fileName) throws IOException {
        Map<Integer, Member> members = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String[] data = scanner.nextLine().split(",");
                Member member = new Member(data[1], Integer.parseInt(data[0]));
                members.put(Integer.parseInt(data[0]), member);
            }
        }
        return members;
    }
}

package library;

import java.io.*;
import java.util.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;

public class CSVUtil {

    public static void saveBooksToCSV(Map<String, Book> books, String fileName) throws IOException {
        try (PrintWriter pw = new PrintWriter(new File(fileName))) {
            
            pw.println("ISBN         ,Author                             ,Title                         ,Is Borrowed  ");
                
            for (Book book : books.values()) {
                String isbn = String.format("%-13s", book.getIsbn()); // ISBN - 13 char
                String author = String.format("%-35s", book.getAuthor()); // Author - 35 char
                String title = String.format("%-30s", book.getTitle()); // Title - 30 char
                String borrowed = String.format("%-12s", book.isBorrowed() ? "Yes" : "No"); // Is Borrowed - 12 char
    
                pw.println(isbn + "," + author + "," + title + "," + borrowed);
            }
        }
    }
    

    public static Map<String, Book> loadBooksFromCSV(String fileName) throws IOException {
        Map<String, Book> books = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            boolean isFirstLine = true; // first row
    
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // skip first row
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
    
                String[] data = line.split(",");
                // data order: ISBN, Title, Author, BorrowedStatus
                Book book = new Book(data[1].trim(), data[2].trim(), data[0].trim()); // Title, Author, ISBN
                book.setBorrowed(Boolean.parseBoolean(data[3].trim()));
                books.put(data[0].trim(), book);
                System.out.println("Loaded book: " + book); //debug
            }
        }
        return books;
    }
    

    public static void saveCDsToCSV(Map<String, CD> cds, String fileName) throws IOException {
        try (PrintWriter pw = new PrintWriter(new File(fileName))) {
            
            pw.println("Title                    ,Artist                   ,Producer                 ,Time   ,Is Available ");
    
            for (CD cd : cds.values()) {
                String title = String.format("%-25s", cd.getTitle()); 
                String artist = String.format("%-25s", cd.getArtist()); 
                String producer = String.format("%-25s", cd.getProducer()); 
                String playTime = String.format("%-7s", cd.getPlayTime()); 
                String available = String.format("%-12s", cd.isAvailable() ? "Yes" : "No"); 
    
                pw.println(title + "," + artist + "," + producer + "," + playTime + "," + available);
            }
        }
    }
    

    public static Map<String, CD> loadCDsFromCSV(String fileName) throws IOException {
        Map<String, CD> cds = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            boolean isFirstLine = true; 
    
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
    
                String[] data = line.split(",");
                // Title, Artist, Producer, Time, Is Available
                CD cd = new CD(data[0].trim(), data[1].trim(), data[2].trim(), Double.parseDouble(data[3].trim()));
                cd.setAvailable(Boolean.parseBoolean(data[4].trim()));
                cds.put(data[0].trim(), cd);
            }
        }
        return cds;
    }
    

    public static void saveMembersToCSV(Map<Integer, Member> members, String fileName) throws IOException {
        try (PrintWriter pw = new PrintWriter(new File(fileName))) {
            pw.println("ID   ,Member Name                    ");
    
            for (Member member : members.values()) {
                String memberId = String.format("%-5d", member.getMemberId()); 
                String memberName = String.format("%-30s", member.getName()); 
    
                pw.println(memberId + "," + memberName);
            }
        }
    }
    

    public static Map<Integer, Member> loadMembersFromCSV(String fileName) throws IOException {
        Map<Integer, Member> members = new HashMap<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            boolean isFirstLine = true; 
    
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
    
                String[] data = line.split(",");
                int memberId = Integer.parseInt(data[0].trim()); 
                Member member = new Member(data[1].trim(), memberId);
                members.put(memberId, member);
            }
        }
        return members;
    }

    // public static void saveDissertationsToCSV(List<Dissertation> dissertations, String fileName) throws IOException {
    //     try (PrintWriter pw = new PrintWriter(new File(fileName))) {
    //         for (Dissertation dissertation : dissertations) {
    //             String csvLine = String.join(",",
    //                     "\"" + dissertation.getDissertationID() + "\"",
    //                     "\"" + dissertation.getTitle().replace("\"", "\"\"") + "\"",
    //                     "\"" + dissertation.getAuthor().replace("\"", "\"\"") + "\"",
    //                     "\"" + dissertation.getUniversity().replace("\"", "\"\"") + "\"",
    //                     "\"" + dissertation.getYear() + "\"",
    //                     "\"" + dissertation.getDepartment().replace("\"", "\"\"") + "\"",
    //                     "\"" + dissertation.getAdvisor().replace("\"", "\"\"") + "\"",
    //                     "\"" + dissertation.getAbstractText().replace("\"", "\"\"") + "\"");
    //             pw.println(csvLine);
    //         }
    //     }
    // }

    public static void saveDissertationToCSV(Dissertation dissertation, String fileName, boolean append) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName, append))) {
            String csvLine = String.join(",",
                    "\"" + dissertation.getDissertationID() + "\"",
                    "\"" + dissertation.getTitle().replace("\"", "\"\"") + "\"",
                    "\"" + dissertation.getAuthor().replace("\"", "\"\"") + "\"",
                    "\"" + dissertation.getUniversity().replace("\"", "\"\"") + "\"",
                    "\"" + dissertation.getYear() + "\"",
                    "\"" + dissertation.getDepartment().replace("\"", "\"\"") + "\"",
                    "\"" + dissertation.getAdvisor().replace("\"", "\"\"") + "\"",
                    "\"" + dissertation.getAbstractText().replace("\"", "\"\"") + "\"");
            pw.println(csvLine);
        }
    }
    
    
    public static List<Dissertation> loadDissertationsFromCSV(String fileName) throws IOException {
        List<Dissertation> dissertations = new ArrayList<>();
        //try (Reader in = new FileReader(fileName); CSVParser parser = new CSVParser(in, CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in))) {
        try (Reader reader = new FileReader(fileName);
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withIgnoreHeaderCase().withTrim())) {
                            
            for (CSVRecord record : csvParser) {
                Dissertation dissertation = new Dissertation(
                    record.get(1), // Title
                    record.get(2), // Author
                    record.get(3), // University
                    Integer.parseInt(record.get(4)), // Year
                    record.get(5), // Department
                    record.get(6), // Advisor
                    record.get(7), // AbstractText
                    record.get(0)  // DissertationID
                );
                dissertations.add(dissertation);
            }
        }
        return dissertations;
    }

    
}

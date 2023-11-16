package library;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private Map<String, Book> books;
    private Map<Integer, Member> members;
    private Map<String, CD> cds;
    private Map<Integer, List<BorrowedBook>> borrowedBooks;
    private List<Dissertation> dissertations;

    public Library() {
        books = new HashMap<>();
        members = new HashMap<>();
        cds = new HashMap<>();
        borrowedBooks = new HashMap<>();
        this.dissertations = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public boolean removeBook(String isbn) {
        if (books.containsKey(isbn) && !books.get(isbn).isBorrowed()) {
            books.remove(isbn);
            return true;
        } else if (books.containsKey(isbn)) {
            System.out.println("Book with ISBN " + isbn + " is currently borrowed and cannot be removed.");
        }
        return false;
    }

    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }

    public boolean removeMember(int memberId) {
        if (members.containsKey(memberId)) {
            members.remove(memberId);
            return true;
        }
        return false;
    }
    

    public void addCD(CD cd) {
        cds.put(cd.getTitle(), cd);
    }

    public boolean removeCD(String title) {
        if (cds.containsKey(title) && cds.get(title).isAvailable()) {
            cds.remove(title);
            return true;
        } else if (cds.containsKey(title)) {
            System.out.println("CD titled " + title + " is currently not available and cannot be removed.");
        }
        return false;
    }

    public boolean borrowBook(String isbn, int memberId) {
        Book book = books.get(isbn);
        if (book != null && !book.isBorrowed()) {
            book.setBorrowed(true);
            book.setBorrowedBy(memberId);
            return true;
        }
        return false;
    }

    public boolean borrowCD(String title, int memberId) {
        CD cd = cds.get(title);
        if (cd != null && cd.isAvailable()) {
            cd.setAvailable(false);
            cd.setBorrowedBy(memberId);
            return true;
        }
        return false;
    }

    public void returnBook(String isbn) {
        Book book = books.get(isbn);
        if (book != null) {
            book.setBorrowed(false);
        }
    }

    public void returnCD(String title) {
        CD cd = cds.get(title);
        if (cd != null) {
            cd.setAvailable(true);
        }
    }

    
    

    public void displayAvailableBooks() {
        for (Book book : books.values()) {
            if (!book.isBorrowed()) {
                System.out.println(book);
            }
        }
    }

    public void displayAvailableCDs() {
        for (CD cd : cds.values()) {
            if (cd.isAvailable()) {
                System.out.println(cd);
            }
        }
    }

    public List<Book> sortBooksByTitle() {
        return books.values().stream()
            .sorted(Comparator.comparing(Book::getTitle))
            .collect(Collectors.toList());
    }
    
    public List<CD> sortCDsByTitle() {
        return cds.values().stream()
            .sorted(Comparator.comparing(CD::getTitle))
            .collect(Collectors.toList());
    }

    public List<Book> sortBooksByISBN() {
        return books.values().stream()
            .sorted(Comparator.comparing(Book::getIsbn))
            .collect(Collectors.toList());
    }

    public List<Book> sortBooksByAuthor() {
        return books.values().stream()
            .sorted(Comparator.comparing(Book::getAuthor))
            .collect(Collectors.toList());
    }

    public List<CD> sortCDsByArtist() {
        return cds.values().stream()
            .sorted(Comparator.comparing(CD::getArtist))
            .collect(Collectors.toList());
    }
    
    public Book findBookByISBN(String isbn) {
        Book book = books.get(isbn);
        System.out.println("Searching for ISBN: " + isbn + ", Found: " + book); // Debug
        return book;
    }

    public List<Book> findBooksByAuthor(String author) {
        return books.values().stream()
            .filter(book -> book.getAuthor().equalsIgnoreCase(author))
            .collect(Collectors.toList());
    }

    public List<Book> findBooksByTitle(String titlePart) {
        return books.values().stream()
            .filter(book -> book.getTitle().toLowerCase().contains(titlePart.toLowerCase()))
            .collect(Collectors.toList());
    }

    public List<CD> findCDsByArtist(String artist) {
        return cds.values().stream()
            .filter(cd -> cd.getArtist().equalsIgnoreCase(artist))
            .collect(Collectors.toList());
    }
    
    public List<CD> findCDsByTitle(String titlePart) {
        return cds.values().stream()
            .filter(cd -> cd.getTitle().toLowerCase().contains(titlePart.toLowerCase()))
            .collect(Collectors.toList());
    }

    public boolean reserveBook(String isbn) {
        Book book = books.get(isbn);
        if (book != null && !book.isBorrowed()) {
            book.setBorrowed(true);
            return true;
        }
        return false;
    }

    public boolean reserveCD(String title) {
        CD cd = cds.get(title);
        if (cd != null && cd.isAvailable()) {
            cd.setAvailable(false);
            return true;
        }
        return false;
    }

    public double calculateOverdueFees(int memberId) {
        double totalFees = 0;
        final int overdueDaysLimit = 15;
        final double feePerDay = 1; // let say 1 euro per 15 seconds only for test purpose :)

        // Example data structure for borowed books
        // Map<Integer, List<BorrowedBook>> borrowedBooks; // where Integer is ID member

        List<BorrowedBook> memberBooks = borrowedBooks.getOrDefault(memberId, Collections.emptyList());
        for (BorrowedBook book : memberBooks) {
            long daysOverdue = ChronoUnit.SECONDS.between(book.getBorrowDate(), LocalDate.now()) - overdueDaysLimit; // DAYS is normal setting
            if (daysOverdue > 0) {
                totalFees += daysOverdue * feePerDay;
            }
        }

        return totalFees;
    }

    public void saveLibraryState() {
        try {
            CSVUtil.saveBooksToCSV(books, "books.csv");
            CSVUtil.saveCDsToCSV(cds, "cds.csv");
            CSVUtil.saveMembersToCSV(members, "members.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadLibraryState() {
        try {
            this.books = CSVUtil.loadBooksFromCSV("books.csv");
            this.cds = CSVUtil.loadCDsFromCSV("cds.csv");
            this.members = CSVUtil.loadMembersFromCSV("members.csv");
            this.dissertations = CSVUtil.loadDissertationsFromCSV("dissertations.csv");
            System.out.println("Loading completed.");

        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Dissertation> findDissertationsByTitle(String title) {
        return dissertations.stream()
                .filter(dissertation -> dissertation.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    public List<Dissertation> findDissertationsByAuthor(String author) {
        return dissertations.stream()
                .filter(dissertation -> dissertation.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<Dissertation> findDissertationsByUniversity(String university) {
        return dissertations.stream()
                .filter(dissertation -> dissertation.getUniversity().equalsIgnoreCase(university))
                .collect(Collectors.toList());
    }

    public List<Dissertation> findDissertationsByYear(int year) {
        return dissertations.stream()
                .filter(dissertation -> dissertation.getYear() == year)
                .collect(Collectors.toList());
    }

    public List<Dissertation> findDissertationsByDepartment(String department) {
        return dissertations.stream()
                .filter(dissertation -> dissertation.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }

    public List<Dissertation> findDissertationsByAdvisor(String advisor) {
        return dissertations.stream()
                .filter(dissertation -> dissertation.getAdvisor().equalsIgnoreCase(advisor))
                .collect(Collectors.toList());
    }

    // searching a part of text
    public List<Dissertation> findDissertationsByAbstractText(String searchText) {
        return dissertations.stream()
                .filter(dissertation -> dissertation.getAbstractText().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void addDissertation(Dissertation dissertation) {
        this.dissertations.add(dissertation);
    }
    
    
    public boolean removeDissertation(String dissertationID) {
        for (Dissertation dissertation : dissertations) {
            if (dissertation.getDissertationID().equals(dissertationID)) {
                dissertations.remove(dissertation);
                return true;
            }
        }
        return false;
    }
    
    public String generateBorrowedItemsReport() {
        StringBuilder report = new StringBuilder();
        report.append("Borrowed Books:\n");
        for (Book book : books.values()) {
            if (book.isBorrowed()) {
                report.append(book).append(", Borrowed by Member ID: ").append(book.getBorrowedBy()).append("\n");
            }
        }
        
        report.append("\nBorrowed CDs:\n");
        for (CD cd : cds.values()) {
            if (!cd.isAvailable()) { 
                report.append(cd).append(", Borrowed by Member ID: ").append(cd.getBorrowedBy()).append("\n");
            }
        }
    
        return report.toString();
    }
    

    public void printBooksBorrowedByMember(int memberId) {
        for (Book book : books.values()) {
            if (book.getBorrowedBy() == memberId) {
                System.out.println(book);
            }
        }
    }
    
    public String generateOverdueReport() {
        StringBuilder report = new StringBuilder();
        report.append("Overdue Items and Fees:\n");
        for (Member member : members.values()) {
            double fees = calculateOverdueFees(member.getMemberId()); 
            if (fees > 0) {
                report.append("Member ID: ").append(member.getMemberId()).append(", Fees: ").append(fees).append("\n");
            }
        }
    
        return report.toString();
    }
    

}
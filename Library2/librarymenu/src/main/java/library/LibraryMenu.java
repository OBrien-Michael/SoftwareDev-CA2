package library;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class LibraryMenu {
    private Library library;
    private Scanner scanner;

    public LibraryMenu(Library library) {
        this.library = library;
        this.scanner = new Scanner(System.in);
    }

    public void showMainMenu() {
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Librarian");
            System.out.println("2. Member");
            System.out.println("3. Dissertations");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showLibrarianMenu();
                    break;
                case 2:
                    showMemberMenu();
                    break;
                    case 3:
                    showDissertationSearchMenu();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showDissertationSearchMenu() {
        System.out.println("Dissertation Search Menu:");
        System.out.println("1. By Title");
        System.out.println("2. By Author");
        System.out.println("3. By University");
        System.out.println("4. By Year (yyyy)");
        System.out.println("5. By Department");
        System.out.println("6. By Advisor");
        System.out.println("7. By Abstract Text");
        System.out.println("8. Return to Main Menu");

        int choice = scanner.nextInt();
        scanner.nextLine(); // konsumpcja nowej linii
        switch (choice) {
            case 1:
                searchDissertationsBy("title");
                break;
            case 2:
                searchDissertationsBy("author");
                break;
            case 3:
                searchDissertationsBy("university");
                break;
            case 4:
                searchDissertationsBy("year");
                break;
            case 5:
                searchDissertationsBy("department");
                break;
            case 6:
                searchDissertationsBy("advisor");
                break;
            case 7:
                searchDissertationsBy("abstract");
                break;
            case 8:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void searchDissertationsBy(String criterion) {
        System.out.println("Enter " + criterion + ":");
        String input = scanner.nextLine();
        List<Dissertation> results;
        switch (criterion) {
            case "title":
                results = library.findDissertationsByTitle(input);
                break;
            case "author":
                results = library.findDissertationsByAuthor(input);
                break;
            case "university":
                results = library.findDissertationsByUniversity(input);
                break;
            case "year":
                results = library.findDissertationsByYear(Integer.parseInt(input));
                break;
            case "department":
                results = library.findDissertationsByDepartment(input);
                break;
            case "advisor":
                results = library.findDissertationsByAdvisor(input);
                break;
            case "abstract":
                results = library.findDissertationsByAbstractText(input);
                break;
            default:
                System.out.println("Invalid search criterion.");
                return;
        }

        if (results.isEmpty()) {
            System.out.println("No dissertations found.");
        } else {
            results.forEach(System.out::println);
        }
    }

    private void showLibrarianMenu() {
        boolean keepRunning = true;
    
        while (keepRunning) {
            System.out.println("Librarian Menu:");
            System.out.println("1. Add member");
            System.out.println("2. Remove member");
            System.out.println("3. Add book/CD");
            System.out.println("4. Remove book/CD");
            System.out.println("5. Add Dissertation");
            System.out.println("6. Remove Dissertation");
            System.out.println("7. Sort by title");
            System.out.println("8. Sort by ISBN");
            System.out.println("9. Sort by author");
            System.out.println("10. Save data");
            System.out.println("11. Read data");
            System.out.println("12. Generate Borrowed Items Report");
            System.out.println("13. Generate Overdue Report");
            System.out.println("14. Return to main menu");
    
            int choice = scanner.nextInt();
            scanner.nextLine(); // To catch the newline character
            switch (choice) {
                case 1:
                    addMember();
                    break;
                case 2:
                    removeMember();
                    break;
                case 3:
                    addItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    addDissertation();
                    break;
                case 6:
                    removeDissertation();
                    break;
                case 7:
                    sortByTitle();
                    break;
                case 8:
                    sortByISBN();
                    break;
                case 9:
                    sortByAuthor();
                    break;
                case 10:
                    saveData();
                    break;
                case 11:
                    readData();
                    break;
                case 12:
                    System.out.println(library.generateBorrowedItemsReport());
                    break;
                case 13:
                    System.out.println(library.generateOverdueReport());
                    break;
                case 14:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    

    private void showMemberMenu() {
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("Member Menu:");
            System.out.println("1. Browse catalog by ISBN");
            System.out.println("2. Browse catalog by author");
            System.out.println("3. Browse catalog by title");
            System.out.println("4. Reserve a book/CD");
            System.out.println("5. Borrow a book/CD");
            System.out.println("6. Check overdue fees");
            System.out.println("7. Return to main menu");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    browseByISBN();
                    break;
                case 2:
                    browseByAuthor();
                    break;
                case 3:
                    browseByTitle();
                    break;
                case 4:
                    reserveItem();
                    break;
                case 5:
                    borrowItem();
                    break;
                case 6:
                    checkOverdueFees();
                    break;
                case 7:
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

	private void browseByISBN() {
		System.out.println("Enter the ISBN of the book you are looking for:");
        scanner.nextLine();
        String isbn = scanner.nextLine();
        
        Book book = library.findBookByISBN(isbn);
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("No book found with ISBN " + isbn);
        }
	}

	private void browseByAuthor() {
		System.out.println("Enter the author's name you are looking for:");
        scanner.nextLine();
        String author = scanner.nextLine();

        List<Book> booksByAuthor = library.findBooksByAuthor(author);
        if (!booksByAuthor.isEmpty()) {
            System.out.println("Books found:");
            for (Book book : booksByAuthor) {
                System.out.println(book);
            }
        } else {
            System.out.println("No books found by author " + author);
        }
        List<Dissertation> dissertationsByAuthor = library.findDissertationsByAuthor(author);
        if (!dissertationsByAuthor.isEmpty()) {
            System.out.println("Dissertations found:");
            for (Dissertation dissertation : dissertationsByAuthor) {
                System.out.println(dissertation);
            }
        } else {
            System.out.println("No dissertations found by author " + author);
        }
                
        List<CD> cdsByArtist = library.findCDsByArtist(author);
        if (!cdsByArtist.isEmpty()) {
            System.out.println("CDs found:");
            for (CD cd : cdsByArtist) {
                System.out.println(cd);
            }
        } else {
            System.out.println("No CDs found by artist " + author);
        }
    }

	private void browseByTitle() {
        System.out.println("Enter the title (or part of it) you are looking for:");
        scanner.nextLine();
        String titlePart = scanner.nextLine();
    
        System.out.println("Books:");
        List<Book> booksByTitle = library.findBooksByTitle(titlePart);
        if (!booksByTitle.isEmpty()) {
            for (Book book : booksByTitle) {
                System.out.println(book);
            }
        } else {
            System.out.println("No books found with the title: " + titlePart);
        }
    
        System.out.println("CDs:");
        List<CD> cdsByTitle = library.findCDsByTitle(titlePart);
        if (!cdsByTitle.isEmpty()) {
            for (CD cd : cdsByTitle) {
                System.out.println(cd);
            }
        } else {
            System.out.println("No CDs found with the title: " + titlePart);
        }
    }
    

	private void reserveItem() {
        System.out.println("Select the type of item to reserve:");
        System.out.println("1. Book");
        System.out.println("2. CD");
    
        int choice = scanner.nextInt();
        scanner.nextLine(); // To catch the newline character
    
        switch (choice) {
            case 1:
                reserveBook();
                break;
            case 2:
                reserveCD();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
    
    private void reserveBook() {
        System.out.println("Enter ISBN of the book to reserve:");
        String isbn = scanner.nextLine();
    
        if (library.reserveBook(isbn)) {
            System.out.println("Book with ISBN " + isbn + " has been reserved successfully.");
        } else {
            System.out.println("Unable to reserve the book. It might be already reserved or not available.");
        }
    }
    
    private void reserveCD() {
        System.out.println("Enter the title of the CD to reserve:");
        String title = scanner.nextLine();
    
        if (library.reserveCD(title)) {
            System.out.println("CD titled " + title + " has been reserved successfully.");
        } else {
            System.out.println("Unable to reserve the CD. It might be already reserved or not available.");
        }
    }
    
    private void borrowItem() {
        System.out.println("Enter your member ID:");
        int memberId = scanner.nextInt();
        scanner.nextLine(); 
    
        System.out.println("Select the type of item to borrow:");
        System.out.println("1. Book");
        System.out.println("2. CD");
    
        int itemType = scanner.nextInt();
        scanner.nextLine(); 
    
        switch (itemType) {
            case 1:
                borrowBook(memberId);
                break;
            case 2:
                borrowCD(memberId);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
    
    private void borrowBook(int memberId) {
        System.out.println("Enter the ISBN of the book to borrow:");
        String isbn = scanner.nextLine();

        boolean success = library.borrowBook(isbn, memberId);
        if (success) {
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Could not borrow the book. It might be already borrowed or not exist.");
        }
    }

    private void borrowCD(int memberId) {
        System.out.println("Enter the title of the CD to borrow:");
        String title = scanner.nextLine();

        boolean success = library.borrowCD(title, memberId);
        if (success) {
            System.out.println("CD borrowed successfully.");
        } else {
            System.out.println("Could not borrow the CD. It might be already borrowed or not exist.");
        }
    }
    

	private void checkOverdueFees() {
		System.out.println("Enter member ID to check overdue fees:");
        int memberId = scanner.nextInt();
        scanner.nextLine(); 

        double fees = library.calculateOverdueFees(memberId);
        if (fees > 0) {
            System.out.println("Total overdue fees for member ID " + memberId + ": " + fees);
        } else {
            System.out.println("No overdue fees for member ID " + memberId);
        }
	}


    private void addMember() {
        System.out.println("Enter member ID:");
        int memberId = scanner.nextInt(); // Odczytanie ID członka
        scanner.nextLine(); // Zbieranie znaku nowej linii
    
        System.out.println("Enter member name:");
        String name = scanner.nextLine(); // Odczytanie nazwy członka
    
        Member newMember = new Member(name, memberId);
        library.addMember(newMember);
        System.out.println("Member added successfully!");
    }
    

    private void removeMember() {
        System.out.println("Enter member ID to remove:");
        int memberId = scanner.nextInt();
        scanner.nextLine(); // Zbieranie znaku nowej linii po wczytaniu liczby
    
        // Zakładam, że klasa Library ma metodę removeMember(int memberId)
        boolean isRemoved = library.removeMember(memberId);
        if (isRemoved) {
            System.out.println("Member with ID " + memberId + " was removed successfully.");
        } else {
            System.out.println("Member with ID " + memberId + " not found.");
        }
    }
    

    private void addItem() {
        System.out.println("Select the type of item to add:");
        System.out.println("1. Book");
        System.out.println("2. CD");
    
        int choice = scanner.nextInt();
        scanner.nextLine(); 
    
        switch (choice) {
            case 1:
                addBook();
                break;
            case 2:
                addCD();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
    
    private void addBook() {
        System.out.println("Enter ISBN:");
        String isbn = scanner.nextLine();
    
        System.out.println("Enter Title:");
        String title = scanner.nextLine();
    
        System.out.println("Enter Author:");
        String author = scanner.nextLine();
    
        Book book = new Book(title, author, isbn);
        library.addBook(book);
        System.out.println("Book added successfully!");
    }
    
    private void addCD() {
        System.out.println("Enter Title:");
        String title = scanner.nextLine();
    
        System.out.println("Enter Artist:");
        String artist = scanner.nextLine();
    
        System.out.println("Enter Producer:");
        String producer = scanner.nextLine();
    
        System.out.println("Enter Play Time:");
        double playTime = scanner.nextDouble();
        scanner.nextLine(); 
    
        CD cd = new CD(title, artist, producer, playTime);
        library.addCD(cd);
        System.out.println("CD added successfully!");
    }
    

    private void removeItem() {
        System.out.println("Select the type of item to remove:");
        System.out.println("1. Book");
        System.out.println("2. CD");
    
        int choice = scanner.nextInt();
        scanner.nextLine(); // To catch the newline character
    
        switch (choice) {
            case 1:
                removeBook();
                break;
            case 2:
                removeCD();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    }
    
    private void removeBook() {
        System.out.println("Enter ISBN of the book to remove:");
        String isbn = scanner.nextLine();
    
        // class Library has a method removeBook(String isbn)
        boolean isRemoved = library.removeBook(isbn);
        if (isRemoved) {
            System.out.println("Book with ISBN " + isbn + " was removed successfully.");
        } else {
            System.out.println("Book with ISBN " + isbn + " not found.");
        }
    }
    
    private void removeCD() {
        System.out.println("Enter the title of the CD to remove:");
        String title = scanner.nextLine();
        
        boolean isRemoved = library.removeCD(title);
        if (isRemoved) {
            System.out.println("CD titled " + title + " was removed successfully.");
        } else {
            System.out.println("CD titled " + title + " not found.");
        }
    }

    private void addDissertation() {
        System.out.println("Enter dissertation title:");
        String title = scanner.nextLine();
    
        System.out.println("Enter author's name:");
        String author = scanner.nextLine();
    
        System.out.println("Enter university name:");
        String university = scanner.nextLine();
    
        System.out.println("Enter the year of publication:");
        int year = scanner.nextInt();
        scanner.nextLine();  
    
        System.out.println("Enter department name:");
        String department = scanner.nextLine();
    
        System.out.println("Enter advisor's name:");
        String advisor = scanner.nextLine();
    
        System.out.println("Enter abstract text:");
        String abstractText = scanner.nextLine();
    
        System.out.println("Enter dissertation ID:");
        String dissertationID = scanner.nextLine();
    
        Dissertation dissertation = new Dissertation(title, author, university, year, department, advisor, abstractText, dissertationID);
        library.addDissertation(dissertation);

        saveDissertation(dissertation);
    
        System.out.println("Dissertation added successfully.");
    }

    private void saveDissertation(Dissertation dissertation) {
        String fileName = "dissertations.csv";
        try {
            CSVUtil.saveDissertationToCSV(dissertation, fileName, true); // Zakładając, że taka metoda istnieje
            System.out.println("Dissertation saved to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while saving to CSV: " + e.getMessage());
        }
    }

    private void removeDissertation() {
        System.out.println("Enter dissertation ID to remove:");
        String dissertationID = scanner.nextLine();
    
        boolean isRemoved = library.removeDissertation(dissertationID);
        if (isRemoved) {
            System.out.println("Dissertation removed successfully.");
        } else {
            System.out.println("Dissertation with ID " + dissertationID + " not found.");
        }
    }
    
    private void sortByTitle() {
        System.out.println("Sorting items by title...");
        System.out.println("Books:");
        library.sortBooksByTitle().forEach(System.out::println);

        System.out.println("CDs:");
        library.sortCDsByTitle().forEach(System.out::println);
    }

    private void sortByISBN() {
        System.out.println("Sorting books by ISBN...");
        List<Book> sortedBooks = library.sortBooksByISBN();
        for (Book book : sortedBooks) {
            System.out.println("ISBN: " + book.getIsbn() + ", Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Borrowed: " + book.isBorrowed());
        }
    }

    private void sortByAuthor() {
        System.out.println("Sorting books by author...");
        List<Book> sortedBooks = library.sortBooksByAuthor();
        for (Book book : sortedBooks) {
            System.out.println("Author: " + book.getAuthor() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle() + ", Borrowed: " + book.isBorrowed());
        }
    
        System.out.println("Sorting CDs by artist...");
        List<CD> sortedCDs = library.sortCDsByArtist(); // Załóżmy, że mamy taką metodę
        for (CD cd : sortedCDs) {
            System.out.println("Artist: " + cd.getArtist() + ", Title: " + cd.getTitle() + ", Producer: " + cd.getProducer() + ", Available: " + cd.isAvailable());
        }
    }

    private void saveData() {
        library.saveLibraryState();
        System.out.println("Data saved successfully.");
    }
    
    private void readData() {
        library.loadLibraryState();
        System.out.println("Data loaded successfully.");
    }
    

    public static void main(String[] args) {
        Library library = new Library();
        library.loadLibraryState();
        LibraryMenu menu = new LibraryMenu(library);
        menu.showMainMenu();
    }
}

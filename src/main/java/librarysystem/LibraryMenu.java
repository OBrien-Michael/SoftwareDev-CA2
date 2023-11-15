package librarysystem;

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
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showLibrarianMenu();
                    break;
                case 2:
                    showMemberMenu();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
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
            System.out.println("5. Sort by title");
            System.out.println("6. Sort by ISBN");
            System.out.println("7. Sort by author");
            System.out.println("8. Save data");
            System.out.println("9. Read data");
            System.out.println("10. Return to main menu");
    
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
                    sortByTitle();
                    break;
                case 6:
                    sortByISBN();
                    break;
                case 7:
                    sortByAuthor();
                    break;
                case 8:
                    saveData();
                    break;
                case 9:
                    readData();
                    break;
                case 10:
                    keepRunning = false;
                    break;
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
        System.out.println("5. Check overdue fees");
        System.out.println("6. Return to main menu");

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
                checkOverdueFees();
                break;
            case 6:
                keepRunning = false;
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

	private void browseByISBN() {
		System.out.println("Enter the ISBN of the book you are looking for:");

        String isbn = scanner.nextLine();
        scanner.nextLine();
        Book book = library.findBookByISBN(isbn);
        if (book != null) {
            System.out.println("Book found: " + book);
        } else {
            System.out.println("No book found with ISBN " + isbn);
        }
	}

	private void browseByAuthor() {
		System.out.println("Enter the author's name you are looking for:");
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
	}

	private void browseByTitle() {
        System.out.println("Enter the title (or part of it) you are looking for:");
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
    
        // Zakładam, że klasa Library ma metodę removeCD(String title)
        boolean isRemoved = library.removeCD(title);
        if (isRemoved) {
            System.out.println("CD titled " + title + " was removed successfully.");
        } else {
            System.out.println("CD titled " + title + " not found.");
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

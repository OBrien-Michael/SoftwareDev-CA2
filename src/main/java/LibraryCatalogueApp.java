import library.Catalogue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

import library.abstracts.LibraryItem;

public class LibraryCatalogueApp {

    //Static Scanner to take in user input but be accessed anywhere in the Main class
    private static final Scanner userInput = new Scanner(System.in);
    private static final Catalogue libraryCatalogue = new Catalogue();

    // Date format for user input
    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args){

        appMainMenu();
    }


    //Main menu for the application
    private static void appMainMenu(){
        // Attempt to load library data from CSV files
        System.out.println("Attempting to load library data from CSV files...");
        libraryCatalogue.loadCatalogue();

        // Main menu in the loop
        while (true) {
            System.out.println("\n--------------------------");
            System.out.println("Welcome to the Library");
            System.out.println("--------------------------");

            System.out.println("\nPlease choose an option:");
            System.out.println("1. Library User Menu");
            System.out.println("2. Librarian Menu");
            System.out.println("3. Save and Exit");
            System.out.println("4. Exit\n");
            System.out.println("PLease enter your choose  :");

            // Get user's choice from input .
            try {
                int choice = Integer.parseInt(userInput.nextLine());
                switch (choice) {
                    case 1:
                        appLibraryUserMenu();   // Go to library user menu
                        break;
                    case 2:
                        appLibrarianMenu();     // Go to librarian menu
                        break;
                    case 3:
                        libraryCatalogue.saveCatalogue();  // Save the library catalogue and exit
                        System.out.println("Exiting Application.");
                        System.exit(0);
                        break;
                    case 4:                             // Exit the application
                        System.out.println("Exiting Application.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;

                    //Exception function to catch string from input console.
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid entry. Please enter a valid number" + ".");
            }
        }
    }


    //Library User Menu
    private static void appLibraryUserMenu(){
        while (true) {
            System.out.println("--------------------");
            System.out.println("\nLibrary User Menu:");
            System.out.println("--------------------");
            System.out.println("1. Open new Library User account");
            System.out.println("2. Display library items");
            System.out.println("3. Search for library item");
            System.out.println("4. Loan a library item");
            System.out.println("5. Return a library item");
            System.out.println("6. Check library user details and overdue items");
            System.out.println("7. Return to main menu\n");

            try {
                int choice = Integer.parseInt(userInput.nextLine());
                switch (choice) {
                    case 1:
                        createNewLibraryUserMenu();     // Create a new library user
                        break;
                    case 2:
                        displayLibraryItemsMenu();      // Display library items
                        break;
                    case 3:
                        searchForLibraryItemMenu();     // Search for a library item
                        break;
                    case 4:
                        loanItemMenu();                 // Loan a library item
                        break;
                    case 5:
                        returnItemMenu();               // Return a library item
                        break;
                    case 6:
                        checkLibraryUserMenu();         // Check library user details and overdue items
                        break;
                    case 7:
                        return; // This will exit the current menu and return to the previous menu
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
                //Exception function to catch string from input console.
            } catch (NumberFormatException e) {
                System.out.println("Invalid entry. Please enter a valid number.");
            }
        }
    }
    //Create a new Library User
    private static void createNewLibraryUserMenu(){

        System.out.println("\nPlease enter your name: ");

        String userName = userInput.nextLine();

        libraryCatalogue.addNewLibraryUser(userName);

        System.out.println("New account created for: "+libraryCatalogue.getLibraryUserLinkedList().getLast().getLibraryUserName()+", " +
                "User Id is:"+libraryCatalogue.getLibraryUserLinkedList().getLast().getLibraryUserId()+"\n\n");
    }

    private static void displayLibraryItemsMenu() {
        //menu for the user when is displaying items.
        while(true){
            System.out.println("\nDisplay Items:");
            System.out.println("----------------");
            System.out.println("1. List all items");
            System.out.println("2. List all items summary");
            System.out.println("3. List all available items");
            System.out.println("4. List all available books");
            System.out.println("5. List all available audiobooks");
            System.out.println("6. List all available cds");
            System.out.println("7. List all available dvds");
            System.out.println("8. List all available theses");
            System.out.println("9. List all available dissertations");
            System.out.println("10. List all unavailable items");
            System.out.println("11. Return to main menu.");


            try{
                int choice = Integer.parseInt(userInput.nextLine());
                switch (choice) {
                    case 1:
                        libraryCatalogue.listAllLibraryItemsAllDetails();    // Display all library items with full details
                        break;
                    case 2:
                        libraryCatalogue.listAllLibraryItemsSummaryDetails();   // Display all library items with summary details
                        break;
                    case 3:
                        libraryCatalogue.listAvailableItems();          // Display all available library items
                        break;
                    case 4:
                        libraryCatalogue.listAvailableBooks();          // Display all available books
                        break;
                    case 5:
                        libraryCatalogue.listAvailableAudioBooks();     // Display all available audiobooks
                        break;
                    case 6:
                        libraryCatalogue.listAvailableCDs();            // Display all available CDs
                        break;
                    case 7:
                        libraryCatalogue.listAvailableDVDs();           // Display all available DVDs
                        break;
                    case 8:
                        libraryCatalogue.listAvailableTheses();         // Display all available theses
                        break;
                    case 9:
                        libraryCatalogue.listAvailableDissertations();  // Display all available dissertations
                        break;
                    case 10:
                        libraryCatalogue.listUnavailableItems();        // Display all unavailable library items
                        break;
                    case 11:
                        return;                                         // Return to main menu
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid entry. Please enter a valid number" + ".");
            }
        }
    }
    private static void loanItemMenu() {

        System.out.println("\nCreate a new Loan:");

        System.out.println("Please enter your Library User ID:");
        try {
            int libraryUserId = Integer.parseInt(userInput.nextLine());         // Get library user ID

            System.out.println("Please enter the Item ID you would like to borrow:");
            int libraryItemId = Integer.parseInt(userInput.nextLine());         // Get library item ID

            libraryCatalogue.createNewLoanById(libraryUserId,libraryItemId);    // Create a new loan by library user ID and item ID
        } catch (NumberFormatException e) {
            System.out.println("Invalid entry. Please enter a valid number" + ".");
        }

    }


    private static void returnItemMenu() {

        System.out.println("\nReturning an Item to the Library:");

        System.out.println("Please enter the Item ID you would like to return:");
        try{
            int libraryItemId = Integer.parseInt(userInput.nextLine());         // Get library item ID

            libraryCatalogue.returnItemById(libraryItemId);                     // Return item by library item ID
        } catch (NumberFormatException e) {
            System.out.println("Invalid entry. Please enter a valid number" + ".");
        }

    }
    // return Item sub Menu
    private static void searchForLibraryItemMenu() {
        System.out.println("\nSearch for a Library Item:");

        System.out.println("Please enter the Item ID you would like to search for:");
        try {
            int libraryItemId = Integer.parseInt(userInput.nextLine());

            LibraryItem libraryItem = libraryCatalogue.searchByLibraryItemId(libraryItemId);
            if (libraryItem != null) {
                // Call the display all details method to print to screen
                libraryItem.displayAllDetails();
            } else {
                System.out.println("No item found with ID: " + libraryItemId);
            }
        } catch (NumberFormatException e) {                     // Exception to catch invalid entry
            System.out.println("Invalid entry. Please enter a valid number" + ".");
        }
    }



    private static void checkLibraryUserMenu() {

        System.out.println("\n:");

        System.out.println("Please enter your Library User ID:");
        int libraryUserId = Integer.parseInt(userInput.nextLine());

        libraryCatalogue.checkLibraryUserDetailsById(libraryUserId);


    }

    //Librarian Menu

    private static void appLibrarianMenu() {
        while (true) {
            System.out.println("---------------");
            System.out.println("Librarian Menu:");
            System.out.println("---------------");
            System.out.println("1. Add new library user");
            System.out.println("2. Delete a library user");
            System.out.println("3. Add new author");
            System.out.println("4. Delete an author");
            System.out.println("5. Add new library item");
            System.out.println("6. Delete a library item");
            System.out.println("7. Display library items");
            System.out.println("8. Search library items");
            System.out.println("9. Display all Authors");
            System.out.println("10. Save and Load functions");
            System.out.println("11. Generate Borrowed Items Report");
            System.out.println("12. Generate Overdue Items Report");
            System.out.println("13. Return to main menu");

            try {
                int choice = Integer.parseInt(userInput.nextLine());
                switch (choice) {
                    case 1:
                        createNewLibraryUserMenu();
                        break;
                    case 2:
                        removeLibraryUserMenu();
                        break;
                    case 3:
                        addNewAuthorMenu();
                        break;
                    case 4:
                        removeAuthorMenu();
                        break;
                    case 5:
                        addNewLibraryItemMenu();
                        break;
                    case 6:
                        removeLibraryItemMenu();
                        break;
                    case 7:
                        displayLibraryItemsMenu();
                        break;
                    case 8:
                        searchForLibraryItemMenu();
                        break;
                    case 9:
                        displayAuthorDataMenu();
                        break;
                    case 10:
                        saveAndLoadFunctionMenu();
                        break;
                    case 11:
                        generateBorrowedItemsReportMenu();
                        break;
                    case 12:
                        generateOverdueItemsReportMenu();
                        break;
                    case 13:
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid entry. Please enter a valid number" + ".");
            }
        }
    }

    private static void removeLibraryUserMenu() {
        System.out.println("\nPlease enter the Library Users Id you wish to remove: ");

        try {
            int libraryUserId = Integer.parseInt(userInput.nextLine());

            libraryCatalogue.removeLibraryUserById(libraryUserId);
        } catch (NumberFormatException e) {
            System.out.println("Invalid entry. Please enter a valid number" + ".");
        }

    }


    private static void addNewAuthorMenu() {

        System.out.println("\nPlease enter the Authors name you wish to add: ");

        String authorName = userInput.nextLine();

        libraryCatalogue.addNewAuthor(authorName);

    }

    private static void removeAuthorMenu() {
        System.out.println("\nPlease enter the Authors Id you wish to remove: ");

        try {
            int authorId = Integer.parseInt(userInput.nextLine());

            libraryCatalogue.removeAuthorById(authorId);
        } catch (NumberFormatException e) {
            System.out.println("Invalid entry. Please enter a valid number" + ".");
        }
    }

    private static void addNewLibraryItemMenu() {

        System.out.println("Add new Library Item Menu:");
        System.out.println("1. Add new Book");
        System.out.println("2. Add new AudioBook");
        System.out.println("3. Add new CD");
        System.out.println("4. Add new DVD");
        System.out.println("5. Add new Theses");
        System.out.println("6. Add new Dissertation");
        System.out.println("7. Return to Librarian Menu");


        try {
            int choice = Integer.parseInt(userInput.nextLine());
            switch (choice) {
                case 1:
                    addNewBookMenu();
                    break;
                case 2:
                    addNewAudioBookMenu();
                    break;
                case 3:
                    addNewCDMenu();
                    break;
                case 4:
                    addNewDVDMenu();
                    break;
                case 5:
                    addNewThesesMenu();
                    break;
                case 6:
                    addNewDissertationMenu();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid entry. Please enter a valid number" + ".");
        }


    }
    //section for the new book with restrictions of 13 dig number .
    private static void addNewBookMenu() {
        System.out.println("Please enter the Title of the Book:");
        String bookTitle = userInput.nextLine();

        System.out.println("Please enter the Authors Id:");
        int bookAuthorId = Integer.parseInt(userInput.nextLine());

        String bookIsbn;
        while (true) {
            System.out.println("Please enter the ISBN of the Book (13 digits):");
            bookIsbn = userInput.nextLine();
            if (isValidIsbn(bookIsbn)) {
                break;
            }
            System.out.println("Invalid ISBN. The ISBN must be a 13-digit integer.");
        }

        libraryCatalogue.addNewBook(bookTitle, bookAuthorId, bookIsbn);
    }

    private static boolean isValidIsbn(String isbn) {
        return isbn.matches("\\d{13}");
    }
    private static void addNewAudioBookMenu() {

        try {
            System.out.println("Please enter the Title of the AudioBook:");
            String audioBookTitle = userInput.nextLine();

            System.out.println("Please enter the Authors Id:");
            int audioBookAuthorId = Integer.parseInt(userInput.nextLine());

            System.out.println("Please enter the ISBN of the AudioBook:");
            String audioBookIsbn = userInput.nextLine();


            libraryCatalogue.addNewAudioBook(audioBookTitle,audioBookAuthorId,audioBookIsbn);
        } catch (NumberFormatException e) {
            System.out.println("Invalid entry. Please enter a valid number" + ".");
        }
    }

    private static void addNewCDMenu() {

        try {
            System.out.println("Please enter the Title of the CD:");
            String cdTitle = userInput.nextLine();

            System.out.println("Please enter the Authors Id:");
            int cdAuthorId = Integer.parseInt(userInput.nextLine());

            System.out.println("Please enter the Playtime of the CD:");
            int cdPlaytime = Integer.parseInt(userInput.nextLine());

            libraryCatalogue.addNewCD(cdTitle,cdAuthorId,cdPlaytime);
        } catch (NumberFormatException e) {
            System.out.println("Invalid entry. Please enter a valid number" + ".");
        }
    }

    private static void addNewDVDMenu() {

        try {
            System.out.println("Please enter the Title of the DVD:");
            String dvdTitle = userInput.nextLine();

            System.out.println("Please enter the Authors Id:");
            int dvdAuthorId = Integer.parseInt(userInput.nextLine());

            System.out.println("Please enter the Playtime of the DVD:");
            int dvdPlaytime = Integer.parseInt(userInput.nextLine());

            libraryCatalogue.addNewDVD(dvdTitle,dvdAuthorId,dvdPlaytime);
        } catch (NumberFormatException e) {
            System.out.println("Invalid entry. Please enter a valid number" + ".");
        }
    }

    private static void addNewThesesMenu() {

        try {
            System.out.println("Please enter the Title of the Theses:");
            String thesesTitle = userInput.nextLine();

            System.out.println("Please enter the Authors Id:");
            int thesesAuthorId = Integer.parseInt(userInput.nextLine());

            System.out.println("Please enter the Topic of the Theses:");
            String thesesTopic = userInput.nextLine();

            System.out.println("Please enter the Abstract of the Theses:");
            String thesesAbstractText = userInput.nextLine();

            System.out.println("Please enter the Date the Theses was published:");
            System.out.println("(DD/MM/YYYY)");
            LocalDate thesesDatePublished = LocalDate.parse(userInput.nextLine(), dateFormatter);

            libraryCatalogue.addNewTheses(thesesTitle, thesesAuthorId, thesesTopic, thesesAbstractText, thesesDatePublished);
        } catch (NumberFormatException e) {
            System.out.println("Invalid entry. Please enter a valid number" + ".");
        } catch (DateTimeParseException dateTimeParseException){
            System.out.println("Invalid entry. Please enter the date in the valid format of **/**/****");
        }
    }

    private static void addNewDissertationMenu() {

        try {
            System.out.println("Please enter the Title of the Dissertation:");
            String dissertationTitle = userInput.nextLine();

            System.out.println("Please enter the Authors Id:");
            int dissertationAuthorId = Integer.parseInt(userInput.nextLine());

            System.out.println("Please enter the Topic of the Dissertation:");
            String dissertationTopic = userInput.nextLine();

            System.out.println("Please enter the Abstract of the Dissertation:");
            String dissertationAbstractText = userInput.nextLine();

            System.out.println("Please enter the Date the Dissertation was published:");
            System.out.println("(DD/MM/YYYY)");
            LocalDate dissertationDatePublished = LocalDate.parse(userInput.nextLine(),dateFormatter);


            libraryCatalogue.addNewDissertation(dissertationTitle,dissertationAuthorId,dissertationTopic,dissertationAbstractText,dissertationDatePublished);
        } catch (NumberFormatException e) {
            System.out.println("Invalid entry. Please enter a valid number" + ".");
        } catch (DateTimeParseException dateTimeParseException){
            System.out.println("Invalid entry. Please enter the date in the valid format of **/**/****");
        }
    }


    private static void removeLibraryItemMenu() {
        try {
            System.out.println("\nPlease enter the Library Items Id you wish to remove: ");

            int libraryItemId = Integer.parseInt(userInput.nextLine());

            libraryCatalogue.removeLibraryItemById(libraryItemId);
        } catch (NumberFormatException e) {
            System.out.println("Invalid entry. Please enter a valid number" + ".");
        }
    }

    private static void displayAuthorDataMenu() {

        System.out.println("\nDisplaying all details of the Authors from our Library:");
        libraryCatalogue.listAllAuthorsAllDetails();
    }

    private static void saveAndLoadFunctionMenu() {

        System.out.println("\nWould you like to Save or Load the catalogue?");
        System.out.println("1. Save Catalogue");
        System.out.println("2. Load Catalogue");
        System.out.println("3. Return to Librarian Menu");

        try {
            int choice = Integer.parseInt(userInput.nextLine());
            switch (choice) {
                case 1:
                    libraryCatalogue.saveCatalogue();
                    break;
                case 2:
                    libraryCatalogue.loadCatalogue();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid entry. Please enter a valid number" + ".");
        }
    }

    private static void generateBorrowedItemsReportMenu() {

        libraryCatalogue.generateBorrowedItemsReport();

    }

    private static void generateOverdueItemsReportMenu() {

        libraryCatalogue.generateOverdueItemsReport();

    }


}
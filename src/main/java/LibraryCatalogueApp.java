import library.Catalogue;
import library.LibraryUser;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileReader;

public class LibraryCatalogueApp {

    //Static Scanner to take in user input but be accessed anywhere in the Main class
    private static Scanner userInput = new Scanner(System.in);
    private static Catalogue libraryCatalogue = new Catalogue();

    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static LocalDate testDate = LocalDate.parse("10/11/1999", dateFormatter);
    public static void main(String[] args){

        //libraryCatalogue.loadCatalogue();

        //Uncomment to generate some test data
        //testData();

        appMainMenu();
    }


    //Main menu for the application
    private static void appMainMenu(){

        //System.out.println("Would you like to load data?");
        //System.out.println("1. Yes");
        //System.out.println("Any other number for no");
        //int choice = Integer.parseInt(userInput.nextLine());
        //if(choice == 1){
        System.out.println("Loading from CSV files...");
        libraryCatalogue.loadCatalogue();
        //}


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

            try {
                int choice = Integer.parseInt(userInput.nextLine());
                switch (choice) {
                    case 1:
                        appLibraryUserMenu();
                        break;
                    case 2:
                        appLibrarianMenu();
                        break;
                    case 3:
                        libraryCatalogue.saveCatalogue();
                        System.out.println("Exiting Application.");
                        System.exit(0);
                        break;
                    case 4:
                        System.out.println("Exiting Application.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
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
                        createNewLibraryUserMenu();
                        break;
                    case 2:
                        displayLibraryItemsMenu();
                        break;
                    case 3:
                        searchForLibraryItemMenu();
                        break;
                    case 4:
                        loanItemMenu();
                        break;
                    case 5:
                        returnItemMenu();
                        break;
                    case 6:
                        checkLibraryUserMenu();
                        break;
                    case 7:
                        return; // This will exit the current menu and return to the previous menu
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
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


        int choice = Integer.parseInt(userInput.nextLine());
        switch (choice) {
            case 1:
                libraryCatalogue.listAllLibraryItemsAllDetails();
                break;
            case 2:
                libraryCatalogue.listAllLibraryItemsSummaryDetails();
                break;
            case 3:
                libraryCatalogue.listAvailableItems();
                break;
            case 4:
                libraryCatalogue.listAvailableBooks();
                break;
            case 5:
                libraryCatalogue.listAvailableAudioBooks();
                break;
            case 6:
                libraryCatalogue.listAvailableCDs();
                break;
            case 7:
                libraryCatalogue.listAvailableDVDs();
                break;
            case 8:
                libraryCatalogue.listAvailableTheses();
                break;
            case 9:
                libraryCatalogue.listAvailableDissertations();
                break;
            case 10:
                libraryCatalogue.listUnavailableItems();
                break;
            case 11:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
    private static void loanItemMenu() {

        System.out.println("\nCreate a new Loan:");

        System.out.println("Please enter your Library User ID:");
        int libraryUserId = Integer.parseInt(userInput.nextLine());

        System.out.println("Please enter the Item ID you would like to borrow:");
        int libraryItemId = Integer.parseInt(userInput.nextLine());

        libraryCatalogue.createNewLoanById(libraryUserId,libraryItemId);

    }


    private static void returnItemMenu() {

        System.out.println("\nReturning an Item to the Library:");

        System.out.println("Please enter the Item ID you would like to return:");
        int libraryItemId = Integer.parseInt(userInput.nextLine());

        libraryCatalogue.returnItemById(libraryItemId);
    }

    private static void searchForLibraryItemMenu() {
        //TODO
        System.out.println("Todo");
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
        }
    }

    private static void removeLibraryUserMenu() {
        System.out.println("\nPlease enter the Library Users Id you wish to remove: ");

        int libraryUserId = Integer.parseInt(userInput.nextLine());

        libraryCatalogue.removeLibraryUserById(libraryUserId);

    }


    private static void addNewAuthorMenu() {

        System.out.println("\nPlease enter the Authors name you wish to add: ");

        String authorName = userInput.nextLine();

        libraryCatalogue.addNewAuthor(authorName);

    }

    private static void removeAuthorMenu() {
        System.out.println("\nPlease enter the Authors Id you wish to remove: ");

        int authorId = Integer.parseInt(userInput.nextLine());

        libraryCatalogue.removeAuthorById(authorId);
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


    }

    private static void addNewBookMenu() {

        System.out.println("Please enter the Title of the Book:");
        String bookTitle = userInput.nextLine();

        System.out.println("Please enter the Authors Id:");
        int bookAuthorId = Integer.parseInt(userInput.nextLine());

        System.out.println("Please enter the ISBN of the Book:");
        String bookIsbn = userInput.nextLine();


        libraryCatalogue.addNewBook(bookTitle,bookAuthorId,bookIsbn);
    }

    private static void addNewAudioBookMenu() {

        System.out.println("Please enter the Title of the AudioBook:");
        String audioBookTitle = userInput.nextLine();

        System.out.println("Please enter the Authors Id:");
        int audioBookAuthorId = Integer.parseInt(userInput.nextLine());

        System.out.println("Please enter the ISBN of the AudioBook:");
        String audioBookIsbn = userInput.nextLine();


        libraryCatalogue.addNewAudioBook(audioBookTitle,audioBookAuthorId,audioBookIsbn);
    }

    private static void addNewCDMenu() {

        System.out.println("Please enter the Title of the CD:");
        String cdTitle = userInput.nextLine();

        System.out.println("Please enter the Authors Id:");
        int cdAuthorId = Integer.parseInt(userInput.nextLine());

        System.out.println("Please enter the Playtime of the CD:");
        int cdPlaytime = Integer.parseInt(userInput.nextLine());

        libraryCatalogue.addNewCD(cdTitle,cdAuthorId,cdPlaytime);
    }

    private static void addNewDVDMenu() {

        System.out.println("Please enter the Title of the DVD:");
        String dvdTitle = userInput.nextLine();

        System.out.println("Please enter the Authors Id:");
        int dvdAuthorId = Integer.parseInt(userInput.nextLine());

        System.out.println("Please enter the Playtime of the DVD:");
        int dvdPlaytime = Integer.parseInt(userInput.nextLine());

        libraryCatalogue.addNewDVD(dvdTitle,dvdAuthorId,dvdPlaytime);
    }

    private static void addNewThesesMenu() {

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
        LocalDate thesesDatePublished = LocalDate.parse(userInput.nextLine(),dateFormatter);

        libraryCatalogue.addNewTheses(thesesTitle,thesesAuthorId,thesesTopic,thesesAbstractText,thesesDatePublished);
    }

    private static void addNewDissertationMenu() {

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
    }


    private static void removeLibraryItemMenu() {
        System.out.println("\nPlease enter the Library Items Id you wish to remove: ");

        int libraryItemId = Integer.parseInt(userInput.nextLine());

        libraryCatalogue.removeLibraryItemById(libraryItemId);
    }

    private static void displayAuthorDataMenu() {
        System.out.println("\nDisplaying ID of the Authors from our Library:");
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("Author.csv"))) {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while trying to read the file.");
            e.printStackTrace();
        }
    }

    private static void saveAndLoadFunctionMenu() {

        System.out.println("\nWould you like to Save or Load the catalogue?");
        System.out.println("1. Save Catalogue");
        System.out.println("2. Load Catalogue");
        System.out.println("3. Return to Librarian Menu");

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
    }

    private static void generateBorrowedItemsReportMenu() {

        libraryCatalogue.generateBorrowedItemsReport();

    }

    private static void generateOverdueItemsReportMenu() {

        libraryCatalogue.generateOverdueItemsReport();

    }






    private static void testData(){

        libraryCatalogue.listAllLibraryItemsAllDetails();

        libraryCatalogue.listAllLibraryItemsSummaryDetails();

        libraryCatalogue.listAllLibraryUsersAllDetails();

        libraryCatalogue.listAllLibraryUsersSummaryDetails();


        libraryCatalogue.removeAuthorById(1);

        libraryCatalogue.addNewAuthor("Zayd Henderson");
        libraryCatalogue.addNewAuthor("Vinnie Dalton");
        libraryCatalogue.addNewAuthor("Rebekah Mcgee");
        libraryCatalogue.addNewAuthor("Jag Sullivan");
        libraryCatalogue.addNewAuthor("Kris Roman");
        libraryCatalogue.addNewAuthor("Ridley Scot");

        libraryCatalogue.removeAuthorById(1);
        libraryCatalogue.removeAuthorById(4);

        libraryCatalogue.addNewBook("Java",2,"12312312");
        libraryCatalogue.addNewBook("C#",2,"1231231343242");
        libraryCatalogue.addNewBook("F#",2,"12312352352312");

        libraryCatalogue.addNewAudioBook("Agile",2,"1212121212121");
        libraryCatalogue.addNewAudioBook("Scrum",2,"1212121212121");
        libraryCatalogue.addNewAudioBook("Kanban",2,"12312352352312");

        libraryCatalogue.addNewCD("Abba",2,20);
        libraryCatalogue.addNewCD("Fijiwiji",2,40);
        libraryCatalogue.addNewCD("Metallica",2,60);

        libraryCatalogue.addNewDVD("Marvel",4,180);
        libraryCatalogue.addNewDVD("DC",5,160);
        libraryCatalogue.addNewDVD("Alien",6,150);

        libraryCatalogue.addNewTheses("Ants",5,"AI","Abstract1",testDate);
        libraryCatalogue.addNewTheses("RSA",5,"Crypto","abstract2",testDate);
        libraryCatalogue.addNewTheses("DSA",5,"Crypto","abstract3",testDate);

        libraryCatalogue.addNewDissertation("Java",5,"TOPICAL","Abstract1",testDate);
        libraryCatalogue.addNewDissertation("C#",5,"TOPICAL2","abstract2",testDate);
        libraryCatalogue.addNewDissertation("F#",5,"TOPICAL3","abstract3",testDate);

        libraryCatalogue.removeLibraryItemById(1);
        libraryCatalogue.removeLibraryItemById(4);
        libraryCatalogue.removeLibraryItemById(8);
        libraryCatalogue.removeLibraryItemById(10);
        libraryCatalogue.removeLibraryItemById(22);
        libraryCatalogue.removeLibraryItemById(3);

        libraryCatalogue.addNewLibraryUser("Jim");
        libraryCatalogue.addNewLibraryUser("John");

        libraryCatalogue.createNewLoanById(1,2);
        libraryCatalogue.createNewLoanById(1,2);
        libraryCatalogue.createNewLoanById(0,0);
        libraryCatalogue.createNewLoanById(1,3);
        libraryCatalogue.createNewLoanById(1,4);
        libraryCatalogue.createNewLoanById(1,5);

        libraryCatalogue.returnItemById(0);
        libraryCatalogue.returnItemById(1);
        libraryCatalogue.returnItemById(2);
        libraryCatalogue.returnItemById(3);
        libraryCatalogue.returnItemById(4);
        libraryCatalogue.returnItemById(5);
        libraryCatalogue.returnItemById(6);
        libraryCatalogue.returnItemById(7);
        libraryCatalogue.returnItemById(8);
        libraryCatalogue.returnItemById(9);
        libraryCatalogue.returnItemById(10);
        libraryCatalogue.returnItemById(11);

        libraryCatalogue.createNewLoanById(1,1);
        libraryCatalogue.createNewLoanById(1,2);
        libraryCatalogue.createNewLoanById(1,3);
        libraryCatalogue.createNewLoanById(1,4);
        libraryCatalogue.createNewLoanById(1,5);

        libraryCatalogue.createNewLoanById(1,6);
        libraryCatalogue.createNewLoanById(1,7);





        libraryCatalogue.listAllLibraryItemsAllDetails();

        libraryCatalogue.listAllLibraryItemsSummaryDetails();

        libraryCatalogue.listAllLibraryUsersAllDetails();

        libraryCatalogue.listAllLibraryUsersSummaryDetails();

        libraryCatalogue.listAllAuthorsAllDetails();

        libraryCatalogue.listAllAuthorsSummaryDetails();



        libraryCatalogue.listAvailableItems();

        libraryCatalogue.listUnavailableItems();

    }

}
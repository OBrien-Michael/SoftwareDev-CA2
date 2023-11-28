import library.Catalogue;
import library.LibraryUser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibraryCatalogueApp {

    //Static Scanner to take in user input but be accessed anywhere in the Main class
    private static Scanner userInput = new Scanner(System.in);
    private static Catalogue libraryCatalogue = new Catalogue();

    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static LocalDate testDate = LocalDate.parse("10/11/1999", dateFormatter);
    public static void main(String[] args){

        //libraryCatalogue.loadCatalogue();

        //Uncomment to generate some test data
        testData();

        //appMainMenu();
    }


    //Main menu for the application
    private static void appMainMenu(){
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Library User Menu");
            System.out.println("2. Librarian Menu");
            System.out.println("3. Exit");

            int choice = Integer.parseInt(userInput.nextLine());
            switch (choice) {
                case 1:
                    appLibraryUserMenu();
                    break;
                case 2:
                    appLibrarianMenu();
                    break;
                case 3:
                    System.out.println("Exiting Application.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                }

        }
    }


    private static void appLibraryUserMenu(){
        while (true) {
            System.out.println("Member Menu:");
            System.out.println("1. Open new Library User account");
            System.out.println("2. Display library items");
            System.out.println("3. Search for library item");
            System.out.println("4. Loan a library item");
            System.out.println("5. Loan a library item");
            System.out.println("6. Check library user account");
            System.out.println("7. Return to main menu");


            int choice = Integer.parseInt(userInput.nextLine());
            switch (choice) {
                case 1:
                    createNewLibraryUser();
                    break;
                case 2:
                    displayLibraryItemsMenu();
                    break;
                case 3:
                    //searchForLibraryItemMenu();
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        }
    }

    //Create a new Library User
    private static void createNewLibraryUser(){

        System.out.println("Please enter your name: ");

        String userName = userInput.nextLine();

        libraryCatalogue.addNewLibraryUser(userName);

        System.out.println("New account created for: "+libraryCatalogue.getLibraryUserLinkedList().getLast().getLibraryUserName()+", " +
                "User Id is:"+libraryCatalogue.getLibraryUserLinkedList().getLast().getLibraryUserId()+"\n\n");
    }

    private static void displayLibraryItemsMenu() {
        System.out.println("Display:");
        System.out.println("1. List all items");
        System.out.println("2. List all available books");
        System.out.println("3. List all available audiobooks");
        System.out.println("4. List all available cds");
        System.out.println("5. List all available dvds");
        System.out.println("6. List all available theses");
        System.out.println("7. List all available dissertations");
        System.out.println("8. List all unavailable items");
        System.out.println("9. Return to main menu.");


        int choice = Integer.parseInt(userInput.nextLine());
        switch (choice) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:

                break;
            case 5:

                break;
            case 6:

                break;
            case 7:
                break;
            case 8:
                //listUnavailableItems();
                break;
            case 9:
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }




























    private static void appLibrarianMenu(){
        while(true) {
            System.out.println("Librarian Menu:");
            System.out.println("1. Add new library user");
            System.out.println("2. Remove member");
            System.out.println("3. Add new library item");
            System.out.println("4. Sort by title");
            System.out.println("5. Sort by ISBN");
            System.out.println("6. Sort by author");
            System.out.println("7. Save data");
            System.out.println("8. Read data");
            System.out.println("9. Generate Borrowed Items Report");
            System.out.println("10. Generate Overdue Report");
            System.out.println("11. Return to main menu");

            switch (userInput.nextInt()) {
                case 1:
                    //addMember();
                    break;
                case 2:
                    //removeMember();
                    break;
                case 3:
                    //addItem();
                    break;
                case 4:
                    //removeItem();
                    break;
                case 5:
                    //addDissertation();
                    break;
                case 6:
                    //removeDissertation();
                    break;
                case 7:
                    //sortByTitle();
                    break;
                case 8:
                    //sortByISBN();
                    break;
                case 9:
                    //sortByAuthor();
                    break;
                case 10:
                    //saveData();
                    break;
                case 11:
                    //readData();
                    break;
                case 12:
                    //System.out.println(library.generateBorrowedItemsReport());
                    break;
                case 13:
                    //System.out.println(library.generateOverdueReport());
                    break;
                case 14:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
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

        libraryCatalogue.addNewLoanById(1,2);
        libraryCatalogue.addNewLoanById(1,2);
        libraryCatalogue.addNewLoanById(0,0);
        libraryCatalogue.addNewLoanById(1,3);
        libraryCatalogue.addNewLoanById(1,4);
        libraryCatalogue.addNewLoanById(1,5);

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

        libraryCatalogue.addNewLoanById(1,1);
        libraryCatalogue.addNewLoanById(1,2);
        libraryCatalogue.addNewLoanById(1,3);
        libraryCatalogue.addNewLoanById(1,4);
        libraryCatalogue.addNewLoanById(1,5);

        libraryCatalogue.addNewLoanById(1,6);
        libraryCatalogue.addNewLoanById(1,7);





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
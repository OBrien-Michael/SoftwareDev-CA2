import library.Catalogue;

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
        //testData();

        appMainMenu();
    }


    //Main menu for the application
    private static void appMainMenu(){
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Library User Menu");
            System.out.println("2. Librarian Menu");
            System.out.println("3. Exit");

            int choice = userInput.nextInt();
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
            System.out.println("1. Browse catalog by ISBN");
            System.out.println("2. Browse catalog by author");
            System.out.println("3. Browse catalog by title");
            System.out.println("4. Reserve a book/CD");
            System.out.println("5. Borrow a book/CD");
            System.out.println("6. Check overdue fees");
            System.out.println("7. Return to main menu");

            int choice = userInput.nextInt();
            switch (choice) {
                case 1:
                    //browseByISBN();
                    break;
                case 2:
                    //browseByAuthor();
                    break;
                case 3:
                    //browseByTitle();
                    break;
                case 4:
                    //reserveItem();
                    break;
                case 5:
                    //borrowItem();
                    break;
                case 6:
                    //checkOverdueFees();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private static void appLibrarianMenu(){
        while(true) {
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
        libraryCatalogue.removeAuthorById(1);

        libraryCatalogue.addNewAuthor("1");
        libraryCatalogue.addNewAuthor("2");
        libraryCatalogue.addNewAuthor("3");
        libraryCatalogue.addNewAuthor("4");
        libraryCatalogue.addNewAuthor("5");

        libraryCatalogue.removeAuthorById(1);
        libraryCatalogue.removeAuthorById(4);

        libraryCatalogue.addNewBook("Java",2,"12312312");
        libraryCatalogue.addNewBook("C#",2,"1231231343242");
        libraryCatalogue.addNewBook("F#",2,"12312352352312");

        libraryCatalogue.addNewAudioBook("Java",2,"12312312");
        libraryCatalogue.addNewAudioBook("C#",2,"1231231343242");
        libraryCatalogue.addNewAudioBook("F#",2,"12312352352312");

        libraryCatalogue.addNewCD("Java",2,20);
        libraryCatalogue.addNewCD("C#",2,40);
        libraryCatalogue.addNewCD("F#",2,60);

        libraryCatalogue.addNewDVD("Java",2,10);
        libraryCatalogue.addNewDVD("C#",2,12);
        libraryCatalogue.addNewDVD("F#",2,14);

        libraryCatalogue.addNewTheses("Java",5,"TOPICAL","Abstract1",testDate);
        libraryCatalogue.addNewTheses("C#",5,"TOPICAL2","abstract2",testDate);
        libraryCatalogue.addNewTheses("F#",5,"TOPICAL3","abstract3",testDate);

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
    }

}
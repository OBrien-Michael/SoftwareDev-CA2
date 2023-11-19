import library.Catalogue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LibraryCatalogueApp {
    public static void main(String[] args){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse("10/11/1999", formatter);

        Catalogue libraryCatalogue = new Catalogue();

        Scanner userInput = new Scanner(System.in);

        libraryCatalogue.loadCatalogue();


        libraryCatalogue.removeAuthorById(1);

        libraryCatalogue.addNewAuthor("1");
        libraryCatalogue.addNewAuthor("2");
        libraryCatalogue.addNewAuthor("3");
        libraryCatalogue.addNewAuthor("4");
        libraryCatalogue.addNewAuthor("5");

        libraryCatalogue.removeAuthorById(1);
        libraryCatalogue.removeAuthorById(4);

        System.out.println(libraryCatalogue.getAuthorLinkedList().toString());


        libraryCatalogue.addNewBook("Java",2,"12312312");
        libraryCatalogue.addNewBook("C#",2,"1231231343242");
        libraryCatalogue.addNewBook("REEEEE",2,"12312352352312");

        System.out.println(libraryCatalogue.getLibraryItemLinkedList().toString());

        libraryCatalogue.addNewAudioBook("Java",2,"12312312");
        libraryCatalogue.addNewAudioBook("C#",2,"1231231343242");
        libraryCatalogue.addNewAudioBook("REEEEE",2,"12312352352312");

        System.out.println(libraryCatalogue.getLibraryItemLinkedList().toString());

        libraryCatalogue.addNewCD("Java",2,20);
        libraryCatalogue.addNewCD("C#",2,40);
        libraryCatalogue.addNewCD("REEEEE",2,60);

        System.out.println(libraryCatalogue.getLibraryItemLinkedList().toString());

        libraryCatalogue.addNewDVD("Java",2,10);
        libraryCatalogue.addNewDVD("C#",2,12);
        libraryCatalogue.addNewDVD("REEEEE",2,14);

        System.out.println(libraryCatalogue.getLibraryItemLinkedList().toString());

        libraryCatalogue.addNewTheses("Java",5,"TOPICAL","Abstract1",date);
        libraryCatalogue.addNewTheses("C#",5,"TOPICAL2","abstract2",date);
        libraryCatalogue.addNewTheses("REEEEE",5,"TOPICAL3","abstract3",date);

        System.out.println(libraryCatalogue.getLibraryItemLinkedList().toString());

        libraryCatalogue.addNewDissertation("Java",5,"TOPICAL","Abstract1",date);
        libraryCatalogue.addNewDissertation("C#",5,"TOPICAL2","abstract2",date);
        libraryCatalogue.addNewDissertation("REEEEE",5,"TOPICAL3","abstract3",date);

        System.out.println(libraryCatalogue.getLibraryItemLinkedList().toString());


        libraryCatalogue.removeLibraryItemById(1);
        libraryCatalogue.removeLibraryItemById(4);
        libraryCatalogue.removeLibraryItemById(8);
        libraryCatalogue.removeLibraryItemById(10);
        libraryCatalogue.removeLibraryItemById(22);
        libraryCatalogue.removeLibraryItemById(3);


        System.out.println(libraryCatalogue.getLibraryItemLinkedList().toString());

        libraryCatalogue.addNewLibraryUser("Jim");
        libraryCatalogue.addNewLibraryUser("John");


        libraryCatalogue.addNewLoanById(1,2);


/*
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Library User Menu");
            System.out.println("2. Librarian Menu");
            System.out.println("3. Exit");

            int choice = userInput.nextInt();
            switch (choice) {
                case 1:
                    //
                    break;
                case 2:
                    //
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
*/



    }
}
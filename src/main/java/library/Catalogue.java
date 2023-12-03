package library;

import library.abstracts.LibraryItem;
import library.exceptions.AuthorException;
import library.exceptions.LibraryItemException;
import library.exceptions.LibraryUserException;
import library.exceptions.LoanException;
import library.lambdas.LibraryUserFinder;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.LinkedList;

import static java.time.temporal.ChronoUnit.DAYS;

public class Catalogue {

    private static final int daysOverdue = 7;

    private static final File libraryUserFile = new File("LibraryUser.csv");
    private static final File authorFile = new File("Author.csv");
    private static final File loanFile = new File("Loan.csv");
    private static final File bookFile = new File("Book.csv");
    private static final File audioBookFile = new File("AudioBook.csv");
    private static final File thesesFile = new File("Theses.csv");
    private static final File dissertationFile = new File("Dissertation.csv");
    private static final File cdFile = new File("CD.csv");
    private static final File dvdFile = new File("DVD.csv");

    private LinkedList<LibraryUser> libraryUserLinkedList;
    private LinkedList<Author> authorLinkedList;
    private LinkedList<LibraryItem> libraryItemLinkedList;
    private LinkedList<Loan> loanLinkedList;

    public Catalogue() {
        this.libraryUserLinkedList = new LinkedList<>();
        this.authorLinkedList = new LinkedList<>();
        this.libraryItemLinkedList = new LinkedList<>();
        this.loanLinkedList = new LinkedList<>();
    }

    public Catalogue(LinkedList<LibraryUser> libraryUserLinkedList, LinkedList<Author> authorLinkedList, LinkedList<LibraryItem> libraryItemLinkedList, LinkedList<Loan> loanLinkedList) {
        this.libraryUserLinkedList = libraryUserLinkedList;
        this.authorLinkedList = authorLinkedList;
        this.libraryItemLinkedList = libraryItemLinkedList;
        this.loanLinkedList = loanLinkedList;
    }

    //setters and getters
    public LinkedList<LibraryUser> getLibraryUserLinkedList() {
        return libraryUserLinkedList;
    }

    public void setLibraryUserLinkedList(LinkedList<LibraryUser> libraryUserLinkedList) {
        this.libraryUserLinkedList = libraryUserLinkedList;
    }

    public LinkedList<Author> getAuthorLinkedList() {
        return authorLinkedList;
    }

    public void setAuthorLinkedList(LinkedList<Author> authorLinkedList) {
        this.authorLinkedList = authorLinkedList;
    }

    public LinkedList<LibraryItem> getLibraryItemLinkedList() {
        return libraryItemLinkedList;
    }

    public void setLibraryItemLinkedList(LinkedList<LibraryItem> libraryItemLinkedList) {
        this.libraryItemLinkedList = libraryItemLinkedList;
    }

    public LinkedList<Loan> getLoanLinkedList() {
        return loanLinkedList;
    }

    public void setLoanLinkedList(LinkedList<Loan> loanLinkedList) {
        this.loanLinkedList = loanLinkedList;
    }

    //Adding new Authors, LibraryUsers and LibraryItems to the Catalogue

    //If no author exists. Add an author to the catalogue with an ID of 1
    //If there are authors, grab the last Authors ID and add 1 to it and add it to the catalogue.
    public void addNewAuthor(String authorName) {

        try {
            if (this.getAuthorLinkedList().isEmpty()) {

                this.getAuthorLinkedList().add(new Author(1, authorName));
                System.out.println("New Author added to the catalogue: Author Id: 1 Author Name: " + authorName);

            } else {
                int nextAuthorId = this.getAuthorLinkedList().getLast().getAuthorId();

                this.getAuthorLinkedList().add(new Author(nextAuthorId + 1, authorName));
                System.out.println("New Author added to the catalogue: Author Id: " + (nextAuthorId + 1) + " Author Name: " + authorName);

            }
        } catch (AuthorException authorException) {
            System.out.println(authorException.getAuthorExceptionMessage());
        }
    }

    //If no library user exists. Add a new library user to the catalogue with an ID of 1
    //If there are library users, grab the last users ID and add 1 to it and add it to the catalogue.
    public void addNewLibraryUser(String libraryUserName) {
        try {


            if (this.getLibraryUserLinkedList().isEmpty()) {

                this.getLibraryUserLinkedList().add(new LibraryUser(1, libraryUserName));
                System.out.println("New Library User added to the catalogue: Library User Id: 1 Library User Name: " + libraryUserName);


            } else {
                int nextLibraryUserId = this.getLibraryUserLinkedList().getLast().getLibraryUserId();

                this.getLibraryUserLinkedList().add(new LibraryUser(nextLibraryUserId + 1, libraryUserName));
                System.out.println("New Library User added to the catalogue: Library User Id: " + (nextLibraryUserId + 1) + " Library User Name: " + libraryUserName);

            }
        } catch (LibraryUserException libraryUserException) {
            System.out.println(libraryUserException.getLibraryUserExceptionMessage());
        }
    }


    //If no library item exists. Add a new book to the catalogue to the list with an ID of 1
    //If there are library items, grab the last item ID and add 1 to it and add it to the catalogue.
    public void addNewBook(String bookTitle, int bookAuthorId, String bookIsbn) {
        try {
            if (this.getLibraryItemLinkedList().isEmpty()) {

                this.getLibraryItemLinkedList().add(new Book(1, bookTitle, bookAuthorId, true, bookIsbn));
                System.out.println("New Book added to the catalogue: Book Id: 1 Book Title: " + bookTitle);


            } else {
                int nextLibraryItemId = this.getLibraryItemLinkedList().getLast().getLibraryItemId();

                this.getLibraryItemLinkedList().add(new Book(nextLibraryItemId + 1, bookTitle, bookAuthorId, true, bookIsbn));
                System.out.println("New Book added to the catalogue: Book Id: " + (nextLibraryItemId + 1) + " Book Title: " + bookTitle);


            }
        } catch (LibraryItemException libraryItemException) {
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    //If no library item exists. Add a new audiobook to the catalogue to the list with an ID of 1
    //If there are library items, grab the last item ID and add 1 to it and add it to the catalogue.
    public void addNewAudioBook(String audioBookTitle, int audioBookAuthorId, String audioBookIsbn) {
        try {

            if (this.getLibraryItemLinkedList().isEmpty()) {

                this.getLibraryItemLinkedList().add(new AudioBook(1, audioBookTitle, audioBookAuthorId, true, audioBookIsbn));
                System.out.println("New AudioBook added to the catalogue: AudioBook Id: 1 AudioBook Title: " + audioBookTitle);

            } else {
                int nextLibraryItemId = this.getLibraryItemLinkedList().getLast().getLibraryItemId();

                this.getLibraryItemLinkedList().add(new AudioBook(nextLibraryItemId + 1, audioBookTitle, audioBookAuthorId, true, audioBookIsbn));
                System.out.println("New AudioBook added to the catalogue: AudioBook Id: " + (nextLibraryItemId + 1) + " AudioBook Title: " + audioBookTitle);

            }
        } catch (LibraryItemException libraryItemException) {
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    //If no library item exists. Add a new dvd to the catalogue to the list with an ID of 1
    //If there are library items, grab the last item ID and add 1 to it and add it to the catalogue.
    public void addNewDVD(String dvdTitle, int dvdAuthorId, int dvdPlaytime) {
        try {
            if (this.getLibraryItemLinkedList().isEmpty()) {

                this.getLibraryItemLinkedList().add(new DVD(1, dvdTitle, dvdAuthorId, true, dvdPlaytime));
                System.out.println("New DVD added to the catalogue: DVD Id: 1 DVD Title: " + dvdTitle);

            } else {
                int nextLibraryItemId = this.getLibraryItemLinkedList().getLast().getLibraryItemId();

                this.getLibraryItemLinkedList().add(new DVD(nextLibraryItemId + 1, dvdTitle, dvdAuthorId, true, dvdPlaytime));
                System.out.println("New DVD added to the catalogue: DVD Id: " + (nextLibraryItemId + 1) + " DVD Title: " + dvdTitle);

            }
        } catch (LibraryItemException libraryItemException) {
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    //If no library item exists. Add a new cd to the catalogue to the list with an ID of 1
    //If there are library items, grab the last item ID and add 1 to it and add it to the catalogue.
    public void addNewCD(String cdTitle, int cdAuthorId, int cdPlaytime) {
        try {
            if (this.getLibraryItemLinkedList().isEmpty()) {

                this.getLibraryItemLinkedList().add(new CD(1, cdTitle, cdAuthorId, true, cdPlaytime));
                System.out.println("New CD added to the catalogue: CD Id: 1 CD Title: " + cdTitle);


            } else {
                int nextLibraryItemId = this.getLibraryItemLinkedList().getLast().getLibraryItemId();

                this.getLibraryItemLinkedList().add(new CD(nextLibraryItemId + 1, cdTitle, cdAuthorId, true, cdPlaytime));
                System.out.println("New CD added to the catalogue: CD Id: " + (nextLibraryItemId + 1) + " CD Title: " + cdTitle);


            }
        } catch (LibraryItemException libraryItemException) {
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    //If no library item exists. Add a new theses to the catalogue to the list with an ID of 1
    //If there are library items, grab the last item ID and add 1 to it and add it to the catalogue.
    public void addNewTheses(String thesesTitle, int thesesAuthorId, String thesesTopic, String thesesAbstractText, LocalDate thesesDatePublished) {
        try {
            if (this.getLibraryItemLinkedList().isEmpty()) {

                this.getLibraryItemLinkedList().add(new Theses(1, thesesTitle, thesesAuthorId, true, thesesTopic, thesesAbstractText, thesesDatePublished));
                System.out.println("New Theses added to the catalogue: Theses Id: 1 Theses Title: " + thesesTitle);

            } else {
                int nextLibraryItemId = this.getLibraryItemLinkedList().getLast().getLibraryItemId();

                this.getLibraryItemLinkedList().add(new Theses(nextLibraryItemId + 1, thesesTitle, thesesAuthorId, true, thesesTopic, thesesAbstractText, thesesDatePublished));
                System.out.println("New Theses added to the catalogue: Theses Id: " + (nextLibraryItemId + 1) + " Theses Title: " + thesesTitle);


            }
        } catch (LibraryItemException libraryItemException) {
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }

    //If no library item exists. Add a new dissertation to the catalogue to the list with an ID of 1
    //If there are library items, grab the last item ID and add 1 to it and add it to the catalogue.
    public void addNewDissertation(String dissertationTitle, int dissertationAuthorId, String dissertationTopic, String dissertationAbstractText, LocalDate dissertationDatePublished) {

        try {
            if (this.getLibraryItemLinkedList().isEmpty()) {

                this.getLibraryItemLinkedList().add(new Dissertation(1, dissertationTitle, dissertationAuthorId, true, dissertationTopic, dissertationAbstractText, dissertationDatePublished));
                System.out.println("New Dissertation added to the catalogue: Dissertation Id: 1 Dissertation Title: " + dissertationTitle);

            } else {
                int nextLibraryItemId = this.getLibraryItemLinkedList().getLast().getLibraryItemId();

                this.getLibraryItemLinkedList().add(new Dissertation(nextLibraryItemId + 1, dissertationTitle, dissertationAuthorId, true, dissertationTopic, dissertationAbstractText, dissertationDatePublished));
                System.out.println("New Dissertation added to the catalogue: Dissertation Id: " + (nextLibraryItemId + 1) + " Dissertation Title: " + dissertationTitle);

            }
        } catch (LibraryItemException libraryItemException) {
            System.out.println(libraryItemException.getLibraryItemExceptionMessage());
        }
    }


    //Remove Authors, Library Users and Library Items from the catalogue

    //Iterate through the linked list and if the author id exists, remove the author
    public void removeAuthorById(int authorId) {
        if (this.getAuthorLinkedList().isEmpty()) {
            System.out.println("No authors exist.");
        } else {
            for (int i = 0; i < this.getAuthorLinkedList().size(); i++) {
                if (this.getAuthorLinkedList().get(i).getAuthorId() == authorId) {
                    System.out.println("Author Id: " + this.getAuthorLinkedList().get(i).getAuthorId() + " Author Name: " + this.getAuthorLinkedList().get(i).getAuthorName() + " has been deleted.");

                    this.getAuthorLinkedList().remove(i);
                    break; //break to stop iterating through the linked list
                }
            }
        }
    }

    //Iterate through the linked list and if the library user id exists, remove the user
    public void removeLibraryUserById(int libraryUserId) {
        if (this.getLibraryUserLinkedList().isEmpty()) {
            System.out.println("No Library Users exist.");
        } else {
            for (int i = 0; i < this.getLibraryUserLinkedList().size(); i++) {
                if (this.getLibraryUserLinkedList().get(i).getLibraryUserId() == libraryUserId) {
                    System.out.println("Library User Id: " + this.getLibraryUserLinkedList().get(i).getLibraryUserId() + " Library User Name: " + this.getLibraryUserLinkedList().get(i).getLibraryUserName() + " has been deleted.");

                    this.getLibraryUserLinkedList().remove(i);
                    break; //break to stop iterating through the linked list
                }
            }
        }
    }


    //Iterate through the linked list and if the library item id exists, remove the item
    public void removeLibraryItemById(int libraryItemId) {
        if (this.getLibraryItemLinkedList().isEmpty()) {
            System.out.println("No Library Items exist.");
        } else {
            for (int i = 0; i < this.getLibraryItemLinkedList().size(); i++) {
                if (this.getLibraryItemLinkedList().get(i).getLibraryItemId() == libraryItemId) {

                    //Use polymorphism to use the correct type of object that is in the library linked list and print the correct output
                    if (this.getLibraryItemLinkedList().get(i) instanceof Book) {
                        System.out.println("Book Id: " + this.getLibraryItemLinkedList().get(i).getLibraryItemId() + " Book Name: " + this.getLibraryItemLinkedList().get(i).getTitle() + " Book ISBN: " + ((Book) this.getLibraryItemLinkedList().get(i)).getIsbn() + " has been deleted.");

                    } else if (this.getLibraryItemLinkedList().get(i) instanceof AudioBook) {
                        System.out.println("AudioBook Id: " + this.getLibraryItemLinkedList().get(i).getLibraryItemId() + " AudioBook Name: " + this.getLibraryItemLinkedList().get(i).getTitle() + " Book ISBN: " + ((AudioBook) this.getLibraryItemLinkedList().get(i)).getIsbn() + " has been deleted.");

                    } else if (this.getLibraryItemLinkedList().get(i) instanceof DVD) {
                        System.out.println("DVD Id: " + this.getLibraryItemLinkedList().get(i).getLibraryItemId() + "DVD Name: " + this.getLibraryItemLinkedList().get(i).getTitle() + " DVD Playtime: " + ((DVD) this.getLibraryItemLinkedList().get(i)).getPlaytime() + " has been deleted.");

                    } else if (this.getLibraryItemLinkedList().get(i) instanceof CD) {
                        System.out.println("CD Id: " + this.getLibraryItemLinkedList().get(i).getLibraryItemId() + "CD Name: " + this.getLibraryItemLinkedList().get(i).getTitle() + " CD Playtime: " + ((CD) this.getLibraryItemLinkedList().get(i)).getPlaytime() + " has been deleted.");

                    } else if (this.getLibraryItemLinkedList().get(i) instanceof Theses) {
                        System.out.println("Theses Id: " + this.getLibraryItemLinkedList().get(i).getLibraryItemId() + "Theses Name: " + this.getLibraryItemLinkedList().get(i).getTitle() + " Theses Topic: " + ((Theses) this.getLibraryItemLinkedList().get(i)).getTopic() + " Theses Date Published: " + ((Theses) this.getLibraryItemLinkedList().get(i)).getDatePublished() + " has been deleted.");

                    } else if (this.getLibraryItemLinkedList().get(i) instanceof Dissertation) {
                        System.out.println("Dissertation Id: " + this.getLibraryItemLinkedList().get(i).getLibraryItemId() + "Dissertation Name: " + this.getLibraryItemLinkedList().get(i).getTitle() + " Dissertation Topic: " + ((Dissertation) this.getLibraryItemLinkedList().get(i)).getTopic() + " Dissertation Date Published: " + ((Dissertation) this.getLibraryItemLinkedList().get(i)).getDatePublished() + " has been deleted.");
                    }

                    this.getLibraryItemLinkedList().remove(i);
                    break; //break to stop iterating through the linked list
                }
            }
        }
    }

    //Create a new loan with ids
    public void createNewLoanById(int libraryUserId, int libraryItemId) {
        try {

            LibraryUser libraryUser = findLibraryUserById(libraryItemId);
            //Check to see if User exists
            if(findLibraryUserById(libraryItemId) != null){
                if (libraryUser.getLibraryUserId() == libraryUserId) {

                    //Check to see if Library Item exists
                    for (LibraryItem libraryItem : libraryItemLinkedList) {
                        if (libraryItem.getLibraryItemId() == libraryItemId) {
                            //Check to see if the item is available
                            if (libraryItem.getAvailability()) {
                                //Create the loan and add it to the linked list

                                this.getLoanLinkedList().add(new Loan(libraryUserId, libraryItemId, LocalDate.now()));


                                //Add the borrowed item to the library user object
                                libraryUser.addNewBorrowedItem(libraryItem);

                                //Set the availability to false
                                libraryItem.setAvailability(false);


                                //this.getLibraryUserLinkedList().set(this.getLibraryUserLinkedList().indexOf(libraryUser),libraryUser);
                                //this.getLibraryItemLinkedList().set(this.getLibraryItemLinkedList().indexOf(libraryItem),libraryItem);


                                System.out.println("Created a new loan for " + libraryUser.getLibraryUserName() + " with the item " + libraryItem.getTitle());
                            } else {
                                System.out.println("The item: " + libraryItem.getTitle() + " is currently unavailable.");
                            }
                        }
                    }
                }
            }
            else{
                System.out.println("Library user does not exist");
            }
        } catch (LoanException loanException) {
            System.out.println(loanException.getLoanExceptionMessage());
        }
    }

    //Return an item to the library by its ID
    public void returnItemById(int libraryItemId) {

        try {
            //Check to see if the item id exists
            for (LibraryItem libraryItem : this.getLibraryItemLinkedList()) {
                if (libraryItem.getLibraryItemId() == libraryItemId) {

                    //Check to see if Loan exists
                    for (Loan loan : this.getLoanLinkedList()) {
                        if (loan.getLibraryItemId() == libraryItemId) {
                            if(!libraryItem.getAvailability()){

                                for(LibraryUser libraryUser : this.getLibraryUserLinkedList()){
                                    if(loan.getLibraryUserId() == libraryUser.getLibraryUserId()){

                                        libraryUser.returnBorrowedItem(libraryItem);

                                        libraryItem.setAvailability(true);

                                        loan.setDateReturned(LocalDate.now());


                                        this.getLibraryItemLinkedList().set(this.getLibraryItemLinkedList().indexOf(libraryItem),libraryItem);
                                        this.getLibraryUserLinkedList().set(this.getLibraryUserLinkedList().indexOf(libraryUser),libraryUser);

                                        System.out.println("Returned item: " + libraryItem.getTitle() + " for " + libraryUser.getLibraryUserName());


                                    }

                                }


                            }else {
                                System.out.println("The item: " + libraryItem.getLibraryItemId() + ", " + libraryItem.getTitle() + ", is not out on loan.");


                        }
                        }
                    }
                }
            }
        } catch (LoanException e) {
            throw new RuntimeException(e);
        }
    }

    public void listAllLibraryItemsAllDetails() {
        if (!this.getLibraryItemLinkedList().isEmpty()) {
            for (LibraryItem libraryItem : this.getLibraryItemLinkedList()) {
                libraryItem.displayAllDetails();
            }
        } else {
            System.out.println("No items added to the catalogue.");
        }
    }

    public void listAllLibraryItemsSummaryDetails() {
        if (!this.getLibraryItemLinkedList().isEmpty()) {
            for (LibraryItem libraryItem : this.getLibraryItemLinkedList()) {
                libraryItem.displaySummaryDetails();
            }
        } else {
            System.out.println("No items added to the catalogue.");
        }
    }

    public void listAllLibraryUsersAllDetails() {
        if (!this.getLibraryUserLinkedList().isEmpty()) {
            for (LibraryUser libraryUser : this.getLibraryUserLinkedList()) {
                libraryUser.displayAllDetails();
            }
        } else {
            System.out.println("No users have been added to the library.");
        }
    }

    public void listAllLibraryUsersSummaryDetails() {
        if (!this.getLibraryUserLinkedList().isEmpty()) {
            for (LibraryUser libraryUser : this.getLibraryUserLinkedList()) {
                libraryUser.displaySummaryDetails();
            }
        } else {
            System.out.println("No users have been added to the library.");
        }
    }

    public void checkLibraryUserDetailsById(int libraryUserId) {

        if (!this.getLibraryUserLinkedList().isEmpty()) {
            for (LibraryUser libraryUser : this.getLibraryUserLinkedList()) {
                if (libraryUserId == libraryUser.getLibraryUserId()) {
                    libraryUser.displayAllDetails();
                    checkLibraryUserOverdue(libraryUserId);
                }
            }
        } else {
            System.out.println("No users have been added to the library.");
        }
    }

    public void checkLibraryUserOverdue(int libraryUserId) {
        for (LibraryUser libraryUser : this.getLibraryUserLinkedList()) {
            if (libraryUserId == libraryUser.getLibraryUserId()) {

                if (!this.getLoanLinkedList().isEmpty()) {
                    for (Loan loan : this.getLoanLinkedList()) {

                        if (loan.getLibraryUserId() == libraryUserId) {
                            if (DAYS.between(loan.getDateBorrowed(), LocalDate.now()) > daysOverdue) {

                                for (LibraryItem libraryItem : this.getLibraryItemLinkedList()) {
                                    if (libraryItem.getLibraryItemId() == loan.getLibraryItemId()) {
                                        libraryUser.displayAllDetails();
                                        libraryItem.displayAllDetails();
                                        System.out.println("Days overdue: " + DAYS.between(loan.getDateBorrowed(), LocalDate.now()) + "\n");
                                    }
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("No items currently on loan.");
                }
            }
        }
    }


    public void listAllAuthorsAllDetails() {
        if (!this.getAuthorLinkedList().isEmpty()) {
            for (Author author : this.getAuthorLinkedList()) {
                author.displayAllDetails();
            }
        } else {
            System.out.println("No authors have been added to the library.");
        }
    }

    public void listAllAuthorsSummaryDetails() {
        if (!this.getAuthorLinkedList().isEmpty()) {
            for (Author author : this.getAuthorLinkedList()) {
                author.displaySummaryDetails();
            }
        } else {
            System.out.println("No authors have been added to the library.");
        }
    }

    public void listAllItemsByAuthorId() {
        if (!this.getAuthorLinkedList().isEmpty()) {
            for (Author author : this.getAuthorLinkedList()) {
                author.displaySummaryDetails();
            }
        } else {
            System.out.println("No authors have been added to the library.");
        }

    }

    public void listAllItemsByAuthorName() {
        if(!this.getAuthorLinkedList().isEmpty()){
            for(Author author : this.getAuthorLinkedList()){
                author.displaySummaryDetails();
            }
        }else {
        System.out.println("No authors have been added to the library.");
        }
    }

    public void listAvailableItems() {
        if (!this.getLibraryItemLinkedList().isEmpty()) {
            for (LibraryItem libraryItem : this.getLibraryItemLinkedList()) {
                if (libraryItem.getAvailability()) {
                    libraryItem.displayAllDetails();
                }
            }
        } else {
            System.out.println("There are items available in the catalogue.");
        }
    }

    public void listAvailableBooks() {
        if (!this.getLibraryItemLinkedList().isEmpty()) {
            for (LibraryItem libraryItem : this.getLibraryItemLinkedList()) {
                if (libraryItem.getAvailability() && libraryItem instanceof Book) {
                    libraryItem.displayAllDetails();
                }
            }
        } else {
            System.out.println("There are no Books in the catalogue.");
        }
    }

    public void listAvailableAudioBooks() {
        if (!this.getLibraryItemLinkedList().isEmpty()) {
            for (LibraryItem libraryItem : this.getLibraryItemLinkedList()) {
                if (libraryItem.getAvailability() && libraryItem instanceof AudioBook) {
                    libraryItem.displayAllDetails();
                }
            }
        } else {
            System.out.println("There are no AudioBooks in the catalogue.");
        }
    }

    public void listAvailableCDs() {
        if (!this.getLibraryItemLinkedList().isEmpty()) {
            for (LibraryItem libraryItem : this.getLibraryItemLinkedList()) {
                if (libraryItem.getAvailability() && libraryItem instanceof CD) {
                    libraryItem.displayAllDetails();
                }
            }
        } else {
            System.out.println("There are no CDs in the catalogue.");
        }
    }

    public void listAvailableDVDs() {
        if (!this.getLibraryItemLinkedList().isEmpty()) {
            for (LibraryItem libraryItem : this.getLibraryItemLinkedList()) {
                if (libraryItem.getAvailability() && libraryItem instanceof DVD) {
                    libraryItem.displayAllDetails();
                }
            }
        } else {
            System.out.println("There are no DVDs in the catalogue.");
        }
    }

    public void listAvailableTheses() {
        if (!this.getLibraryItemLinkedList().isEmpty()) {
            for (LibraryItem libraryItem : this.getLibraryItemLinkedList()) {
                if (libraryItem.getAvailability() && libraryItem instanceof Theses) {
                    libraryItem.displayAllDetails();
                }
            }
        } else {
            System.out.println("There are no Theses in the catalogue.");
        }
    }

    public void listAvailableDissertations() {
        if (!this.getLibraryItemLinkedList().isEmpty()) {
            for (LibraryItem libraryItem : this.getLibraryItemLinkedList()) {
                if (libraryItem.getAvailability() && libraryItem instanceof Dissertation) {
                    libraryItem.displayAllDetails();
                }
            }
        } else {
            System.out.println("There are no Dissertations in the catalogue.");
        }
    }


    public void listUnavailableItems() {
        if (!this.getLibraryItemLinkedList().isEmpty()) {
            for (LibraryItem libraryItem : this.getLibraryItemLinkedList()) {
                if (!libraryItem.getAvailability()) {
                    libraryItem.displayAllDetails();
                }
            }
        } else {
            System.out.println("There are no items unavailable in the catalogue.");
        }
    }

    public void generateBorrowedItemsReport() {
        if (!this.getLoanLinkedList().isEmpty()) {
            for (Loan loan : this.getLoanLinkedList()) {
                if (loan.getDateReturned() == null) {
                    loan.displayAllDetails();
                }
            }
        } else {
            System.out.println("There are no loans currently in the system.");
        }
    }

    public void generateOverdueItemsReport() {
        if (!this.getLoanLinkedList().isEmpty()) {
            for (Loan loan : this.getLoanLinkedList()) {
                if (DAYS.between(loan.getDateBorrowed(), LocalDate.now()) > daysOverdue) {
                    loan.displayAllDetails();
                }
            }
        } else {
            System.out.println("There are no loans currently in the system.");
        }
    }

    public void generateAllLoansReport() {
        if (!this.getLoanLinkedList().isEmpty()) {
            for (Loan loan : this.getLoanLinkedList()) {
                loan.displayAllDetails();
            }
        } else {
            System.out.println("There are no loans currently in the system.");
        }
    }


    @Override
    public String toString() {
        return "Catalogue{" + "memberLinkedList=" + libraryUserLinkedList + ", authorLinkedList=" + authorLinkedList + ", libraryItemLinkedList=" + libraryItemLinkedList + ", loanLinkedList=" + loanLinkedList + '}';
    }

    public void loadCatalogue() {


        //Loading Library Users
        if (libraryUserFile.isFile()) {
            try (Reader libraryUserReader = Files.newBufferedReader(libraryUserFile.toPath()); CSVParser libraryUserCSVParser = new CSVParser(libraryUserReader, CSVFormat.DEFAULT)) {

                for (CSVRecord libraryUserRecord : libraryUserCSVParser) {

                    int libraryUserId = Integer.parseInt(libraryUserRecord.get(0));
                    String libraryUserName = libraryUserRecord.get(1);


                    LibraryUser loadLibraryUser = new LibraryUser(libraryUserId, libraryUserName);
                    this.libraryUserLinkedList.add(loadLibraryUser);
                }
            } catch (IOException e) {
                System.out.println("Error reading LibraryUser.csv: " + e.getMessage());
            } catch (LibraryUserException libraryUserException) {
                System.out.println(libraryUserException.getLibraryUserExceptionMessage());
            }

        } else {
            System.out.println("LibraryUser.csv file does not exist. Cannot load.");
        }


        //Loading Library Items
        if (bookFile.isFile()) {
            try (Reader bookReader = Files.newBufferedReader(bookFile.toPath()); CSVParser bookCSVParser = new CSVParser(bookReader, CSVFormat.DEFAULT)) {

                for (CSVRecord bookRecord : bookCSVParser) {

                    int libraryItemId = Integer.parseInt(bookRecord.get(0));
                    String bookTitle = bookRecord.get(1);
                    int authorId = Integer.parseInt(bookRecord.get(2));
                    String bookIsbn = bookRecord.get(3);
                    boolean bookAvailability = Boolean.parseBoolean(bookRecord.get(4));


                    Book loadBook = new Book(libraryItemId, bookTitle, authorId, bookAvailability, bookIsbn);
                    this.libraryItemLinkedList.add(loadBook);
                }
            } catch (IOException e) {
                System.out.println("Error reading Book.csv: " + e.getMessage());
            } catch (LibraryItemException libraryItemException) {
                System.out.println(libraryItemException.getLibraryItemExceptionMessage());
            }

        } else {
            System.out.println("Book.csv file does not exist. Cannot load.");
        }

        if (audioBookFile.isFile()) {
            try (Reader audioBookReader = Files.newBufferedReader(audioBookFile.toPath()); CSVParser audioBookCSVParser = new CSVParser(audioBookReader, CSVFormat.DEFAULT)) {

                for (CSVRecord audioBookRecord : audioBookCSVParser) {

                    int libraryItemId = Integer.parseInt(audioBookRecord.get(0));
                    String audioBookTitle = audioBookRecord.get(1);
                    int authorId = Integer.parseInt(audioBookRecord.get(2));
                    String audioBookIsbn = audioBookRecord.get(3);
                    boolean audioBookAvailability = Boolean.parseBoolean(audioBookRecord.get(4));


                    AudioBook loadAudioBook = new AudioBook(libraryItemId, audioBookTitle, authorId, audioBookAvailability, audioBookIsbn);
                    this.libraryItemLinkedList.add(loadAudioBook);
                }
            } catch (IOException e) {
                System.out.println("Error reading AudioBook.csv: " + e.getMessage());
            } catch (LibraryItemException libraryItemException) {
                System.out.println(libraryItemException.getLibraryItemExceptionMessage());
            }
        } else {
            System.out.println("AudioBook.csv file does not exist. Cannot load.");
        }


        if (cdFile.isFile()) {
            try (Reader cdReader = Files.newBufferedReader(cdFile.toPath()); CSVParser cdCSVParser = new CSVParser(cdReader, CSVFormat.DEFAULT)) {

                for (CSVRecord cdRecord : cdCSVParser) {

                    int libraryItemId = Integer.parseInt(cdRecord.get(0));
                    String cdTitle = cdRecord.get(1);
                    int authorId = Integer.parseInt(cdRecord.get(2));
                    int cdPlaytime = Integer.parseInt(cdRecord.get(3));
                    boolean audioBookAvailability = Boolean.parseBoolean(cdRecord.get(4));


                    CD loadCD = new CD(libraryItemId, cdTitle, authorId, audioBookAvailability, cdPlaytime);
                    this.libraryItemLinkedList.add(loadCD);
                }
            } catch (IOException e) {
                System.out.println("Error reading CD.csv: " + e.getMessage());
            } catch (LibraryItemException libraryItemException) {
                System.out.println(libraryItemException.getLibraryItemExceptionMessage());
            }
        } else {
            System.out.println("CD.csv file does not exist. Cannot load.");
        }

        if (dvdFile.isFile()) {
            try (Reader dvdReader = Files.newBufferedReader(dvdFile.toPath()); CSVParser dvdCSVParser = new CSVParser(dvdReader, CSVFormat.DEFAULT)) {
                for (CSVRecord dvdRecord : dvdCSVParser) {

                    int libraryItemId = Integer.parseInt(dvdRecord.get(0));
                    String dvdTitle = dvdRecord.get(1);
                    int authorId = Integer.parseInt(dvdRecord.get(2));
                    int dvdPlaytime = Integer.parseInt(dvdRecord.get(3));
                    boolean dvdAvailability = Boolean.parseBoolean(dvdRecord.get(4));


                    DVD loadDVD = new DVD(libraryItemId, dvdTitle, authorId, dvdAvailability, dvdPlaytime);
                    this.libraryItemLinkedList.add(loadDVD);
                }
            } catch (IOException e) {
                System.out.println("Error reading DVD.csv: " + e.getMessage());
            } catch (LibraryItemException libraryItemException) {
                System.out.println(libraryItemException.getLibraryItemExceptionMessage());
            }
        } else {
            System.out.println("DVD.csv file does not exist. Cannot load.");
        }

        if (thesesFile.isFile()) {
            try (Reader thesesReader = Files.newBufferedReader(thesesFile.toPath()); CSVParser thesesCSVParser = new CSVParser(thesesReader, CSVFormat.DEFAULT)) {

                for (CSVRecord thesesRecord : thesesCSVParser) {

                    int libraryItemId = Integer.parseInt(thesesRecord.get(0));
                    String thesesTitle = thesesRecord.get(1);
                    int authorId = Integer.parseInt(thesesRecord.get(2));
                    String thesesTopic = thesesRecord.get(3);
                    String thesesAbstract = thesesRecord.get(4);
                    LocalDate thesesDatePublished = LocalDate.parse(thesesRecord.get(5));
                    boolean thesesAvailability = Boolean.parseBoolean(thesesRecord.get(4));

                    Theses loadTheses = new Theses(libraryItemId, thesesTitle, authorId, thesesAvailability, thesesTopic, thesesAbstract, thesesDatePublished);
                    this.libraryItemLinkedList.add(loadTheses);
                }
            } catch (IOException e) {
                System.out.println("Error reading Theses.csv: " + e.getMessage());
            } catch (LibraryItemException libraryItemException) {
                System.out.println(libraryItemException.getLibraryItemExceptionMessage());
            }
        } else {
            System.out.println("Theses.csv file does not exist. Cannot load.");
        }

        if (dissertationFile.isFile()) {
            try (Reader dissertationReader = Files.newBufferedReader(dissertationFile.toPath()); CSVParser dissertationCSVParser = new CSVParser(dissertationReader, CSVFormat.DEFAULT)) {

                for (CSVRecord dissertationRecord : dissertationCSVParser) {

                    int libraryItemId = Integer.parseInt(dissertationRecord.get(0));
                    String dissertationTitle = dissertationRecord.get(1);
                    int authorId = Integer.parseInt(dissertationRecord.get(2));
                    String dissertationTopic = dissertationRecord.get(3);
                    String dissertationAbstract = dissertationRecord.get(4);
                    LocalDate dissertationDatePublished = LocalDate.parse(dissertationRecord.get(5));
                    boolean dissertationAvailability = Boolean.parseBoolean(dissertationRecord.get(4));

                    Dissertation loadDissertation = new Dissertation(libraryItemId, dissertationTitle, authorId, dissertationAvailability, dissertationTopic, dissertationAbstract, dissertationDatePublished);
                    this.libraryItemLinkedList.add(loadDissertation);
                }
            } catch (IOException e) {
                System.out.println("Error reading Dissertation.csv: " + e.getMessage());
            } catch (LibraryItemException libraryItemException) {
                System.out.println(libraryItemException.getLibraryItemExceptionMessage());
            }
        } else {
            System.out.println("Dissertation.csv file does not exist. Cannot load.");
        }


        //Loading Authors
        if (authorFile.isFile()) {
            try (Reader authorReader = Files.newBufferedReader(authorFile.toPath()); CSVParser authorCSVParser = new CSVParser(authorReader, CSVFormat.DEFAULT)) {

                for (CSVRecord authorRecord : authorCSVParser) {

                    int authorId = Integer.parseInt(authorRecord.get(0));
                    String authorName = authorRecord.get(1);


                    Author loadAuthor = new Author(authorId, authorName);
                    this.authorLinkedList.add(loadAuthor);
                }
            } catch (IOException e) {
                System.out.println("Error reading Author.csv: " + e.getMessage());
            } catch (AuthorException authorException) {
                System.out.println(authorException.getAuthorExceptionMessage());
            }
        } else {
            System.out.println("Author.csv file does not exist. Cannot load.");
        }


        //Loading Loans
        if (loanFile.isFile()) {
            try (Reader loanReader = Files.newBufferedReader(loanFile.toPath()); CSVParser loanCSVParser = new CSVParser(loanReader, CSVFormat.DEFAULT)) {

                for (CSVRecord loanRecord : loanCSVParser) {

                    int libraryUserId = Integer.parseInt(loanRecord.get(0));
                    int libraryItemId = Integer.parseInt(loanRecord.get(1));
                    LocalDate dateBorrowed = LocalDate.parse(loanRecord.get(2));

                    if (loanRecord.size() > 3) {
                        LocalDate dateReturned = LocalDate.parse(loanRecord.get(3));


                        Loan loadLoan = new Loan(libraryUserId, libraryItemId, dateBorrowed, dateReturned);
                        this.loanLinkedList.add(loadLoan);


                    } else {

                        Loan loadLoan = new Loan(libraryUserId, libraryItemId, dateBorrowed);
                        this.loanLinkedList.add(loadLoan);


                    }
                }
            } catch (IOException e) {
                System.out.println("Problem encountered while loading loans: " + e.getMessage());
            } catch (LoanException loanException) {
                System.out.println(loanException.getLoanExceptionMessage());
            }
        } else {
            System.out.println("Loan.csv file does not exist. Cannot load.");
        }

    }


    public LibraryItem searchByLibraryItemId(int libraryItemId) {
        for (LibraryItem libraryItem : libraryItemLinkedList) {
            if (libraryItem.getLibraryItemId() == libraryItemId) {
                return libraryItem; // Return the matching item
            }
        }
        return null; // Return null if no match is found
    }


    public void saveCatalogue() {


        if (!this.getLibraryUserLinkedList().isEmpty()) {

            try (BufferedWriter libraryUserWriter = Files.newBufferedWriter(libraryUserFile.toPath()); CSVPrinter libraryUserCSVPrinter = new CSVPrinter(libraryUserWriter, CSVFormat.DEFAULT)) {

                for (LibraryUser libraryUser : libraryUserLinkedList) {
                    libraryUserCSVPrinter.printRecord(libraryUser.convertToCommaDelimitedArray());
                }

                libraryUserCSVPrinter.flush();
            } catch (IOException e) {
                System.out.println("Error writing LibraryUser.csv: " + e.getMessage());
            }
        } else {
            System.out.println("No Library Users to save to file");
        }


        if (!this.getLibraryItemLinkedList().isEmpty()) {
            try (BufferedWriter bookWriter = Files.newBufferedWriter(bookFile.toPath()); CSVPrinter bookCSVPrinter = new CSVPrinter(bookWriter, CSVFormat.DEFAULT); BufferedWriter audioBookWriter = Files.newBufferedWriter(audioBookFile.toPath()); CSVPrinter audioBookCSVPrinter = new CSVPrinter(audioBookWriter, CSVFormat.DEFAULT); BufferedWriter cdWriter = Files.newBufferedWriter(cdFile.toPath()); CSVPrinter cdCSVPrinter = new CSVPrinter(cdWriter, CSVFormat.DEFAULT); BufferedWriter dvdWriter = Files.newBufferedWriter(dvdFile.toPath()); CSVPrinter dvdCSVPrinter = new CSVPrinter(dvdWriter, CSVFormat.DEFAULT); BufferedWriter thesesWriter = Files.newBufferedWriter(thesesFile.toPath()); CSVPrinter thesesCSVPrinter = new CSVPrinter(thesesWriter, CSVFormat.DEFAULT); BufferedWriter dissertationWriter = Files.newBufferedWriter(dissertationFile.toPath()); CSVPrinter dissertationCSVPrinter = new CSVPrinter(dissertationWriter, CSVFormat.DEFAULT)) {

                for (LibraryItem libraryItem : libraryItemLinkedList) {
                    if (libraryItem instanceof Book) {
                        bookCSVPrinter.printRecord(libraryItem.convertToCommaDelimitedArray());
                    } else if (libraryItem instanceof AudioBook) {
                        audioBookCSVPrinter.printRecord(libraryItem.convertToCommaDelimitedArray());
                    } else if (libraryItem instanceof CD) {
                        cdCSVPrinter.printRecord(libraryItem.convertToCommaDelimitedArray());
                    } else if (libraryItem instanceof DVD) {
                        dvdCSVPrinter.printRecord(libraryItem.convertToCommaDelimitedArray());
                    } else if (libraryItem instanceof Theses) {
                        thesesCSVPrinter.printRecord(libraryItem.convertToCommaDelimitedArray());
                    } else if (libraryItem instanceof Dissertation) {
                        dissertationCSVPrinter.printRecord(libraryItem.convertToCommaDelimitedArray());
                    }
                }

            } catch (IOException e) {
                System.out.println("Problem encountered while saving Library Items: " + e.getMessage());
            }
        } else {
            System.out.println("No Library Items to print to file.");
        }


        if (!this.getAuthorLinkedList().isEmpty()) {

            try (BufferedWriter authorWriter = Files.newBufferedWriter(authorFile.toPath()); CSVPrinter authorCSVPrinter = new CSVPrinter(authorWriter, CSVFormat.DEFAULT)) {


                for (Author author : authorLinkedList) {
                    authorCSVPrinter.printRecord(author.convertToCommaDelimitedArray());
                }

                //authorCSVPrinter.flush();
            } catch (IOException e) {
                System.out.println("Error writing LibraryUser.csv: " + e.getMessage());
            }
        } else {
            System.out.println("No Authors to save to file.");
        }


        if (!this.getLoanLinkedList().isEmpty()) {
            try (
                    BufferedWriter loanWriter = Files.newBufferedWriter(loanFile.toPath());
                    CSVPrinter loanCSVPrinter = new CSVPrinter(loanWriter, CSVFormat.DEFAULT)) {


                for (Loan loan : loanLinkedList) {
                    loanCSVPrinter.printRecord(loan.convertToCommaDelimitedArray());
                }

                //loanCSVPrinter.flush();
            } catch (IOException e) {
                System.out.println("Error writing Loans.csv: " + e.getMessage());
            }
        } else {
            System.out.println("No Loans to save to file.");
        }
    }

    //Lambda expressions using functional interfaces

    //Find a library user by the id, return null if no user is found.
    private LibraryUserFinder libraryUserFinder = (libraryUserLinkedList, libraryUserId) -> {
        for (LibraryUser libraryUser : libraryUserLinkedList) {
            if (libraryUser.getLibraryUserId() == libraryUserId) {
                return libraryUser;
            }
        }
        return null; // Return null if no match is found
    };

    // Method to use the lambda expression
    public LibraryUser findLibraryUserById(int libraryUserId) {
        return libraryUserFinder.findLibraryUserById(this.getLibraryUserLinkedList(), libraryUserId);
    }






}

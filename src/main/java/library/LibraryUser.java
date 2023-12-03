package library;
// Importing necessary classes and interfaces
import library.abstracts.LibraryItem;
import library.exceptions.LibraryUserException;
import library.interfaces.Printable;
import library.interfaces.Saveable;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * The LibraryUser class implements Printable, Saveable, and Comparable interfaces.
 * It represents a user of the library system.
 */

public class LibraryUser implements Printable, Saveable,Comparable<LibraryUser>{


    // Private fields for LibraryUser class
    private int libraryUserId;
    private String libraryUserName;
    private LinkedList<LibraryItem> borrowedAssets;


    // Getter method for libraryUserId
    public int getLibraryUserId() {
        return libraryUserId;
    }


    // Setter method for libraryUserId with validation
    public void setLibraryUserId(int libraryUserId) throws LibraryUserException {
        if(libraryUserId > 0){
            this.libraryUserId = libraryUserId;
        }
        else {
            throw new LibraryUserException("Error: Library User Id must be greater than 0.");
        }
    }

    public String getLibraryUserName() {
        return libraryUserName;
    }

    public void setLibraryUserName(String libraryUserName) throws LibraryUserException {
        if(libraryUserName.length() > 2){
            this.libraryUserName = libraryUserName;
        }
        else {
            throw new LibraryUserException("Error: Library User name must be greater than two characters.");
        }
    }

    // Getter method for borrowedAssets
    public LinkedList<LibraryItem> getBorrowedAssets() {
        return borrowedAssets;
    }

    // Setter method for borrowedAssets
    public void setBorrowedAssets(LinkedList<LibraryItem> borrowedAssets) {
        this.borrowedAssets = borrowedAssets;
    }


    public LibraryUser() {
    }

    // Parameterized constructor for creating a LibraryUser with libraryUserId and
    public LibraryUser(int libraryUserId, String libraryUserName, LinkedList<LibraryItem> borrowedAssets) throws LibraryUserException {
        this.setLibraryUserId(libraryUserId);
        this.setLibraryUserName(libraryUserName);
        this.setBorrowedAssets(borrowedAssets);
    }

    // Parameterized constructor for creating a LibraryUser with libraryUserId and libraryUserName
    public LibraryUser(int libraryUserId, String libraryUserName) throws LibraryUserException {
        this.setLibraryUserId(libraryUserId);
        this.setLibraryUserName(libraryUserName);
        this.setBorrowedAssets(new LinkedList<>());

    }
    // Method to add a new borrowed item to the user's list of borrowed assets
    public void addNewBorrowedItem(LibraryItem libraryItem){
        this.borrowedAssets.add(libraryItem);
    }

    // Method to return a borrowed item from the user's list of borrowed assets
    public void returnBorrowedItem(LibraryItem libraryItem){
        this.borrowedAssets.remove(libraryItem);
    }

    // Overridden toString method for LibraryUser class
    @Override
    public String toString() {
        return "LibraryUser{" +
                "libraryUserId=" + libraryUserId +
                ", libraryUserName='" + libraryUserName + '\'' +
                ", borrowedAssets=" + borrowedAssets +
                '}';
    }

    // Overridden compareTo method for comparing LibraryUsers by their names
    //Comparing library users names
    @Override
    public int compareTo(LibraryUser libraryUser) {
        return this.getLibraryUserName().compareTo(libraryUser.getLibraryUserName());
    }

    // Overridden displayAllDetails method to display all details of the LibraryUser
    @Override
    public void displayAllDetails() {

        StringBuilder booksOnLoan = new StringBuilder();

        if(!this.getBorrowedAssets().isEmpty()) {
            for (LibraryItem libraryItem:this.getBorrowedAssets()) {
                booksOnLoan.append(libraryItem.getTitle()).append(" | ");
            }
        }
        else{
            booksOnLoan = new StringBuilder("None");
        }
        System.out.println("User ID: "+this.getLibraryUserId()+". User Name: "+this.getLibraryUserName()+". Books on loan: "+booksOnLoan);
    }

    // Overridden displaySummaryDetails method to display summary details of the LibraryUser
    @Override
    public void displaySummaryDetails() {
        System.out.println("User ID: "+this.getLibraryUserId()+". User Name: "+this.getLibraryUserName());
    }

    // Overridden convertToCommaDelimitedArray method to convert LibraryUser details to CSV format
    @Override
    public ArrayList<String> convertToCommaDelimitedArray() {
        ArrayList<String> csvRecord = new ArrayList<>();

        csvRecord.add(String.valueOf(this.getLibraryUserId()));
        csvRecord.add(this.getLibraryUserName());

        if (!this.getBorrowedAssets().isEmpty()){
            for (LibraryItem libraryItem:this.getBorrowedAssets()){
                csvRecord.add(String.valueOf(libraryItem.getLibraryItemId()));
            }
        }

        return csvRecord;
    }
}

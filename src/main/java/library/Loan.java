package library;

// Importing necessary classes and interfaces
import library.exceptions.LoanException;
import library.interfaces.Printable;
import library.interfaces.Saveable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * The Loan class implements Printable, Save able, and Comparable interfaces.
 * It represents a loan record in the library system.
 */

public class Loan implements Printable, Saveable,Comparable<Loan>{

    private int libraryUserId;              // Private fields for Loan class
    private int libraryItemId;
    private LocalDate dateBorrowed;
    private LocalDate dateReturned;

    public int getLibraryUserId() {         // Getter method for libraryUserId
        return libraryUserId;
    }

    public void setLibraryUserId(int libraryUserId) {       // Setter method for libraryUserId
        this.libraryUserId = libraryUserId;
    }

    public int getLibraryItemId() {                         // Getter method for libraryItemId
        return libraryItemId;
    }

    public void setLibraryItemId(int libraryItemId) {       // Setter method for libraryItemId
        this.libraryItemId = libraryItemId;
    }

    public LocalDate getDateBorrowed() {                    // Getter method for dateBorrowed
        return dateBorrowed;
    }

    public void setDateBorrowed(LocalDate dateBorrowed) {   // Setter method for dateBorrowed
        this.dateBorrowed = dateBorrowed;
    }

    public LocalDate getDateReturned() {                    // Getter method for dateReturned
        return dateReturned;
    }


    // Setter method for dateReturned with validation
    public void setDateReturned(LocalDate dateReturned) throws LoanException {
        if(this.getDateBorrowed().isEqual(dateReturned) || this.getDateBorrowed().isBefore(dateReturned)){
            this.dateReturned = dateReturned;
        }
        else{
            throw new LoanException("Returned date cannot be before the date the item was borrowed");
        }
    }

    // Default constructor
    public Loan() {
    }

    // Parameterized constructor for creating a Loan with libraryUserId and libraryItemId
    public Loan(int libraryUserId, int libraryItemId, LocalDate dateBorrowed) throws LoanException {
        this.setLibraryUserId(libraryUserId);
        this.setLibraryItemId(libraryItemId);
        this.setDateBorrowed(dateBorrowed);
    }

    // Parameterized constructor for creating a Loan with all properties
    public Loan(int libraryUserId, int libraryItemId, LocalDate dateBorrowed, LocalDate dateReturned) throws LoanException {
        this.setLibraryUserId(libraryUserId);
        this.setLibraryItemId(libraryItemId);
        this.setDateBorrowed(dateBorrowed);
        this.setDateReturned(dateReturned);
    }


    // Overridden toString method for Loan class
    @Override
    public String toString() {
        return "Loan{" +
                "libraryUserId=" + libraryUserId +
                ", libraryItemId=" + libraryItemId +
                ", dateBorrowed=" + dateBorrowed +
                ", dateReturned=" + dateReturned +
                '}';
    }

    // Overridden compareTo method for comparing
    @Override
    public int compareTo(Loan o) {
        return 0;
    }

    // Overridden displayAllDetails method to display all details of the Loan
    @Override
    public void displayAllDetails() {
        System.out.println("\nLibrary User Id: "+ this.getLibraryUserId());
        System.out.println("Library Item Id: "+ this.getLibraryItemId());
        System.out.println("Date borrowed: "+ this.getDateBorrowed());
        System.out.println("Date returned: "+ this.getDateReturned());
    }

    // Overridden displaySummaryDetails method to display summary details of the Loan
    @Override
    public void displaySummaryDetails() {
        System.out.println("\nLibrary User Id: "+ this.getLibraryUserId());
        System.out.println("Library Item Id: "+ this.getLibraryItemId());
        System.out.println("Date borrowed: "+ this.getDateBorrowed());
        System.out.println("Date returned: "+ this.getDateReturned());
    }

    // Overridden convertToCommaDelimitedArray method to convert Loan details to CSV format
    @Override
    public ArrayList<String> convertToCommaDelimitedArray() {
        ArrayList<String> csvRecord = new ArrayList<>();

        csvRecord.add(String.valueOf(this.getLibraryUserId()));
        csvRecord.add(String.valueOf(this.getLibraryItemId()));
        csvRecord.add(String.valueOf(this.getDateBorrowed()));

        if (this.getDateReturned() != null){
            csvRecord.add(String.valueOf(this.getDateReturned()));
        }

        return csvRecord;
    }
}

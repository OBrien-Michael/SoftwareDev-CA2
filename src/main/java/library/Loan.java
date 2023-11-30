package library;


import java.time.LocalDate;
import java.util.ArrayList;

public class Loan implements Printable,Saveable,Comparable<Loan>{

    private LibraryUser libraryUser;
    private LibraryItem libraryItem;
    private LocalDate dateBorrowed;
    private LocalDate dateReturned;

    public LibraryUser getLibraryUser() {
        return libraryUser;
    }

    public void setLibraryUser(LibraryUser libraryUser) {
        this.libraryUser = libraryUser;
    }

    public LibraryItem getLibraryItem() {
        return libraryItem;
    }

    public void setLibraryItem(LibraryItem libraryItem) {
        this.libraryItem = libraryItem;
    }

    public LocalDate getDateBorrowed() {
        return dateBorrowed;
    }

    public void setDateBorrowed(LocalDate dateBorrowed) {
        this.dateBorrowed = dateBorrowed;
    }

    public LocalDate getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(LocalDate dateReturned) {
        this.dateReturned = dateReturned;
    }

    public Loan() {
    }

    public Loan(LibraryUser libraryUser, library.LibraryItem libraryItem, LocalDate dateBorrowed) {
        this.libraryUser = libraryUser;
        this.libraryItem = libraryItem;
        this.dateBorrowed = dateBorrowed;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "libraryUser=" + libraryUser +
                ", libraryItem=" + libraryItem +
                ", dateBorrowed=" + dateBorrowed +
                ", dateReturned=" + dateReturned +
                '}';
    }


    @Override
    public int compareTo(Loan o) {
        return 0;
    }

    @Override
    public void displayAllDetails() {
        this.getLibraryUser().displayAllDetails();
        this.getLibraryItem().displayAllDetails();
        System.out.println("Date borrowed: "+ this.getDateBorrowed());
    }

    @Override
    public void displaySummaryDetails() {
        this.getLibraryUser().displaySummaryDetails();
        this.getLibraryItem().displaySummaryDetails();
        System.out.println("Date borrowed: "+ this.getDateBorrowed());
    }

    @Override
    public ArrayList<String> convertToCommaDelimitedArray() {
        ArrayList<String> csvRecord = new ArrayList<>();

        csvRecord.add(String.valueOf(this.getLibraryUser().getLibraryUserId()));
        csvRecord.add(String.valueOf(this.getLibraryItem().getLibraryItemId()));
        csvRecord.add(String.valueOf(this.getDateBorrowed()));

        if (this.getDateReturned() != null){
            csvRecord.add(String.valueOf(this.getDateReturned()));
        }

        return csvRecord;
    }
}

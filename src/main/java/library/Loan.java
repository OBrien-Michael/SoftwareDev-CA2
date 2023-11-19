package library;


import java.time.LocalDate;

public class Loan implements Printable,Saveable,Comparable<Loan>{

    private LibraryUser libraryUser;
    private LibraryItem libraryItem;
    private LocalDate dateBorrowed;
    private LocalDate dateReturned;

    public LibraryUser getMember() {
        return libraryUser;
    }

    public void setMember(LibraryUser libraryUser) {
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

    }

    @Override
    public void displaySummaryDetails() {

    }

    @Override
    public boolean saveToCSVFile() {
        return false;
    }
}

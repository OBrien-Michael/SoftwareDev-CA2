package library;


import library.abstracts.LibraryItem;
import library.exceptions.LoanException;
import library.interfaces.Printable;
import library.interfaces.Saveable;

import java.time.LocalDate;
import java.util.ArrayList;

public class Loan implements Printable, Saveable,Comparable<Loan>{

    private int libraryUserId;
    private int libraryItemId;
    private LocalDate dateBorrowed;
    private LocalDate dateReturned;

    public int getLibraryUserId() {
        return libraryUserId;
    }

    public void setLibraryUserId(int libraryUserId) {
        this.libraryUserId = libraryUserId;
    }

    public int getLibraryItemId() {
        return libraryItemId;
    }

    public void setLibraryItemId(int libraryItemId) {
        this.libraryItemId = libraryItemId;
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

    public void setDateReturned(LocalDate dateReturned) throws LoanException {
        if(this.getDateBorrowed().isEqual(dateReturned) || this.getDateBorrowed().isBefore(dateReturned)){
            this.dateReturned = dateReturned;
        }
        else{
            throw new LoanException("Returned date cannot be before the date the item was borrowed");
        }
    }

    public Loan() {
    }

    public Loan(int libraryUserId, int libraryItemId, LocalDate dateBorrowed) throws LoanException {
        this.setLibraryUserId(libraryUserId);
        this.setLibraryItemId(libraryItemId);
        this.setDateBorrowed(dateBorrowed);
    }

    public Loan(int libraryUserId, int libraryItemId, LocalDate dateBorrowed, LocalDate dateReturned) throws LoanException {
        this.setLibraryUserId(libraryUserId);
        this.setLibraryItemId(libraryItemId);
        this.setDateBorrowed(dateBorrowed);
        this.setDateReturned(dateReturned);
    }

    @Override
    public String toString() {
        return "Loan{" +
                "libraryUserId=" + libraryUserId +
                ", libraryItemId=" + libraryItemId +
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
        System.out.println("\nLibrary User Id: "+ this.getLibraryUserId());
        System.out.println("Library Item Id: "+ this.getLibraryItemId());
        System.out.println("Date borrowed: "+ this.getDateBorrowed());
        System.out.println("Date returned: "+ this.getDateReturned());
    }

    @Override
    public void displaySummaryDetails() {
        System.out.println("\nLibrary User Id: "+ this.getLibraryUserId());
        System.out.println("Library Item Id: "+ this.getLibraryItemId());
        System.out.println("Date borrowed: "+ this.getDateBorrowed());
        System.out.println("Date returned: "+ this.getDateReturned());
    }

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

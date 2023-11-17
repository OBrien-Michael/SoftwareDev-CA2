package library;

import java.util.Date;

public class Loan implements Printable,Saveable,Comparable<Loan>{

    private Member member;
    private LibraryItem LibraryItem;
    private Date dateBorrowed;
    private Date dateReturned;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public library.LibraryItem getLibraryItem() {
        return LibraryItem;
    }

    public void setLibraryItem(library.LibraryItem libraryItem) {
        LibraryItem = libraryItem;
    }

    public Date getDateBorrowed() {
        return dateBorrowed;
    }

    public void setDateBorrowed(Date dateBorrowed) {
        this.dateBorrowed = dateBorrowed;
    }

    public Date getDateReturned() {
        return dateReturned;
    }

    public void setDateReturned(Date dateReturned) {
        this.dateReturned = dateReturned;
    }

    public Loan() {
    }

    public Loan(Member member, library.LibraryItem libraryItem, Date dateBorrowed) {
        this.member = member;
        LibraryItem = libraryItem;
        this.dateBorrowed = dateBorrowed;
    }

    public boolean returnItem(){
        return false;
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

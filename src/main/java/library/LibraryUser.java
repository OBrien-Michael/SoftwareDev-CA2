package library;

import java.util.LinkedList;

public class LibraryUser implements Printable,Saveable,Comparable<LibraryUser>{

    private int libraryUserId;
    private String libraryUserName;
    private LinkedList<LibraryItem> borrowedAssets;

    public int getLibraryUserId() {
        return libraryUserId;
    }

    public void setLibraryUserId(int libraryUserId) {
        this.libraryUserId = libraryUserId;
    }

    public String getLibraryUserName() {
        return libraryUserName;
    }

    public void setLibraryUserName(String libraryUserName) {
        this.libraryUserName = libraryUserName;
    }

    public LinkedList<LibraryItem> getBorrowedAssets() {
        return borrowedAssets;
    }

    public void setBorrowedAssets(LinkedList<LibraryItem> borrowedAssets) {
        this.borrowedAssets = borrowedAssets;
    }

    public LibraryUser() {
    }

    public LibraryUser(int libraryUserId, String libraryUserName, LinkedList<LibraryItem> borrowedAssets) {
        this.libraryUserId = libraryUserId;
        this.libraryUserName = libraryUserName;
        this.borrowedAssets = borrowedAssets;
    }

    public LibraryUser(int libraryUserId, String libraryUserName) {
        this.libraryUserId = libraryUserId;
        this.libraryUserName = libraryUserName;
        this.borrowedAssets = new LinkedList<>();
    }

    public void addNewBorrowedItem(LibraryItem libraryItem){
        this.borrowedAssets.add(libraryItem);
    }

    public void returnBorrowedItem(LibraryItem libraryItem){
        this.borrowedAssets.remove(libraryItem);
    }


    @Override
    public String toString() {
        return "LibraryUser{" +
                "libraryUserId=" + libraryUserId +
                ", libraryUserName='" + libraryUserName + '\'' +
                ", borrowedAssets=" + borrowedAssets +
                '}';
    }

    //Comparing library users names
    @Override
    public int compareTo(LibraryUser libraryUser) {
        return this.getLibraryUserName().compareTo(libraryUser.getLibraryUserName());
    }

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

    @Override
    public void displaySummaryDetails() {
        System.out.println("User ID: "+this.getLibraryUserId()+". User Name: "+this.getLibraryUserName());
    }

    @Override
    public boolean saveToCSVFile() {
        return false;
    }
}

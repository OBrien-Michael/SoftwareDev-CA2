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

    @Override
    public int compareTo(LibraryUser o) {
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

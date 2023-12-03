package library;

import library.abstracts.LibraryItem;
import library.exceptions.AuthorException;
import library.exceptions.LibraryUserException;
import library.interfaces.Printable;
import library.interfaces.Saveable;

import java.util.ArrayList;
import java.util.LinkedList;

public class LibraryUser implements Printable, Saveable,Comparable<LibraryUser>{

    private int libraryUserId;
    private String libraryUserName;
    private LinkedList<LibraryItem> borrowedAssets;

    public int getLibraryUserId() {
        return libraryUserId;
    }

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

    public LinkedList<LibraryItem> getBorrowedAssets() {
        return borrowedAssets;
    }

    public void setBorrowedAssets(LinkedList<LibraryItem> borrowedAssets) {
        this.borrowedAssets = borrowedAssets;
    }

    public LibraryUser() {
    }

    public LibraryUser(int libraryUserId, String libraryUserName, LinkedList<LibraryItem> borrowedAssets) throws LibraryUserException {
        this.setLibraryUserId(libraryUserId);
        this.setLibraryUserName(libraryUserName);
        this.setBorrowedAssets(borrowedAssets);
    }

    public LibraryUser(int libraryUserId, String libraryUserName) throws LibraryUserException {
        this.setLibraryUserId(libraryUserId);
        this.setLibraryUserName(libraryUserName);
        this.setBorrowedAssets(new LinkedList<>());
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

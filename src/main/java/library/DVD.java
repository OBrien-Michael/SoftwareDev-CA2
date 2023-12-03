package library;
// Importing necessary classes and abstract classes
import library.abstracts.LibraryItem;
import library.abstracts.MediaItem;
import library.exceptions.LibraryItemException;

import java.util.ArrayList;
   //The DVD class extends MediaItem and represents a DVD in the library system.

public class DVD extends MediaItem {

    public DVD() {
    }
    // Parameterized constructor for creating a DVD with specified details
    public DVD(int libraryItemId, String title, int authorId, boolean availability, int playtime) throws LibraryItemException {
        super(libraryItemId, title, authorId, availability, playtime);
    }

    // Overridden toString method for DVD class
    @Override
    public String toString() {
        return "DVD: " + super.toString()+"\n";
    }

    // Overridden compareTo method for comparing DVDs by title
    @Override
    public int compareTo(LibraryItem libraryItem) {
        return this.getTitle().compareTo(libraryItem.getTitle());
    }

    // Overridden displayAllDetails method to display all details of the DVD
    @Override
    public void displayAllDetails() {
        System.out.println("DVD: Item ID: "+this.getLibraryItemId()+", Title: "+this.getTitle()+" Author ID: "+this.getAuthorId()+", Playtime: "+this.getPlaytime()+", Available: "+this.getAvailability());
    }

    // Overridden displaySummaryDetails method to display summary details of the DVD
    @Override
    public void displaySummaryDetails() {
        System.out.println("DVD: Item ID: "+this.getLibraryItemId()+", Title: "+this.getTitle()+", Available: "+this.getAvailability());
    }

    // Overridden convertToCommaDelimitedArray method to convert DVD details to CSV format
    @Override
    public ArrayList<String> convertToCommaDelimitedArray() {
        ArrayList<String> csvRecord = new ArrayList<>();

        csvRecord.add(String.valueOf(this.getLibraryItemId()));
        csvRecord.add(this.getTitle());
        csvRecord.add(String.valueOf(this.getAuthorId()));
        csvRecord.add(String.valueOf(this.getPlaytime()));
        csvRecord.add(String.valueOf(this.getAvailability()));


        return csvRecord;
    }
}

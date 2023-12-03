package library;

// Importing necessary classes and abstract classes
import library.abstracts.LibraryItem;
import library.abstracts.MediaItem;
import library.exceptions.LibraryItemException;

import java.util.ArrayList;
// CD class extends MediaItem, inheriting its properties and methods
public class CD extends MediaItem {

    public CD() {
    }
    //constructor that initializes a CD object using the superclass constructor
    public CD(int libraryItemId, String title, int authorId, boolean availability, int playtime) throws LibraryItemException {
        super(libraryItemId, title, authorId, availability, playtime);
    }
    // Overridden toString method that returns a string representation of the CD object
    @Override
    public String toString() {
        return "CD: " + super.toString()+"\n";
    }

    // Overridden compareTo method that compares CDs based on their titles
    @Override
    public int compareTo(LibraryItem libraryItem) {
        return Integer.compare(this.getLibraryItemId(), libraryItem.getLibraryItemId());
    }

    // Overridden displayAllDetails method that prints all details of the CD
    @Override
    public void displayAllDetails() {
        System.out.println("CD: Item ID: "+this.getLibraryItemId()+", Title: "+this.getTitle()+" Author ID: "+this.getAuthorId()+", Playtime: "+this.getPlaytime()+", Available: "+this.getAvailability());
    }
    // Overridden displaySummaryDetails method that prints a summary of the CD's details
    @Override
    public void displaySummaryDetails() {
        System.out.println("CD: Item ID: "+this.getLibraryItemId()+", Title: "+this.getTitle()+", Available: "+this.getAvailability());
    }
    // Overridden convertToCommaDelimitedArray method that converts CD details to a CSV format
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

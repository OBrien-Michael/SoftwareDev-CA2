package library;

import library.abstracts.LibraryItem;
import library.abstracts.MediaItem;
import library.exceptions.LibraryItemException;

import java.util.ArrayList;

public class CD extends MediaItem {

    public CD() {
    }

    public CD(int libraryItemId, String title, int authorId, boolean availability, int playtime) throws LibraryItemException {
        super(libraryItemId, title, authorId, availability, playtime);
    }

    @Override
    public String toString() {
        return "CD: " + super.toString()+"\n";
    }

    @Override
    public int compareTo(LibraryItem libraryItem) {
        return this.getTitle().compareTo(libraryItem.getTitle());
    }

    @Override
    public void displayAllDetails() {
        System.out.println("CD: Item ID: "+this.getLibraryItemId()+", Title: "+this.getTitle()+" Author ID: "+this.getAuthorId()+", Playtime: "+this.getPlaytime()+", Available: "+this.getAvailability());
    }

    @Override
    public void displaySummaryDetails() {
        System.out.println("CD: Item ID: "+this.getLibraryItemId()+", Title: "+this.getTitle()+", Available: "+this.getAvailability());
    }

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

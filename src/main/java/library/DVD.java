package library;

import library.abstracts.LibraryItem;
import library.abstracts.MediaItem;

import java.util.ArrayList;

public class DVD extends MediaItem {

    public DVD() {
    }

    public DVD(int libraryItemId, String title, int authorId, boolean availability, int playtime) {
        super(libraryItemId, title, authorId, availability, playtime);
    }

    @Override
    public String toString() {
        return "DVD: " + super.toString()+"\n";
    }

    @Override
    public int compareTo(LibraryItem libraryItem) {
        return this.getTitle().compareTo(libraryItem.getTitle());
    }

    @Override
    public void displayAllDetails() {
        System.out.println("DVD: Item ID: "+this.getLibraryItemId()+", Title: "+this.getTitle()+" Author ID: "+this.getAuthorId()+", Playtime: "+this.getPlaytime()+", Available: "+this.getAvailability());
    }

    @Override
    public void displaySummaryDetails() {
        System.out.println("DVD: Item ID: "+this.getLibraryItemId()+", Title: "+this.getTitle()+", Available: "+this.getAvailability());
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

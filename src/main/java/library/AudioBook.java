package library;

import library.abstracts.LibraryItem;
import library.abstracts.LiteratureItem;
import library.exceptions.LibraryItemException;

import java.util.ArrayList;

public class AudioBook extends LiteratureItem {

    public AudioBook() {
    }

    public AudioBook(int libraryItemId, String title, int authorId, boolean availability, String isbn) throws LibraryItemException {
        super(libraryItemId, title, authorId, availability, isbn);
    }

    @Override
    public String toString() {
        return "AudioBook: " + super.toString()+"\n";
    }

    //Comparing by audiobook name
    @Override
    public int compareTo(LibraryItem libraryItem) {
        return this.getTitle().compareTo(libraryItem.getTitle());
    }

    @Override
    public void displayAllDetails() {
        System.out.println("Audiobook: Item ID: "+this.getLibraryItemId()+", Title: "+this.getTitle()+" Author ID: "+this.getAuthorId()+", ISBN: "+this.getIsbn()+", Available: "+this.getAvailability());
    }

    @Override
    public void displaySummaryDetails() {
        System.out.println("Audiobook: Item ID: "+this.getLibraryItemId()+", Title: "+this.getTitle()+", Available: "+this.getAvailability());
    }

    @Override
    public ArrayList<String> convertToCommaDelimitedArray() {
        ArrayList<String> csvRecord = new ArrayList<>();

        csvRecord.add(String.valueOf(this.getLibraryItemId()));
        csvRecord.add(this.getTitle());
        csvRecord.add(String.valueOf(this.getAuthorId()));
        csvRecord.add(this.getIsbn());
        csvRecord.add(String.valueOf(this.getAvailability()));


        return csvRecord;
    }
}

package library;

import library.abstracts.LibraryItem;
import library.abstracts.ResearchItem;
import library.exceptions.LibraryItemException;

import java.time.LocalDate;
import java.util.ArrayList;

public class Theses extends ResearchItem {

    public Theses() {
    }

    public Theses(int libraryItemId, String title, int authorId, boolean availability, String topic, String abstractText, LocalDate datePublished) throws LibraryItemException {
        super(libraryItemId, title, authorId, availability, topic, abstractText, datePublished);
    }

    @Override
    public String toString() {
        return "Theses: "+ super.toString()+"\n";
    }

    @Override
    public int compareTo(LibraryItem libraryItem) {
        return this.getTitle().compareTo(libraryItem.getTitle());
    }

    @Override
    public void displayAllDetails() {
        System.out.println("Theses: Item ID: "+this.getLibraryItemId()+", Title: "+this.getTitle()+" Author ID: "+this.getAuthorId()+", " +
                "Available: "+this.getAvailability()+", Topic: "+this.getTopic()+", Abstract: "+this.getAbstractText()+", Date Published: "+this.getDatePublished());
    }

    @Override
    public void displaySummaryDetails() {
        System.out.println("Theses: Item ID: "+this.getLibraryItemId()+", Title: "+this.getTitle()+", Available: "+this.getAvailability());
    }

    @Override
    public ArrayList<String> convertToCommaDelimitedArray() {
        ArrayList<String> csvRecord = new ArrayList<>();

        csvRecord.add(String.valueOf(this.getLibraryItemId()));
        csvRecord.add(this.getTitle());
        csvRecord.add(String.valueOf(this.getAuthorId()));
        csvRecord.add(this.getTopic());
        csvRecord.add(this.getAbstractText());
        csvRecord.add(String.valueOf(this.getDatePublished()));
        csvRecord.add(String.valueOf(this.getAvailability()));

        return csvRecord;
    }
}

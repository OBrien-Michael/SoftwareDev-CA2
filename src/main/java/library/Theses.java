package library;

import java.time.LocalDate;
import java.util.Date;

public class Theses extends ResearchItem{

    public Theses() {
    }

    public Theses(int libraryItemId, String title, int authorId, boolean availability, String topic, String abstractText, LocalDate datePublished) {
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
    public boolean saveToCSVFile() {
        return false;
    }
}

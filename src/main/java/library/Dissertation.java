package library;

import java.time.LocalDate;

public class Dissertation extends ResearchItem{

    public Dissertation() {
    }

    public Dissertation(int libraryItemId, String title, int authorId, boolean availability, String topic, String abstractText, LocalDate datePublished) {
        super(libraryItemId, title, authorId, availability, topic, abstractText, datePublished);
    }

    @Override
    public String toString() {
        return "Dissertation: " + super.toString()+"\n";
    }

    @Override
    public int compareTo(LibraryItem libraryItem) {
        return this.getTitle().compareTo(libraryItem.getTitle());
    }

    @Override
    public void displayAllDetails() {
        System.out.println("Dissertation: Item ID: "+this.getLibraryItemId()+", Title: "+this.getTitle()+" Author ID: "+this.getAuthorId()+", " +
                "Available: "+this.getAvailability()+", Topic: "+this.getTopic()+", Abstract: "+this.getAbstractText()+", Date Published: "+this.getDatePublished());
    }

    @Override
    public void displaySummaryDetails() {
        System.out.println("Dissertation: Item ID: "+this.getLibraryItemId()+", Title: "+this.getTitle()+", Available: "+this.getAvailability());
    }

    @Override
    public boolean saveToCSVFile() {
        return false;
    }
}

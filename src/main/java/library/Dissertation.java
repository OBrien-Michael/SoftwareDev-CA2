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
    public int compareTo(LibraryItem o) {
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

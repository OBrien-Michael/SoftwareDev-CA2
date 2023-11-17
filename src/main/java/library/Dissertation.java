package library;

import java.util.Date;

public class Dissertation extends ResearchItem{

    public Dissertation() {
    }

    public Dissertation(String title, Author author, boolean availability, String topic, String abstractText, Date datePublished) {
        super(title, author, availability, topic, abstractText, datePublished);
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

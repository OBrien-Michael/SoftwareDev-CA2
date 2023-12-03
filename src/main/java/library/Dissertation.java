package library;
// Importing necessary classes and packages
import library.abstracts.LibraryItem;
import library.abstracts.ResearchItem;
import library.exceptions.LibraryItemException;
import java.time.LocalDate;
import java.util.ArrayList;

// Dissertation class extends ResearchItem to represent dissertations in the library system
public class Dissertation extends ResearchItem {

    public Dissertation() {
    }
    // Parameterized constructor for creating a Dissertation with all properties
    public Dissertation(int libraryItemId, String title, int authorId, boolean availability, String topic, String abstractText, LocalDate datePublished) throws LibraryItemException {
        super(libraryItemId, title, authorId, availability, topic, abstractText, datePublished);
    }

    // Returns a string representation of the Dissertation
    @Override
    public String toString() {
        return "Dissertation: " + super.toString()+"\n";
    }

    // Compares this Dissertation to another LibraryItem by title
    @Override
    public int compareTo(LibraryItem libraryItem) {
        return this.getTitle().compareTo(libraryItem.getTitle());
    }

    // Prints all details of the Dissertation
    @Override
    public void displayAllDetails() {
        System.out.println("Dissertation: Item ID: "+this.getLibraryItemId()+", Title: "+this.getTitle()+" Author ID: "+this.getAuthorId()+", " +
                "Available: "+this.getAvailability()+", Topic: "+this.getTopic()+", Abstract: "+this.getAbstractText()+", Date Published: "+this.getDatePublished());
    }
    // Prints a summary of the Dissertation's details
    @Override
    public void displaySummaryDetails() {
        System.out.println("Dissertation: Item ID: "+this.getLibraryItemId()+", Title: "+this.getTitle()+", Available: "+this.getAvailability());
    }


    // Converts the Dissertation's details into a comma-delimited array for CSV format
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

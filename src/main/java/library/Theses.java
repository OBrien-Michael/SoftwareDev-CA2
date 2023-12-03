package library;
// Importing necessary classes and abstract classes
import library.abstracts.LibraryItem;
import library.abstracts.ResearchItem;
import library.exceptions.LibraryItemException;
import java.time.LocalDate;
import java.util.ArrayList;


/**
 * The These class extends ResearchItem to represent a thesis in the library system.
 */
public class Theses extends ResearchItem {



    // Parameterized constructor for creating a Theses with specified details
    public Theses(int libraryItemId, String title, int authorId, boolean availability, String topic, String abstractText, LocalDate datePublished) throws LibraryItemException {
        super(libraryItemId, title, authorId, availability, topic, abstractText, datePublished);
    }

    // Overridden toString method for These class
    @Override
    public String toString() {
        return "Theses: "+ super.toString()+"\n";
    }

    // Overridden compareTo method for comparing Theses by title
    @Override
    public int compareTo(LibraryItem libraryItem) {
        return this.getTitle().compareTo(libraryItem.getTitle());
    }

    // Overridden displayAllDetails method to display all details of the Theses
    @Override
    public void displayAllDetails() {
        System.out.println("Theses: Item ID: "+this.getLibraryItemId()+", Title: "+this.getTitle()+" Author ID: "+this.getAuthorId()+", " +
                "Available: "+this.getAvailability()+", Topic: "+this.getTopic()+", Abstract: "+this.getAbstractText()+", Date Published: "+this.getDatePublished());
    }

    // Overridden displaySummaryDetails method to display summary details of the Theses
    @Override
    public void displaySummaryDetails() {
        System.out.println("Theses: Item ID: "+this.getLibraryItemId()+", Title: "+this.getTitle()+", Available: "+this.getAvailability());
    }

    // Overridden convertToCommaDelimitedArray method to convert Theses details to CSV format
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

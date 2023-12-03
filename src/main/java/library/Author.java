package library;
// Importing necessary classes and interfaces
import library.abstracts.LibraryItem;
import library.exceptions.AuthorException;
import library.interfaces.Printable;
import library.interfaces.Saveable;
import java.util.ArrayList;
import java.util.LinkedList;


// Author class implementing Printable, Saveable, and Comparable interfaces
public class Author implements Printable, Saveable,Comparable<Author>{

    // Private fields for Author class
    private int authorId;
    private String authorName;
    private LinkedList<LibraryItem> authoredItems;

    public int getAuthorId() {
        return authorId;
    }

    // Setter method for authorId with validation
    public void setAuthorId(int authorId) throws AuthorException {
        if(authorId > 0){
            this.authorId = authorId;
        }
        else {
            throw new AuthorException("Error: Author Id must be greater than 0.");
        }
    }

    // Getter method for authorName
    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) throws AuthorException {
        if(authorName.length() > 2){
            this.authorName = authorName;

            // Setter method for authorName with validation

        }
        else {
            throw new AuthorException("Error: Author name must be greater than two characters.");
        }
    }
    // Getter method for authoredItems
    public LinkedList<LibraryItem> getAuthoredItems() {
        return authoredItems;
    }

    // Setter method for authoredItems
    public void setAuthoredItems(LinkedList<LibraryItem> authoredBooks) {
        this.authoredItems = authoredBooks;
    }

    public Author() {
    }
    // Parameterized constructor with all fields
    public Author(int authorId, String authorName, LinkedList<LibraryItem> authoredItems) throws AuthorException {
        this.setAuthorId(authorId);
        this.setAuthorName(authorName);
        this.setAuthoredItems(authoredItems);
    }

    // Parameterized constructor with authorId and authorName
    public Author(int authorId, String authorName) throws AuthorException {
        this.setAuthorId(authorId);
        this.setAuthorName(authorName);
        this.setAuthoredItems(new LinkedList<>());
    }

    // Overridden toString method for Author class
    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", authoredItems=" + authoredItems +
                '}';
    }

    // Overridden compareTo method for comparing authors by name
    @Override
    public int compareTo(Author author) {
        return this.getAuthorName().compareTo(author.getAuthorName());
    }

    // Overridden displayAllDetails method from Printable interface
    @Override
    public void displayAllDetails() {

        StringBuilder authoredItems = new StringBuilder();

        if(!this.getAuthoredItems().isEmpty()) {
            for (LibraryItem libraryItem:this.getAuthoredItems()) {
                authoredItems.append(libraryItem.getTitle()).append(" | ");
            }
        }
        else{
            authoredItems = new StringBuilder("No books authored.");
        }
        System.out.println("Author ID: "+this.getAuthorId()+". Author Name: "+this.getAuthorName()+". Authored: "+authoredItems);

    }
    // Overridden displaySummaryDetails method from Printable interface
    @Override
    public void displaySummaryDetails() {
        System.out.println("Author ID: "+this.getAuthorId()+". Author Name: "+this.getAuthorName());
    }
    // Overridden convertToCommaDelimitedArray method from interface
    @Override
    public ArrayList<String> convertToCommaDelimitedArray() {
        ArrayList<String> csvRecord = new ArrayList<>();

        csvRecord.add(String.valueOf(this.getAuthorId()));
        csvRecord.add(this.getAuthorName());

        if (!this.getAuthoredItems().isEmpty()){
            for (LibraryItem libraryItem:this.getAuthoredItems()){
                csvRecord.add(String.valueOf(libraryItem.getLibraryItemId()));
            }
        }


        return csvRecord;
    }
}

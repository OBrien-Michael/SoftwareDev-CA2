package library.abstracts;
// Importing necessary exceptions and interfaces
import library.exceptions.LibraryItemException;
import library.interfaces.Printable;
import library.interfaces.Saveable;

// Abstract class LibraryItem implementing Printable, Save able, and Comparable interfaces
public abstract class LibraryItem implements Printable, Saveable,Comparable<LibraryItem>{

    // Private fields for LibraryItem class
    private int libraryItemId;              // Getter method for libraryItemId
    private String title;                   // Setter method for libraryItemId
    private int authorId;                   // Getter method for title
    private boolean availability;           // Setter method for title with validation

    public int getLibraryItemId() {
        return libraryItemId;
    }

    public void setLibraryItemId(int libraryItemId) {
        this.libraryItemId = libraryItemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws LibraryItemException {
        if(!title.isEmpty()){
            this.title = title;
        }
        else {
            throw new LibraryItemException("Error: Item name must must be greater than 0 characters");
        }
    }

    // Getter method for authorId
    public int getAuthorId() {
        return authorId;
    }

    // Setter method for authorId with validation
    public void setAuthorId(int authorId) throws LibraryItemException {
        if(authorId > 0){
            this.authorId = authorId;
        }
        else {
            throw new LibraryItemException("Error: Author Id must be greater than 0.");
        }
    }

    // Getter method for availability
    public boolean getAvailability() {
        return availability;
    }

    // Setter method for availability
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    // Default constructor
    public LibraryItem() {
    }

    // Parameterized constructor with all fields
    public LibraryItem(int libraryItemId, String title, int authorId, boolean availability) throws LibraryItemException {
        this.setLibraryItemId(libraryItemId);
        this.setTitle(title);
        this.setAuthorId(authorId);
        this.setAvailability(availability);
    }


    // Overridden toString method for LibraryItem class
    @Override
    public String toString() {
        return "Library Item ID = "+libraryItemId+", Title=" + title + ", authorId=" + authorId + ", availability=" + availability+" ";
    }

    @Override
    public int compareTo(LibraryItem o) {
        return Integer.compare(this.getLibraryItemId(), o.getLibraryItemId());
    }
}

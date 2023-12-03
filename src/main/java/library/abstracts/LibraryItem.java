package library.abstracts;

import library.exceptions.LibraryItemException;
import library.interfaces.Printable;
import library.interfaces.Saveable;

public abstract class LibraryItem implements Printable, Saveable,Comparable<LibraryItem>{

    private int libraryItemId;
    private String title;
    private int authorId;
    private boolean availability;

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

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) throws LibraryItemException {
        if(authorId > 0){
            this.authorId = authorId;
        }
        else {
            throw new LibraryItemException("Error: Author Id must be greater than 0.");
        }
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public LibraryItem() {
    }

    public LibraryItem(int libraryItemId, String title, int authorId, boolean availability) throws LibraryItemException {
        this.setLibraryItemId(libraryItemId);
        this.setTitle(title);
        this.setAuthorId(authorId);
        this.setAvailability(availability);
    }

    @Override
    public String toString() {
        return "Library Item ID = "+libraryItemId+", Title=" + title + ", authorId=" + authorId + ", availability=" + availability+" ";
    }


}

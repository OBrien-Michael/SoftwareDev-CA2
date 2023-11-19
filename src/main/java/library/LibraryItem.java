package library;

public abstract class LibraryItem implements Printable,Saveable,Comparable<LibraryItem>{

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

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public LibraryItem() {
    }

    public LibraryItem(int libraryItemId, String title, int authorId, boolean availability) {
        this.libraryItemId = libraryItemId;
        this.title = title;
        this.authorId = authorId;
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Title=" + title + ", authorId=" + authorId + ", availability=" + availability+" ";
    }


}

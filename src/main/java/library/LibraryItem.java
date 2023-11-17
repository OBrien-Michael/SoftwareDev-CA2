package library;

public abstract class LibraryItem implements Printable,Saveable,Comparable<LibraryItem>{

    private String title;
    private Author author;
    private boolean availability;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public LibraryItem() {
    }

    public LibraryItem(String title, Author author, boolean availability) {
        this.title = title;
        this.author = author;
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "LibraryItem{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", availability=" + availability +
                '}';
    }


}

package library;

public class Book extends LiteratureItem{

    public Book() {
    }

    public Book(int libraryItemId, String title, int authorId, boolean availability, String isbn) {
        super(libraryItemId, title, authorId, availability, isbn);
    }

    @Override
    public String toString() {
        return "Book: " + super.toString()+"\n";
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

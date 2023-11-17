package library;

public class AudioBook extends LiteratureItem{

    public AudioBook() {
    }

    public AudioBook(String title, Author author, boolean availability, String isbn) {
        super(title, author, availability, isbn);
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

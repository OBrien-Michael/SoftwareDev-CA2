package library;

public class AudioBook extends LiteratureItem{

    public AudioBook() {
    }

    public AudioBook(int libraryItemId, String title, int authorId, boolean availability, String isbn) {
        super(libraryItemId, title, authorId, availability, isbn);
    }

    @Override
    public String toString() {
        return "AudioBook: " + super.toString()+"\n";
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

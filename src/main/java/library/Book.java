package library;

public class Book extends LiteratureItem{

    public Book() {
    }

    public Book(String title, Author author, boolean availability, String isbn) {
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

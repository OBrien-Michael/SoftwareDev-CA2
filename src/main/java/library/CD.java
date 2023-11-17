package library;

public class CD extends MediaItem {

    public CD() {
    }

    public CD(String title, Author author, boolean availability, int playtime) {
        super(title, author, availability, playtime);
    }

    @Override
    public String toString() {
        return "CD{} " + super.toString();
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

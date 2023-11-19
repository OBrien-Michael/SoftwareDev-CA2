package library;

public class CD extends MediaItem {

    public CD() {
    }

    public CD(int libraryItemId, String title, int authorId, boolean availability, int playtime) {
        super(libraryItemId, title, authorId, availability, playtime);
    }

    @Override
    public String toString() {
        return "CD: " + super.toString()+"\n";
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
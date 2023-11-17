package library;

public class DVD extends MediaItem{

    public DVD() {
    }

    public DVD(String title, Author author, boolean availability, int playtime) {
        super(title, author, availability, playtime);
    }

    @Override
    public String toString() {
        return "DVD{} " + super.toString();
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

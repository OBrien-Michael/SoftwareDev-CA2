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

    //Comparing by audiobook name
    @Override
    public int compareTo(LibraryItem libraryItem) {
        return this.getTitle().compareTo(libraryItem.getTitle());
    }

    @Override
    public void displayAllDetails() {
        System.out.println("Audiobook: Item ID: "+this.getLibraryItemId()+", Title: "+this.getTitle()+" Author ID: "+this.getAuthorId()+", ISBN: "+this.getIsbn()+", Available: "+this.getAvailability());
    }

    @Override
    public void displaySummaryDetails() {
        System.out.println("Audiobook: Item ID: "+this.getLibraryItemId()+", Title: "+this.getTitle()+", Available: "+this.getAvailability());
    }

    @Override
    public boolean saveToCSVFile() {
        return false;
    }
}

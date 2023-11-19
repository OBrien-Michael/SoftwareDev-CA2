package library;

public abstract class LiteratureItem extends LibraryItem{

    private String isbn;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LiteratureItem() {
    }

    public LiteratureItem(int libraryItemId, String title, int authorId, boolean availability, String isbn) {
        super(libraryItemId, title, authorId, availability);
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return super.toString()+"isbn=" + isbn;
    }


}

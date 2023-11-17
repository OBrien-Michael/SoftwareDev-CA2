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

    public LiteratureItem(String title, Author author, boolean availability, String isbn) {
        super(title, author, availability);
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "LiteratureItem{" +
                "isbn='" + isbn + '\'' +
                "} " + super.toString();
    }


}

package library;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed;
    private int borrowedBy;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false;
        
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }

    public void setBorrowedBy(int memberId) {
        this.borrowedBy = memberId;
    }

    public int getBorrowedBy() {
        return borrowedBy;
    }

    @Override
    public String toString() {
        return "Book{" +
               "title='" + title + '\'' +
               ", author='" + author + '\'' +
               ", isbn='" + isbn + '\'' +
               ", isBorrowed=" + isBorrowed +
               '}';
    }
}

package library;

import java.util.LinkedList;

public class Author implements Printable,Saveable,Comparable<Author>{

    private int authorId;
    private String authorName;
    private LinkedList<LibraryItem> authoredBooks;

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public LinkedList<LibraryItem> getAuthoredBooks() {
        return authoredBooks;
    }

    public void setAuthoredBooks(LinkedList<LibraryItem> authoredBooks) {
        this.authoredBooks = authoredBooks;
    }

    public Author() {
    }

    public Author(int authorId, String authorName, LinkedList<LibraryItem> authoredBooks) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.authoredBooks = authoredBooks;
    }

    public Author(int authorId, String authorName) {
        this.authorId = authorId;
        this.authorName = authorName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", authoredBooks=" + authoredBooks +
                '}';
    }


    @Override
    public int compareTo(Author o) {
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

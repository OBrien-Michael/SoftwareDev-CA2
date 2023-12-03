package library;

import library.abstracts.LibraryItem;
import library.exceptions.AuthorException;
import library.exceptions.LibraryItemException;
import library.interfaces.Printable;
import library.interfaces.Saveable;

import java.util.ArrayList;
import java.util.LinkedList;

public class Author implements Printable, Saveable,Comparable<Author>{

    private int authorId;
    private String authorName;
    private LinkedList<LibraryItem> authoredItems;

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) throws AuthorException {
        if(authorId > 0){
            this.authorId = authorId;
        }
        else {
            throw new AuthorException("Error: Author Id must be greater than 0.");
        }
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) throws AuthorException {
        if(authorName.length() > 2){
            this.authorName = authorName;
        }
        else {
            throw new AuthorException("Error: Author name must be greater than two characters.");
        }
    }

    public LinkedList<LibraryItem> getAuthoredItems() {
        return authoredItems;
    }

    public void setAuthoredItems(LinkedList<LibraryItem> authoredBooks) {
        this.authoredItems = authoredBooks;
    }

    public Author() {
    }

    public Author(int authorId, String authorName, LinkedList<LibraryItem> authoredItems) throws AuthorException {
        this.setAuthorId(authorId);
        this.setAuthorName(authorName);
        this.setAuthoredItems(authoredItems);
    }

    public Author(int authorId, String authorName) throws AuthorException {
        this.setAuthorId(authorId);
        this.setAuthorName(authorName);
        this.setAuthoredItems(new LinkedList<>());
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", authoredItems=" + authoredItems +
                '}';
    }


    @Override
    public int compareTo(Author author) {
        return this.getAuthorName().compareTo(author.getAuthorName());
    }

    @Override
    public void displayAllDetails() {

        StringBuilder authoredItems = new StringBuilder();

        if(!this.getAuthoredItems().isEmpty()) {
            for (LibraryItem libraryItem:this.getAuthoredItems()) {
                authoredItems.append(libraryItem.getTitle()).append(" | ");
            }
        }
        else{
            authoredItems = new StringBuilder("No books authored.");
        }
        System.out.println("Author ID: "+this.getAuthorId()+". Author Name: "+this.getAuthorName()+". Authored: "+authoredItems);

    }

    @Override
    public void displaySummaryDetails() {
        System.out.println("Author ID: "+this.getAuthorId()+". Author Name: "+this.getAuthorName());
    }

    @Override
    public ArrayList<String> convertToCommaDelimitedArray() {
        ArrayList<String> csvRecord = new ArrayList<>();

        csvRecord.add(String.valueOf(this.getAuthorId()));
        csvRecord.add(this.getAuthorName());

        if (!this.getAuthoredItems().isEmpty()){
            for (LibraryItem libraryItem:this.getAuthoredItems()){
                csvRecord.add(String.valueOf(libraryItem.getLibraryItemId()));
            }
        }


        return csvRecord;
    }
}

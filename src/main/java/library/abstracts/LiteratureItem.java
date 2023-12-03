package library.abstracts;

import library.exceptions.LibraryItemException;

public abstract class LiteratureItem extends LibraryItem{

    private String isbn;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) throws LibraryItemException {
        if(isbn.length() == 13){
            this.isbn = isbn;
        }
        else {
            throw new LibraryItemException("Error: ISBN must be exactly 13 characters.");
        }
    }

    public LiteratureItem() {
    }

    public LiteratureItem(int libraryItemId, String title, int authorId, boolean availability, String isbn) throws LibraryItemException {
        super(libraryItemId, title, authorId, availability);
        this.setIsbn(isbn);
    }

    @Override
    public String toString() {
        return super.toString()+"isbn=" + isbn;
    }


}

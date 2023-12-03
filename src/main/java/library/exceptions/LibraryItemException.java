package library.exceptions;

public class LibraryItemException extends Exception{

    private String libraryItemExceptionMessage;

    //Set and get methods
    public String getLibraryItemExceptionMessage() {
        return libraryItemExceptionMessage;
    }

    public void setLibraryItemExceptionMessage(String libraryItemExceptionMessage) {
        this.libraryItemExceptionMessage = libraryItemExceptionMessage;
    }

    public LibraryItemException() {
        this.setLibraryItemExceptionMessage("Error: Library Item Exception");
    }

    public LibraryItemException(String libraryItemExceptionMessage){
        setLibraryItemExceptionMessage(libraryItemExceptionMessage);
    }

    @Override
    public String toString() {
        return this.getLibraryItemExceptionMessage();
    }
}

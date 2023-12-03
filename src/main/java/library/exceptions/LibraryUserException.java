package library.exceptions;

public class LibraryUserException extends Exception{

    private String libraryUserExceptionMessage;

    //Set and get methods
    public String getLibraryUserExceptionMessage() {
        return libraryUserExceptionMessage;
    }

    public void setLibraryUserExceptionMessage(String libraryUserExceptionMessage) {
        this.libraryUserExceptionMessage = libraryUserExceptionMessage;
    }

    public LibraryUserException() {
        this.setLibraryUserExceptionMessage("Error: Library User Exception");
    }

    public LibraryUserException(String libraryUserExceptionMessage){
        setLibraryUserExceptionMessage(libraryUserExceptionMessage);
    }

    @Override
    public String toString() {
        return this.getLibraryUserExceptionMessage();
    }
}

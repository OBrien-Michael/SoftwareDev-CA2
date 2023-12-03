package library.exceptions;

public class AuthorException extends Exception{

    private String authorExceptionMessage;

    //Set and get methods
    public String getAuthorExceptionMessage() {
        return authorExceptionMessage;
    }

    public void setAuthorExceptionMessage(String authorExceptionMessage) {
        this.authorExceptionMessage = authorExceptionMessage;
    }

    public AuthorException() {
        this.setAuthorExceptionMessage("Error: Author Exception");
    }

    public AuthorException(String authorExceptionMessage){
        setAuthorExceptionMessage(authorExceptionMessage);
    }

    @Override
    public String toString() {
        return this.getAuthorExceptionMessage();
    }
}

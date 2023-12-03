package library.exceptions;

public class LoanException extends Exception{

    private String loanExceptionMessage;

    //Set and get methods
    public String getLoanExceptionMessage() {
        return loanExceptionMessage;
    }

    public void setLoanExceptionMessage(String loanExceptionMessage) {
        this.loanExceptionMessage = loanExceptionMessage;
    }

    public LoanException() {
        this.setLoanExceptionMessage("Error: Loan Exception");
    }

    public LoanException(String loanExceptionMessage){
        setLoanExceptionMessage(loanExceptionMessage);
    }

    @Override
    public String toString() {
        return this.getLoanExceptionMessage();
    }
}

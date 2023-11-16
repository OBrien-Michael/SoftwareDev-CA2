package library;

import java.time.LocalDate;

public class BorrowedBook {
    private String isbn;
    private LocalDate borrowDate;
    private int memberId;  

    public BorrowedBook(String isbn, LocalDate borrowDate, int memberId) {
        this.isbn = isbn;
        this.borrowDate = borrowDate;
        this.memberId = memberId;
    }

    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
}

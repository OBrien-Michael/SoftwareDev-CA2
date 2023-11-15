package librarysystem;

import java.time.LocalDate;

public class BorrowedBook {
    private String isbn;
    private LocalDate borrowDate;
    private int memberId;  // Dodane, aby śledzić, który członek wypożyczył książkę

    public BorrowedBook(String isbn, LocalDate borrowDate, int memberId) {
        this.isbn = isbn;
        this.borrowDate = borrowDate;
        this.memberId = memberId;
    }

    // Gettery i settery dla isbn, borrowDate i memberId
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

package library;

import java.util.LinkedList;

public class Catalogue {

    private LinkedList<Member> memberLinkedList;
    private LinkedList<Author> authorLinkedList;
    private LinkedList<LibraryItem> libraryItemLinkedList;
    private LinkedList<Loan> loanLinkedList;

    public LinkedList<Member> getMemberLinkedList() {
        return memberLinkedList;
    }

    public void setMemberLinkedList(LinkedList<Member> memberLinkedList) {
        this.memberLinkedList = memberLinkedList;
    }

    public LinkedList<Author> getAuthorLinkedList() {
        return authorLinkedList;
    }

    public void setAuthorLinkedList(LinkedList<Author> authorLinkedList) {
        this.authorLinkedList = authorLinkedList;
    }

    public LinkedList<LibraryItem> getLibraryItemLinkedList() {
        return libraryItemLinkedList;
    }

    public void setLibraryItemLinkedList(LinkedList<LibraryItem> libraryItemLinkedList) {
        this.libraryItemLinkedList = libraryItemLinkedList;
    }

    public LinkedList<Loan> getLoanLinkedList() {
        return loanLinkedList;
    }

    public void setLoanLinkedList(LinkedList<Loan> loanLinkedList) {
        this.loanLinkedList = loanLinkedList;
    }

    public Catalogue() {
    }

    public Catalogue(LinkedList<Member> memberLinkedList, LinkedList<Author> authorLinkedList, LinkedList<LibraryItem> libraryItemLinkedList, LinkedList<Loan> loanLinkedList) {
        this.memberLinkedList = memberLinkedList;
        this.authorLinkedList = authorLinkedList;
        this.libraryItemLinkedList = libraryItemLinkedList;
        this.loanLinkedList = loanLinkedList;
    }

    @Override
    public String toString() {
        return "Catalogue{" +
                "memberLinkedList=" + memberLinkedList +
                ", authorLinkedList=" + authorLinkedList +
                ", libraryItemLinkedList=" + libraryItemLinkedList +
                ", loanLinkedList=" + loanLinkedList +
                '}';
    }
}

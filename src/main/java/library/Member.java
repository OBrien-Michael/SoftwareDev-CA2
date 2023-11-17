package library;

import java.util.LinkedList;

public class Member implements Printable,Saveable,Comparable<Member>{

    private int memberId;
    private String memberName;
    private LinkedList<LibraryItem> borrowedAssets;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public LinkedList<LibraryItem> getBorrowedAssets() {
        return borrowedAssets;
    }

    public void setBorrowedAssets(LinkedList<LibraryItem> borrowedAssets) {
        this.borrowedAssets = borrowedAssets;
    }

    public Member() {
    }

    public Member(int memberId, String memberName, LinkedList<LibraryItem> borrowedAssets) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.borrowedAssets = borrowedAssets;
    }

    public Member(int memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", borrowedAssets=" + borrowedAssets +
                '}';
    }

    @Override
    public int compareTo(Member o) {
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

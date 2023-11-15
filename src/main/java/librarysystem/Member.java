package librarysystem;

public class Member {
    private String name;
    private int memberId;

    public Member(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public int getMemberId() {
        return memberId;
    }

    @Override
    public String toString() {
        return "Member{" +
               "name='" + name + '\'' +
               ", memberId=" + memberId +
               '}';
    }
}

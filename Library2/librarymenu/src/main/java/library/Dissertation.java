package library;

public class Dissertation {
    //Attrib.
    private String title;
    private String author;
    private String university;
    private int year;
    private String department;
    private String advisor;
    private String abstractText;
    private String dissertationID; 

    // Constructor
    public Dissertation(String title, String author, String university, int year, 
                        String department, String advisor, String abstractText, 
                        String dissertationID) {
        this.title = title;
        this.author = author;
        this.university = university;
        this.year = year;
        this.department = department;
        this.advisor = advisor;
        this.abstractText = abstractText;
        this.dissertationID = dissertationID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getUniversity() {
        return university;
    }

    public int getYear() {
        return year;
    }

    public String getDepartment() {
        return department;
    }

    public String getAdvisor() {
        return advisor;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public String getDissertationID() {
        return dissertationID;
    }

    // Settery
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public void setDissertationID(String dissertationID) {
        this.dissertationID = dissertationID;
    }

    

    // Method toString to display information about dissertation
    @Override
    public String toString() {
        return "Dissertation{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", university='" + university + '\'' +
                ", year=" + year +
                ", department='" + department + '\'' +
                ", advisor='" + advisor + '\'' +
                ", abstract='" + abstractText + '\'' +
                ", dissertationID='" + dissertationID + '\'' +
                '}';
    }
}

package library;

import java.util.Date;

public abstract class ResearchItem extends LibraryItem{

    private String topic;
    private String abstractText;
    private Date datePublished;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    public ResearchItem() {
    }

    public ResearchItem(String title, Author author, boolean availability, String topic, String abstractText, Date datePublished) {
        super(title, author, availability);
        this.topic = topic;
        this.abstractText = abstractText;
        this.datePublished = datePublished;
    }

    @Override
    public String toString() {
        return "ResearchItem{" +
                "topic='" + topic + '\'' +
                ", abstractText='" + abstractText + '\'' +
                ", datePublished=" + datePublished +
                "} " + super.toString();
    }
}

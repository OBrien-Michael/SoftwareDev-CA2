package library.abstracts;

import java.time.LocalDate;

public abstract class ResearchItem extends LibraryItem {

    private String topic;
    private String abstractText;
    private LocalDate datePublished;

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

    public LocalDate getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(LocalDate datePublished) {
        this.datePublished = datePublished;
    }

    public ResearchItem() {
    }

    public ResearchItem(int libraryItemId, String title, int authorId, boolean availability, String topic, String abstractText, LocalDate datePublished) {
        super(libraryItemId, title, authorId, availability);
        this.topic = topic;
        this.abstractText = abstractText;
        this.datePublished = datePublished;
    }

    @Override
    public String toString() {
        return super.toString()+"topic=" + topic + "abstractText=" + abstractText + "datePublished=" + datePublished;
    }
}

package library.abstracts;

import library.exceptions.LibraryItemException;

import java.time.LocalDate;

public abstract class ResearchItem extends LibraryItem {

    private String topic;
    private String abstractText;
    private LocalDate datePublished;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) throws LibraryItemException {
        if(topic.length() > 2){
            this.topic = topic;
        }
        else {
            throw new LibraryItemException("Error: Topic must be greater than two characters.");
        }
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) throws LibraryItemException {
        if(abstractText.length() > 2){
            this.abstractText = abstractText;
        }
        else {
            throw new LibraryItemException("Error: Abstract must be greater than two characters.");
        }
    }

    public LocalDate getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(LocalDate datePublished) {
        this.datePublished = datePublished;
    }

    public ResearchItem() {
    }

    public ResearchItem(int libraryItemId, String title, int authorId, boolean availability, String topic, String abstractText, LocalDate datePublished) throws LibraryItemException {
        super(libraryItemId, title, authorId, availability);
        this.setTopic(topic);
        this.setAbstractText(abstractText);
        this.setDatePublished(datePublished);
    }

    @Override
    public String toString() {
        return super.toString()+"topic=" + topic + "abstractText=" + abstractText + "datePublished=" + datePublished;
    }
}

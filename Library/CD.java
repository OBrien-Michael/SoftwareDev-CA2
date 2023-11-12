public class CD {
    private String title;
    private String artist;
    private String producer;
    private double playTime;
    private boolean isAvailable;

    public CD(String title, String artist, String producer, double playTime) {
        this.title = title;
        this.artist = artist;
        this.producer = producer;
        this.playTime = playTime;
        this.isAvailable = true;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getProducer() {
        return producer;
    }

    public double getPlayTime() {
        return playTime;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString() {
        return "CD{" +
               "title='" + title + '\'' +
               ", artist='" + artist + '\'' +
               ", producer='" + producer + '\'' +
               ", playTime=" + playTime +
               ", isAvailable=" + isAvailable +
               '}';
    }
}

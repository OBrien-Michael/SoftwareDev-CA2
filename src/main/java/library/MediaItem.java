package library;

public abstract class MediaItem extends LibraryItem{

    private int playtime;

    public int getPlaytime() {
        return playtime;
    }

    public void setPlaytime(int playtime) {
        this.playtime = playtime;
    }

    public MediaItem() {
    }

    public MediaItem(String title, Author author, boolean availability, int playtime) {
        super(title, author, availability);
        this.playtime = playtime;
    }

    @Override
    public String toString() {
        return "MediaItem{" +
                "playtime=" + playtime +
                "} " + super.toString();
    }
}

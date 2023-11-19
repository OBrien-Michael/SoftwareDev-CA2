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

    public MediaItem(int libraryItemId,String title, int authorId, boolean availability, int playtime) {
        super(libraryItemId, title, authorId, availability);
        this.playtime = playtime;
    }

    @Override
    public String toString() {
        return super.toString()+" playtime=" + playtime;
    }
}

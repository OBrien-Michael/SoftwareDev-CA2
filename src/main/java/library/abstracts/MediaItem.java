package library.abstracts;

import library.exceptions.LibraryItemException;

public abstract class MediaItem extends LibraryItem{

    private int playtime;

    public int getPlaytime() {
        return playtime;
    }

    public void setPlaytime(int playtime) throws LibraryItemException {
        if(playtime > 0){
            this.playtime = playtime;
        }
        else {
            throw new LibraryItemException("Error: Playtime must be greater than 0 minutes long.");
        }
    }

    public MediaItem() {
    }

    public MediaItem(int libraryItemId,String title, int authorId, boolean availability, int playtime) throws LibraryItemException {
        super(libraryItemId, title, authorId, availability);
        this.setPlaytime(playtime);
    }

    @Override
    public String toString() {
        return super.toString()+" playtime=" + playtime;
    }
}

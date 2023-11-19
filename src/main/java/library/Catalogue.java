package library;

import java.time.LocalDate;
import java.util.LinkedList;

public class Catalogue {

    private LinkedList<LibraryUser> libraryUserLinkedList;
    private LinkedList<Author> authorLinkedList;
    private LinkedList<LibraryItem> libraryItemLinkedList;
    private LinkedList<Loan> loanLinkedList;

    public LinkedList<LibraryUser> getLibraryUserLinkedList() {
        return libraryUserLinkedList;
    }

    public void setLibraryUserLinkedList(LinkedList<LibraryUser> libraryUserLinkedList) {
        this.libraryUserLinkedList = libraryUserLinkedList;
    }

    public LinkedList<Author> getAuthorLinkedList() {
        return authorLinkedList;
    }

    public void setAuthorLinkedList(LinkedList<Author> authorLinkedList) {
        this.authorLinkedList = authorLinkedList;
    }

    public LinkedList<LibraryItem> getLibraryItemLinkedList() {
        return libraryItemLinkedList;
    }

    public void setLibraryItemLinkedList(LinkedList<LibraryItem> libraryItemLinkedList) {
        this.libraryItemLinkedList = libraryItemLinkedList;
    }

    public LinkedList<Loan> getLoanLinkedList() {
        return loanLinkedList;
    }

    public void setLoanLinkedList(LinkedList<Loan> loanLinkedList) {
        this.loanLinkedList = loanLinkedList;
    }

    public Catalogue() {
        this.libraryUserLinkedList = new LinkedList<>();
        this.authorLinkedList = new LinkedList<>();
        this.libraryItemLinkedList = new LinkedList<>();
        this.loanLinkedList = new LinkedList<>();
    }

    public Catalogue(LinkedList<LibraryUser> libraryUserLinkedList, LinkedList<Author> authorLinkedList, LinkedList<LibraryItem> libraryItemLinkedList, LinkedList<Loan> loanLinkedList) {
        this.libraryUserLinkedList = libraryUserLinkedList;
        this.authorLinkedList = authorLinkedList;
        this.libraryItemLinkedList = libraryItemLinkedList;
        this.loanLinkedList = loanLinkedList;
    }

    //Adding new Authors, LibraryUsers and LibraryItems to the Catalogue

    //If no author exists. Add an author to the catalogue with an ID of 1
    //If there are authors, grab the last Authors ID and add 1 to it and add it to the catalogue.
    public void addNewAuthor(String authorName){
        if(this.getAuthorLinkedList().isEmpty()){
            this.getAuthorLinkedList().add(new Author(1,authorName));
            System.out.println("New Author added to the catalogue: Author Id: 1 Author Name: "+authorName);
        }
        else{
            int nextAuthorId = this.getAuthorLinkedList().getLast().getAuthorId();
            this.getAuthorLinkedList().add(new Author(nextAuthorId+1,authorName));
            System.out.println("New Author added to the catalogue: Author Id: "+(nextAuthorId+1)+ " Author Name: "+authorName);
        }
    }

    //If no library user exists. Add a new library user to the catalogue with an ID of 1
    //If there are library users, grab the last users ID and add 1 to it and add it to the catalogue.
    public void addNewLibraryUser(String libraryUserName){
        if(this.getLibraryUserLinkedList().isEmpty()){
            this.getLibraryUserLinkedList().add(new LibraryUser(1,libraryUserName));
            System.out.println("New Library User added to the catalogue: Library User Id: 1 Library User Name: "+libraryUserName);
        }
        else{
            int nextLibraryUserId = this.getLibraryUserLinkedList().getLast().getLibraryUserId();
            this.getLibraryUserLinkedList().add(new LibraryUser(nextLibraryUserId+1,libraryUserName));
            System.out.println("New Library User added to the catalogue: Library User Id: "+(nextLibraryUserId+1)+" Library User Name: "+libraryUserName);
        }
    }



    //If no library item exists. Add a new book to the catalogue to the list with an ID of 1
    //If there are library items, grab the last item ID and add 1 to it and add it to the catalogue.
    public void addNewBook(String bookTitle,int bookAuthorId,String bookIsbn){
        if(this.getLibraryItemLinkedList().isEmpty()){
            this.getLibraryItemLinkedList().add(new Book(1,bookTitle,bookAuthorId,true,bookIsbn));
            System.out.println("New Book added to the catalogue: Book Id: 1 Book Title: "+bookTitle);
        }
        else{
            int nextLibraryItemId = this.getLibraryItemLinkedList().getLast().getLibraryItemId();
            this.getLibraryItemLinkedList().add(new Book(nextLibraryItemId+1,bookTitle,bookAuthorId,true,bookIsbn));
            System.out.println("New Book added to the catalogue: Book Id: "+(nextLibraryItemId+1)+" Book Title: "+bookTitle);
        }
    }

    //If no library item exists. Add a new audiobook to the catalogue to the list with an ID of 1
    //If there are library items, grab the last item ID and add 1 to it and add it to the catalogue.
    public void addNewAudioBook(String audioBookTitle,int audioBookAuthorId,String audioBookIsbn){
        if(this.getLibraryItemLinkedList().isEmpty()){
            this.getLibraryItemLinkedList().add(new AudioBook(1,audioBookTitle,audioBookAuthorId,true,audioBookIsbn));
            System.out.println("New AudioBook added to the catalogue: AudioBook Id: 1 AudioBook Title: "+audioBookTitle);
        }
        else{
            int nextLibraryItemId = this.getLibraryItemLinkedList().getLast().getLibraryItemId();
            this.getLibraryItemLinkedList().add(new AudioBook(nextLibraryItemId+1,audioBookTitle,audioBookAuthorId,true,audioBookIsbn));
            System.out.println("New AudioBook added to the catalogue: AudioBook Id: "+(nextLibraryItemId+1)+" AudioBook Title: "+audioBookTitle);
        }
    }

    //If no library item exists. Add a new dvd to the catalogue to the list with an ID of 1
    //If there are library items, grab the last item ID and add 1 to it and add it to the catalogue.
    public void addNewDVD(String dvdTitle,int dvdAuthorId,int dvdPlaytime){
        if(this.getLibraryItemLinkedList().isEmpty()){
            this.getLibraryItemLinkedList().add(new DVD(1,dvdTitle,dvdAuthorId,true,dvdPlaytime));
            System.out.println("New DVD added to the catalogue: DVD Id: 1 DVD Title: "+dvdTitle);
        }
        else{
            int nextLibraryItemId = this.getLibraryItemLinkedList().getLast().getLibraryItemId();
            this.getLibraryItemLinkedList().add(new DVD(nextLibraryItemId+1,dvdTitle,dvdAuthorId,true,dvdPlaytime));
            System.out.println("New DVD added to the catalogue: DVD Id: "+(nextLibraryItemId+1)+" DVD Title: "+dvdTitle);
        }
    }

    //If no library item exists. Add a new cd to the catalogue to the list with an ID of 1
    //If there are library items, grab the last item ID and add 1 to it and add it to the catalogue.
    public void addNewCD(String cdTitle,int cdAuthorId,int cdPlaytime){
        if(this.getLibraryItemLinkedList().isEmpty()){
            this.getLibraryItemLinkedList().add(new CD(1,cdTitle,cdAuthorId,true,cdPlaytime));
            System.out.println("New CD added to the catalogue: CD Id: 1 CD Title: "+cdTitle);
        }
        else{
            int nextLibraryItemId = this.getLibraryItemLinkedList().getLast().getLibraryItemId();
            this.getLibraryItemLinkedList().add(new CD(nextLibraryItemId+1,cdTitle,cdAuthorId,true,cdPlaytime));
            System.out.println("New CD added to the catalogue: CD Id: "+(nextLibraryItemId+1)+" CD Title: "+cdTitle);
        }
    }

    //If no library item exists. Add a new theses to the catalogue to the list with an ID of 1
    //If there are library items, grab the last item ID and add 1 to it and add it to the catalogue.
    public void addNewTheses(String thesesTitle, int thesesAuthorId, String thesesTopic, String thesesAbstractText, LocalDate thesesDatePublished){
        if(this.getLibraryItemLinkedList().isEmpty()){
            this.getLibraryItemLinkedList().add(new Theses(1,thesesTitle,thesesAuthorId,true,thesesTopic,thesesAbstractText,thesesDatePublished));
            System.out.println("New Theses added to the catalogue: Theses Id: 1 Theses Title: "+thesesTitle);
        }
        else{
            int nextLibraryItemId = this.getLibraryItemLinkedList().getLast().getLibraryItemId();
            this.getLibraryItemLinkedList().add(new Theses(nextLibraryItemId+1,thesesTitle,thesesAuthorId,true,thesesTopic,thesesAbstractText,thesesDatePublished));
            System.out.println("New Theses added to the catalogue: Theses Id: "+(nextLibraryItemId+1)+" Theses Title: "+thesesTitle);
        }
    }

    //If no library item exists. Add a new dissertation to the catalogue to the list with an ID of 1
    //If there are library items, grab the last item ID and add 1 to it and add it to the catalogue.
    public void addNewDissertation(String dissertationTitle, int dissertationAuthorId, String dissertationTopic, String dissertationAbstractText, LocalDate dissertationDatePublished){
        if(this.getLibraryItemLinkedList().isEmpty()){
            this.getLibraryItemLinkedList().add(new Dissertation(1,dissertationTitle,dissertationAuthorId,true,dissertationTopic,dissertationAbstractText,dissertationDatePublished));
            System.out.println("New Dissertation added to the catalogue: Dissertation Id: 1 Dissertation Title: "+dissertationTitle);
        }
        else{
            int nextLibraryItemId = this.getLibraryItemLinkedList().getLast().getLibraryItemId();
            this.getLibraryItemLinkedList().add(new Dissertation(nextLibraryItemId+1,dissertationTitle,dissertationAuthorId,true,dissertationTopic,dissertationAbstractText,dissertationDatePublished));
            System.out.println("New Dissertation added to the catalogue: Dissertation Id: "+(nextLibraryItemId+1)+" Dissertation Title: "+dissertationTitle);
        }
    }


    //Remove Authors, Library Users and Library Items from the catalogue

    //Iterate through the linked list and if the author id exists, remove the author
    public void removeAuthorById(int authorId){
        if(this.getAuthorLinkedList().isEmpty()){
            System.out.println("No authors exist.");
        }
        else{
            for (int i = 0; i < this.getAuthorLinkedList().size(); i++){
                if(this.getAuthorLinkedList().get(i).getAuthorId() == authorId) {
                    System.out.println("Author Id: " + this.getAuthorLinkedList().get(i).getAuthorId() + " Author Name: " +
                            this.getAuthorLinkedList().get(i).getAuthorName() + " has been deleted.");

                    this.getAuthorLinkedList().remove(i);
                    break; //break to stop iterating through the linked list
                }
            }
        }
    }

    //Iterate through the linked list and if the library user id exists, remove the user
    public void removeLibraryUserById(int libraryUserId){
        if(this.getLibraryUserLinkedList().isEmpty()){
            System.out.println("No Library Users exist.");
        }
        else{
            for (int i = 0; i < this.getLibraryUserLinkedList().size(); i++){
                if(this.getLibraryUserLinkedList().get(i).getLibraryUserId() == libraryUserId) {
                    System.out.println("Library User Id: " + this.getLibraryUserLinkedList().get(i).getLibraryUserId() + " Library User Name: " +
                            this.getLibraryUserLinkedList().get(i).getLibraryUserName() + " has been deleted.");

                    this.getLibraryUserLinkedList().remove(i);
                    break; //break to stop iterating through the linked list
                }
            }
        }
    }


    //Iterate through the linked list and if the library item id exists, remove the item
    public void removeLibraryItemById(int libraryItemId){
        if(this.getLibraryItemLinkedList().isEmpty()){
            System.out.println("No Library Items exist.");
        }
        else{
            for (int i = 0; i < this.getLibraryItemLinkedList().size(); i++){
                if(this.getLibraryItemLinkedList().get(i).getLibraryItemId() == libraryItemId) {

                    //Use polymorphism to use the correct type of object that is in the library linked list and print the correct output
                    if(this.getLibraryItemLinkedList().get(i) instanceof Book){
                        System.out.println("Book Id: " + this.getLibraryItemLinkedList().get(i).getLibraryItemId() + " Book Name: " +
                                this.getLibraryItemLinkedList().get(i).getTitle() + " Book ISBN: " + ((Book) this.getLibraryItemLinkedList().get(i)).getIsbn()
                                +" has been deleted.");
                        
                    } else if (this.getLibraryItemLinkedList().get(i) instanceof AudioBook) {
                        System.out.println("AudioBook Id: " + this.getLibraryItemLinkedList().get(i).getLibraryItemId() + " AudioBook Name: " +
                                this.getLibraryItemLinkedList().get(i).getTitle() + " Book ISBN: " + ((AudioBook) this.getLibraryItemLinkedList().get(i)).getIsbn()
                                +" has been deleted.");
                        
                    } else if (this.getLibraryItemLinkedList().get(i) instanceof DVD) {
                        System.out.println("DVD Id: "+this.getLibraryItemLinkedList().get(i).getLibraryItemId()+ "DVD Name: " +
                                this.getLibraryItemLinkedList().get(i).getTitle() + " DVD Playtime: " + ((DVD) this.getLibraryItemLinkedList().get(i)).getPlaytime()
                                +" has been deleted.");
                        
                    } else if (this.getLibraryItemLinkedList().get(i) instanceof CD) {
                        System.out.println("CD Id: "+this.getLibraryItemLinkedList().get(i).getLibraryItemId()+ "CD Name: " +
                                this.getLibraryItemLinkedList().get(i).getTitle() + " CD Playtime: " + ((CD) this.getLibraryItemLinkedList().get(i)).getPlaytime()
                                +" has been deleted.");
                        
                    } else if (this.getLibraryItemLinkedList().get(i) instanceof Theses) {
                        System.out.println("Theses Id: "+this.getLibraryItemLinkedList().get(i).getLibraryItemId()+ "Theses Name: "+
                                this.getLibraryItemLinkedList().get(i).getTitle() + " Theses Topic: "+((Theses) this.getLibraryItemLinkedList().get(i)).getTopic()+
                                " Theses Date Published: "+((Theses) this.getLibraryItemLinkedList().get(i)).getDatePublished()+" has been deleted.");
                        
                    } else if (this.getLibraryItemLinkedList().get(i) instanceof Dissertation) {
                        System.out.println("Dissertation Id: "+this.getLibraryItemLinkedList().get(i).getLibraryItemId()+ "Dissertation Name: "+
                                this.getLibraryItemLinkedList().get(i).getTitle() + " Dissertation Topic: "+((Dissertation) this.getLibraryItemLinkedList().get(i)).getTopic()+
                                " Dissertation Date Published: "+((Dissertation) this.getLibraryItemLinkedList().get(i)).getDatePublished()+" has been deleted.");
                    }

                    this.getLibraryItemLinkedList().remove(i);
                    break; //break to stop iterating through the linked list
                }
            }
        }
    }

    //Create a new loan with ids
    public void addNewLoanById(int libraryUserId, int libraryItemId){

        //Check to see if User exists
        for (LibraryUser libraryUser:libraryUserLinkedList) {
            if(libraryUser.getLibraryUserId() == libraryUserId){

                //Check to see if Library Item exists
                for(LibraryItem libraryItem:libraryItemLinkedList){
                    if(libraryItem.getLibraryItemId() == libraryItemId){
                        //Check to see if the item is available
                        if(libraryItem.isAvailable()){
                            //Create the loan and add it to the linked list
                            this.getLoanLinkedList().add(new Loan(libraryUser,libraryItem,LocalDate.now()));

                            //Add the borrowed item to the library user object
                            libraryUser.addNewBorrowedItem(libraryItem);

                            //Set the availability to false
                            libraryItem.setAvailability(false);


                            this.getLibraryUserLinkedList().set(this.getLibraryUserLinkedList().indexOf(libraryUser),libraryUser);
                            this.getLibraryItemLinkedList().set(this.getLibraryItemLinkedList().indexOf(libraryItem),libraryItem);


                            System.out.println("Created a new loan for "+libraryUser.getLibraryUserName()+" with the item "+libraryItem.getTitle());
                        }
                        else{
                            System.out.println("The item: "+libraryItem.getTitle()+ " is currently unavailable.");
                        }
                    }
                }
            }
        }
    }

    //Return an item to the library
    public void returnItemById(int libraryItemId){

        //Check to see if Loan exists
        for (Loan loan:loanLinkedList) {
            if(loan.getLibraryItem().getLibraryItemId() == libraryItemId){

                //this.getLoanLinkedList().

            }
        }
    }




    @Override
    public String toString() {
        return "Catalogue{" +
                "memberLinkedList=" + libraryUserLinkedList +
                ", authorLinkedList=" + authorLinkedList +
                ", libraryItemLinkedList=" + libraryItemLinkedList +
                ", loanLinkedList=" + loanLinkedList +
                '}';
    }

    public void loadCatalogue() {
    }

    public void saveCatalogue(){

    }
}
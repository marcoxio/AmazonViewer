package model;

import util.AmazonUtil;

import java.util.ArrayList;
import java.util.Date;

/**
 * <h1>Books</h1>
 * Clase libro donde se definen los atributos y metodos
 * hereda de {@link Publication} e implementa de {@link IVisualizable},
 *
 * @author marcoxio
 * @version 1.1
 * @since 2019
 * */
public class Books extends Publication implements IVisualizable{

    private int id;
    private String isbn;
    private boolean read;
    private int timeRead;


    public Books(String title, Date editorialDate, String editorial,String[] authors) {
        super(title, editorialDate, editorial);
        setAuthors(authors);

    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String isRead() {
        String leido = "";
        if (read == true){
            leido = "Sí";
        }else{
            leido = "No";
        }
        return leido;

    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public boolean getIsRead() {
        return read;
    }

    public int getTimeRead() {
        return timeRead;
    }

    public void setTimeRead(int timeRead) {
        this.timeRead = timeRead;
    }



    @Override
    public String toString() {
        String detailBook = "\n :: BOOK ::" +
                "\n Title: " + getTitle() +
                "\n Editorial: " + getEditorial() +
                "\n Edition Date: " + getEditorialDate() +
                "\n Authors: ";
        for (int i = 0; i < getAuthors().length; i++) {
            detailBook += "\t" + getAuthors()[i] + " ";


        }
        return detailBook;
    }

    @Override
    public Date starToSee(Date dateI) {
        return dateI;
    }

    @Override
    public void stopToSee(Date dateI, Date dateF) {
        // TODO Auto-generated method stub
        if (dateF.getTime() > dateI.getTime()) {
            setTimeRead((int)(dateF.getTime() - dateI.getTime()));
        }else {
            setTimeRead(0);
        }
    }

    public static ArrayList<Books> makeBookList() {
        ArrayList<Books> books = new ArrayList();
        String[] authors = new String[3];
        for (int i = 0; i < 3; i++) {
            authors[i] = "author "+i;
        }
        for (int i = 1; i <= 5; i++) {
            books.add(new Books("Book " + i, new Date(), "editorial " + i, authors));
        }

        return books;
    }

}

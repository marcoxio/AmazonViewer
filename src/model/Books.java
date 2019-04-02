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
    private ArrayList<Page> pages;

    public Books(String title, Date editorialDate, String editorial,String[] authors, ArrayList<Page> pages) {
        super(title, editorialDate, editorial);
        setAuthors(authors);
        this.pages = pages;
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

    public int getTimeRead() {
        return timeRead;
    }

    public void setTimeRead(int timeRead) {
        this.timeRead = timeRead;
    }

    public ArrayList<Page> getPages() {
        return pages;
    }

    public void setPages(ArrayList<Page> pages) {
        this.pages = pages;
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

    public Date startToSee(Date dateI) {
        // TODO Auto-generated method stub
        return dateI;
    }

    public void stopToSee(Date dateI, Date dateF) {
        // TODO Auto-generated method stub
        if (dateF.getTime() > dateI.getTime()) {
            setTimeRead((int)(dateF.getTime() - dateI.getTime()));
        }else {
            setTimeRead(0);
        }
    }

    public void view() {
        setRead(true);
        Date dateI = startToSee(new Date());

        //variable aux i = 0
        int i = 0;
        do {
            System.out.println("..........");
            System.out.println("Page" + getPages().get(i).getNumber());

            System.out.println(getPages().get(i).getContent());
            System.out.println("..........");
            if (i != 0) {
                System.out.println("1. Regresa Página");

            }
            System.out.println("2. Siguiente Página");
            System.out.println("0. Cerrar Libro");
            System.out.println();

            int response = AmazonUtil.validateUserResponseMenu(0, 2);

            if (response == 2) {
                i++;
            }else if(response == 1){
                i--;
            }else if (response == 0) {
                break;
            }
        }while (i < getPages().size());

        //Termine de verla
        stopToSee(dateI, new Date());
        System.out.println();
        System.out.println("Leíste: " + toString());
        System.out.println("Por: " + getTimeRead() + " milisegundos");
    }

    public static ArrayList<Books> makeBookList() {
        ArrayList<Books> books = new ArrayList();
        String[] authors = new String[3];
        //Crea los autores
        for (int i = 0; i < 3; i++) {
            authors[i] = "author "+i;
        }

        ArrayList<Page> pages = new ArrayList();
        int pagina = 0;

        for (int i = 0; i < 3; i++) {
            pagina = i + 1;
            pages.add(new Books.Page(pagina, "El contenido de la pagina" + pagina));
        }

        //Crea los 5 libros
        for (int i = 1; i <= 5; i++) {
            books.add(new Books("Book " + i, new Date(), "editorial " + i, authors,pages));
        }

        return books;
    }

    public static class Page {
        private int id;
        private int number;
        private String content;


        public Page(int number, String content) {
            super();
            this.number = number;
            this.content = content;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }


    }
}

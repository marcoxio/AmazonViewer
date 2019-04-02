package model;

import java.util.Date;
import java.util.ArrayList;

/**
 * Te pertmite ver los magazines y todas las carteleras que disponemos.
 * <p>
 * Hereda de {@link Publication}
 *
 * @author marcoxio
 * @version 1.1
 * @since 2019
 * */
public class Magazine extends Publication {
    private int id;


    public Magazine(String title, Date edititionDate, String editorial) {
        super(title, edititionDate, editorial);
        // TODO Auto-generated constructor stub
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        String detailMagazine = "\n :: MAGAZINE ::" +
                "\n Title: " + getTitle() +
                "\n Editorial: " + getEditorial() +
                "\n Edition Date: " + getEditorialDate() +
                "\n Authors: ";
        for (int i = 0; i < getAuthors().length; i++) {
            detailMagazine += "\t" + getAuthors()[i] + " ";
        }
        return  detailMagazine;
    }

    /**
     * Metodo que crea una lista de magazines
     * @return {@code ArrayList} crea hasta 5 revistas
     */
    public static ArrayList<Magazine> makeMagazineList() {
        ArrayList<Magazine> magazines = new ArrayList();
        String[] authors = new String[3];
        for (int i = 0; i < 3; i++) {
            authors[i] = "author "+i;
        }
        for (int i = 1; i <= 5; i++) {
            magazines.add(new Magazine("Magazine " + i, new Date(), "Editorial " + i));
        }

        return magazines;
    }
}

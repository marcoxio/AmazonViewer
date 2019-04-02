package model;

/**
 * <h1>Publication</h1>
 * Clase padre donde definen los atributos comunes de Books y Magazine
 * @author marcoxio
 * @since 2019
 * @version 1.1
 */

import java.util.Date;

public class Publication {

    private int id;
    private String title;
    private Date editorialDate;
    private String editorial;
    private String [] authors;


    public Publication(String title, Date editorialDate, String editorial) {
        super();
        this.title = title;
        this.editorialDate = editorialDate;
        this.editorial = editorial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getEditorialDate() {
        return editorialDate;
    }

    public void setEditorialDate(Date editorialDate) {
        this.editorialDate = editorialDate;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }
}

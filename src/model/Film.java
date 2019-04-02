package model;

/**
 * <h1>Film</h1>
 * Film es una clase padre abstracta
 * <p>
 * Esta clase es la clase base de la familia Films, como es abstracta
 * no pueden crearse instancias. Contiene el metodo abstracto
 * {@code view()} que es obligatorio implementar
 * para todo aquel que pertenezca a la familia.
 *
 * @author marcoxio
 *@version 1.1
 *@since 2019
 */
public  class Film {

    private String title;
    private String genre;
    private String creator;
    private int duration;
    private short year;
    private boolean view;

    public Film() {
    }

    public Film(String title, String genre, String creator, int duration) {
        super();
        this.title = title;
        this.genre = genre;
        this.creator = creator;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public String isView() {
        String visto = "";
        if (view == true) {
            visto = "Sí";
        }else {
            visto = "No";
        }
        return visto;
    }

    public boolean getIsViewed() {
        return view;
    }

    public void setView(boolean view) {
        this.view = view;
    }

    /**
     * {@code view()} es un método abastracto obligatorio de implementar
     *
     */
    //public abstract void view();
}

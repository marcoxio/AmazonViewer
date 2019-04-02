package model;


import java.util.Date;

/** <h1>Movie</h1>
 * Clase Movie donde se definen los atributos y metodos
 * Hereda de {@link Film}
 * Implementa de {@link IVisualizable}
 * @author marcoxio
 *
 */
public class Movie extends Film implements IVisualizable{

    private int id;
    private int timeView;

    public Movie(String title, String genre, String creator, int duration, short year) {
        super(title, genre, creator, duration);
        setYear(year);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimeView() {
        return timeView;
    }

    public void setTimeView(int timeView) {
        this.timeView = timeView;
    }

    @Override
    public String toString() {
        return  "\n :: MOVIE ::" +
                "\n Title: " + getTitle() +
                "\n Genero: " + getGenre() +
                "\n Year: " + getYear() +
                "\n Creator: " + getCreator() +
                "\n Duration: " + getDuration();
    }

    /**
     * {@inheritDoc}
     */
    public Date startToSee(Date dateI) {
        // TODO Auto-generated method stub
        return dateI;
    }

    /**
     * {@inheritDoc}
     */
    public void stopToSee(Date dateI, Date dateF) {
        // TODO Auto-generated method stub

        if (dateF.getTime() > dateI.getTime()) {
            setTimeView((int)(dateF.getTime() - dateI.getTime()));
        }else {
            setTimeView(0);
        }


    }


}

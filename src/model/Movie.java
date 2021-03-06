package model;


import java.util.ArrayList;
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
    private int timeViewed;


    public Movie(String title, String genre, String creator, int duration, short year) {
        super(title, genre, creator, duration);
        setYear(year);
    }


    public int getId() {
        return id;
    }


    public int getTimeViewed() {
        return timeViewed;
    }
    public void setTimeViewed(int timeViewed) {
        this.timeViewed = timeViewed;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return  "\n :: MOVIE ::" +
                "\n Title: " + getTitle() +
                "\n Genero: " + getGenre() +
                "\n Year: " + getYear() +
                "\n Creator: " + getCreator() +
                "\n Duration: " + getDuration();
    }

    @Override
    public Date starToSee(Date dateI) {
        return dateI;
    }

    @Override
    public void stopToSee(Date dateI, Date dateF) {
        if (dateF.getTime() > dateI.getTime()) {
            setTimeViewed((int)(dateF.getTime() - dateI.getTime()));
        }else {
            setTimeViewed(0);
        }
    }

    public static ArrayList<Movie> makeMoviesList() {
        ArrayList<Movie> movies = new ArrayList();

        for (int i = 1; i <= 5; i++) {
            movies.add(new Movie("Movie " + i, "Genero " + i, "Creador " + i, 120+i, (short)(2017+i)));
        }

        return movies;
    }


    @Override
    public void view() {
        setView(true);
        Date dateI = starToSee(new Date());

        for (int i = 0; i < 100000; i++) {
            System.out.println("..........");
        }

        //Termine de verla
        stopToSee(dateI, new Date());
        System.out.println();
        System.out.println("Viste: " + toString());
        System.out.println("Por: " + getTimeViewed() + " milisegundos");


    }
}

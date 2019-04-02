package model;

import java.util.ArrayList;

/**
 * *<h1>Chapters</h1>
 * Te pertmite ver los Chapters de todas las series que disponemos.
 * <p>
 *
 * Hereda de {@link Movie}
 * @see Film
 * @author marcoxio
 * @version 1.1
 * @since 2019
 */
public class Chapter extends Movie{

    private int id;
    private int sessionNumber;
    private Serie serie;

    public Chapter(String title, String genre, String creator, int duration, short year, int sessionNumber, Serie serie) {
        super(title, genre, creator, duration, year);
        // TODO Auto-generated constructor stub
        this.setSessionNumber(sessionNumber);
        this.setSerie(serie);
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getSessionNumber() {
        return sessionNumber;
    }

    public void setSessionNumber(int sessionNumber) {
        this.sessionNumber = sessionNumber;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return  "\n :: SERIE ::" +
                "\n Title: " + getSerie().getTitle() +
                "\n :: CHAPTER ::" +
                "\n Title: " + getTitle() +
                "\n Year: " + getYear() +
                "\n Creator: " + getCreator() +
                "\n Duration: " + getDuration();
    }

    /**
     * Método que crea una lista de capitulos aleatoria para una serie.
     * @param serie objeto {@code Serie} para crear una lista de capítulos.
     * @return {@code ArrayList} que crea 5 capítulos de una serie de manera aleatoria.
     */
    public static ArrayList<Chapter> makeChaptersList(Serie serie) {
        ArrayList<Chapter> chapters = new ArrayList();

        for (int i = 1; i <= 5; i++) {
            chapters.add(new Chapter("Capituo "+i, "genero "+i, "creator" +i, 45, (short)(2017+i), i, serie));
        }

        return chapters;
    }

    @Override
    public void view() {
        super.view();
        ArrayList<Chapter> chapters =  getSerie().getChapters();
        int chapterViewedCounter = 0;
        for (Chapter chapter : chapters) {
            if (chapter.getIsViewed()) {
                chapterViewedCounter++;
            }
        }

        if (chapterViewedCounter == chapters.size()) {
            getSerie().view();
        }
    }
}

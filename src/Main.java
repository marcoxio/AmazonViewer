import com.marcoxio.makereport.Report;
import model.*;
import util.AmazonUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    /**
     * <h1>Amazon Viewer</h1> AmazonViewer es un programa que permite visualizar
     * Movies, Series con sus respectivos Chapters, Books y Magazines. Te permite
     * generar reportes generales y con fecha del dia.
     * <p>
     * Existen algunas reglas como todos los elementos puede ser visualizados o
     * leidos a excepcion de los Maganizes, estas solo pueden ser vistas a modo de
     * exposicion sin ser leídos.
     *
     * @author marcoxio
     * @version 1.1
     * @since 2019
     *
     */
    public static void main(String[] args) {
        showMenu();


    }

    public static void showMenu(){
        int exit = 0;

        do{
            System.out.println("Welcome Amazon Viewer");
            System.out.println("");
            System.out.println("Select the number of action");
            System.out.println("1. Movies");
            System.out.println("2. Series");
            System.out.println("3. Books");
            System.out.println("4. Magazines");
            System.out.println("5. Report");
            System.out.println("6. Report Today");
            System.out.println("0. Exit");


            //read response of user
            int response = AmazonUtil.validateUserResponseMenu(0, 6);

            switch (response){
                case 0:
                    //exit
                    exit = 0;
                    break;
                case 1:
                    showMovies();
                    break;

                case 2:
                    showSeries();
                    break;

                case 3:
                    showBooks();
                    break;

                case 4:
                    showMagazines();
                    break;
                case 5:
                    makeReport();
                    break;

                case 6:
                    makeReport(new Date());
                    break;
                default:
                    System.out.println();
                    System.out.println("Elegiste una opción no valida");
                    System.out.println();
                    exit = 1;
                    break;

            }


        }while (exit != 0);
    }
    static ArrayList<Movie> movies = Movie.makeMoviesList();
    public static void showMovies() {
        int exit = 1;
        do {
            System.out.println();
            System.out.println(":: MOVIES ::");
            System.out.println();

            for (int i = 0; i < movies.size(); i++) { //1. Movie 1
                System.out.println(i+1 + ". " + movies.get(i).getTitle() + " Visto: " + movies.get(i).isView());
            }

            System.out.println("0. Regresar al Menu");
            System.out.println();

            //Leer Respuesta usuario
            int response = AmazonUtil.validateUserResponseMenu(0, movies.size());

            if(response == 0) {
                exit = 0;
                showMenu();
                break;
            }
            if (response > 0) {
                Movie movieSelected = movies.get(response-1);
                movieSelected.setView(true);
                Date dateI = movieSelected.starToSee(new Date());

                for (int i = 0; i < 100000; i++) {
                    System.out.println("..........");
                }

                //Termine de verla
                movieSelected.stopToSee(dateI, new Date());
                System.out.println();
                System.out.println("Viste: " + movieSelected);
                System.out.println("Por: " + movieSelected.getTimeViewed() + " milisegundos");
            }


        }while(exit !=0);
    }

    static ArrayList<Serie> series = Serie.makeSeriesList();
    public static void showSeries() {
        int exit = 1;

        do {
            System.out.println();
            System.out.println(":: SERIES ::");
            System.out.println();

            for (int i = 0; i < series.size(); i++) { //1. Serie 1
                System.out.println(i+1 + ". " + series.get(i).getTitle() + " Visto: " + series.get(i).isView());
            }

            System.out.println("0. Regresar al Menu");
            System.out.println();

            //Leer Respuesta usuario
            int response = AmazonUtil.validateUserResponseMenu(0, series.size());

            if(response == 0) {
                exit = 0;
                showMenu();
            }

            if(response > 0) {
                showChapters(series.get(response-1).getChapters());
            }


        }while(exit !=0);
    }

    public static void showChapters(ArrayList<Chapter> chaptersOfSerieSelected) {
        int exit = 1;

        do {
            System.out.println();
            System.out.println(":: CHAPTERS ::");
            System.out.println();


            for (int i = 0; i < chaptersOfSerieSelected.size(); i++) { //1. Chapter 1
                System.out.println(i+1 + ". " + chaptersOfSerieSelected.get(i).getTitle() + " Visto: " + chaptersOfSerieSelected.get(i).isView());
            }

            System.out.println("0. Regresar al Menu");
            System.out.println();

            //Leer Respuesta usuario
            int response = AmazonUtil.validateUserResponseMenu(0, chaptersOfSerieSelected.size());

            if(response == 0) {
                exit = 0;
            }


            if(response > 0) {
                Chapter chapterSelected = chaptersOfSerieSelected.get(response-1);
                chapterSelected.setView(true);
                Date dateI = chapterSelected.starToSee(new Date());

                for (int i = 0; i < 100000; i++) {
                    System.out.println("..........");
                }

                //Termine de verla
                chapterSelected.stopToSee(dateI, new Date());
                System.out.println();
                System.out.println("Viste: " + chapterSelected);
                System.out.println("Por: " + chapterSelected.getTimeViewed() + " milisegundos");
            }
        }while(exit !=0);
    }





    public static void showMagazines() {
        ArrayList<Magazine> magazines = Magazine.makeMagazineList();
        int exit = 0;
        do {
            System.out.println();
            System.out.println(":: MAGAZINES ::");
            System.out.println();

            for (int i = 0; i < magazines.size(); i++) { //1. Book 1
                System.out.println(i+1 + ". " + magazines.get(i).getTitle());
            }

            System.out.println("0. Regresar al Menu");
            System.out.println();

            //Leer Respuesta usuario
            int response = AmazonUtil.validateUserResponseMenu(0, 0);

            if(response == 0) {
                exit = 0;
                showMenu();
            }


        }while(exit !=0);
    }

    static ArrayList<Books> books= Books.makeBookList();
    public static void showBooks() {
        int exit = 1;

        do {
            System.out.println();
            System.out.println(":: BOOKS ::");
            System.out.println();

            for (int i = 0; i < books.size(); i++) { //1. Book 1
                System.out.println(i+1 + ". " + books.get(i).getTitle() + " Leído: " + books.get(i).isRead());
            }

            System.out.println("0. Regresar al Menu");
            System.out.println();

            //Leer Respuesta usuario
            int response = AmazonUtil.validateUserResponseMenu(0, books.size());

            if(response == 0) {
                exit = 0;
                showMenu();
            }

            if(response > 0) {
                Books bookSelected = books.get(response-1);
                bookSelected.setRead(true);
                Date dateI = bookSelected.starToSee(new Date());

                for (int i = 0; i < 100000; i++) {
                    System.out.println("..........");
                }

                //Termine de verla
                bookSelected.stopToSee(dateI, new Date());
                System.out.println();
                System.out.println("Leíste: " + bookSelected);
                System.out.println("Por: " + bookSelected.getTimeRead() + " milisegundos");
            }

        }while(exit !=0);
    }


    public static void makeReport() {

        Report report = new Report();
        report.setNameFile("reporte");
        report.setExtension("txt");
        report.setTitle(":: VISTOS ::");
        String contentReport = "";

        for (Movie movie : movies) {
            if (movie.getIsViewed()) {
                contentReport += movie.toString() + "\n";

            }
        }

        for (Serie serie : series) {
            ArrayList<Chapter> chapters = serie.getChapters();
            for (Chapter chapter : chapters) {
                if (chapter.getIsViewed()) {
                    contentReport += chapter.toString() + "\n";

                }
            }
        }


        for (Books book : books) {
            if (book.getIsRead()) {
                contentReport += book.toString() + "\n";

            }
        }

        report.setContent(contentReport);
        report.makeReport();
        System.out.println("Reporte Generado");
        System.out.println();
    }

    public static void makeReport(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-h-m-s-S");
        String dateString = df.format(date);
        Report report = new Report();

        report.setNameFile("reporte" + dateString);
        report.setExtension("txt");
        report.setTitle(":: VISTOS ::");


        SimpleDateFormat dfNameDays = new SimpleDateFormat("E, W MMM Y");
        dateString = dfNameDays.format(date);
        String contentReport = "Date: " + dateString + "\n\n\n";

        for (Movie movie : movies) {
            if (movie.getIsViewed()) {
                contentReport += movie.toString() + "\n";

            }
        }

        for (Serie serie : series) {
            ArrayList<Chapter> chapters = serie.getChapters();
            for (Chapter chapter : chapters) {
                if (chapter.getIsViewed()) {
                    contentReport += chapter.toString() + "\n";

                }
            }
        }

        for (Books book : books) {
            if (book.getIsRead()) {
                contentReport += book.toString() + "\n";

            }
        }
        report.setContent(contentReport);
        report.makeReport();

        System.out.println("Reporte Generado");
        System.out.println();
    }


}

import model.Movie;
import util.AmazonUtil;

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
    static ArrayList<Movie> movies = new ArrayList<>();
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
                Date dateI = movieSelected.startToSee(new Date());

                for (int i = 0; i < 100000; i++) {
                    System.out.println("..........");
                }

                //Termine de verla
                movieSelected.stopToSee(dateI, new Date());
                System.out.println();
                System.out.println("Viste: " + movieSelected);
                System.out.println("Por: " + movieSelected.getTimeView() + " milisegundos");
            }


        }while(exit !=0);
    }

    public static void showSeries() {
    }

    public static void makeReport(Date date) {
    }

    public static void makeReport() {
    }

    public static void showMagazines() {
    }

    public static void showBooks() {
    }


}

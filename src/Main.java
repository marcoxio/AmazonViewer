import util.AmazonUtil;

import java.util.Date;

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

    public static void showMovies() {
    }
}

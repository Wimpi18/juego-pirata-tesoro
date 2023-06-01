import java.util.Scanner;
import java.util.Random;

/**
 * La clase Main se encarga de ejecutar el programa, para ello genera un Random, un Scanner, un Pirata, un Tesoro y el Tablero.
 * 
 * @author Maida Rojas Jairo Andree,  Morales Pinto Giulianno Alejandro, Orellana Vásquez Winsor Omar, Vallejos Delgadillo Mariana Andre
 * @version 1.0.0
 */
public class Main
{
    public static void main(String args[]){
        Tablero tablero;

        tablero = iniciarTablero();

        System.out.println(tablero.mostrar());
        System.out.println("Contador de movimientos " + tablero.getPirata().getContador());
        System.out.println();

        /**
         * Mientras no se dé ninguna situación de victoria o derrota, el pirata seguirá moviendose por el tablero aumentando tras
         * cada movimiento su contador de movimientos
         */
        while(!tablero.juegoFinalizado()){
            tablero.jugar();
            System.out.println(tablero.mostrar());
            System.out.println("Contador de movimientos " + tablero.getPirata().getContador());
            System.out.println();
            try
            {
                Thread.sleep(2000);
            }
            catch (java.lang.InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
        System.out.println();
        System.out.println(tablero.getMensaje());
    }

    public static String verificarTamanio(int tamanio){
        String mensaje;

        if(tamanio >= 4){
            mensaje = null;
        }else{
            mensaje = "Valor de N invalido, N debe ser mayor o igual a 4";
        }
        return mensaje;
    }

    private static void generarPosiciones(int[] posicion1, int[] posicion2, int tamanio){
        Random rand = new Random();
        posicion1 = new int[2];
        posicion2 = new int[2];

        posicion1[0] = rand.nextInt(tamanio-2) + 1;
        posicion1[1] = rand.nextInt(tamanio-2) + 1;
        posicion2[0] = rand.nextInt(tamanio-2) + 1;
        posicion2[1] = rand.nextInt(tamanio-2) + 1;

        while(posicion2[0] == posicion1[0] && posicion2[1] == posicion1[1]){
            posicion1[0] = rand.nextInt(tamanio-2) + 1;
            posicion1[1] = rand.nextInt(tamanio-2) + 1;
        }
    }

    private static int obtenerTamanioTablero(){
        int tamanio;
        Scanner lector;

        lector = new Scanner(System.in);

        do{
            System.out.println("Introduzca el valor de N");
            tamanio = lector.nextInt();
            if(verificarTamanio(tamanio) != null){
                System.out.println(verificarTamanio(tamanio));
            }
        }while(verificarTamanio(tamanio) != null);

        return tamanio;
    }

    private static void iniciarPirataYTesoro(Pirata pirata, Tesoro tesoro, int tamanio){
        Random rand = new Random();
        
        pirata.setX(rand.nextInt(tamanio-2) + 1);
        pirata.setY(rand.nextInt(tamanio-2) + 1);
        tesoro.setX(rand.nextInt(tamanio-2) + 1);
        tesoro.setY(rand.nextInt(tamanio-2) + 1);

        while(tesoro.getX() == pirata.getX() && tesoro.getY() == pirata.getY()){
            pirata.setX(rand.nextInt(tamanio-2) + 1);
            pirata.setY(rand.nextInt(tamanio-2) + 1);
        }
    }

    private static Tablero iniciarTablero(){
        Pirata pirata;
        Tesoro tesoro;
        Tablero tablero;
        int tamanio;

        tamanio = obtenerTamanioTablero();

        pirata = new Pirata(new int[2]);
        tesoro = new Tesoro(new int[2]);
        iniciarPirataYTesoro(pirata, tesoro, tamanio);

        tablero = new Tablero(tamanio, pirata, tesoro);

        return tablero;
    }
}
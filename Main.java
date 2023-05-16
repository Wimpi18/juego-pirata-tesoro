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
        Random rand = new Random();
        Pirata pirata = new Pirata(1, 2);
        Tesoro tesoro = new Tesoro(1, 3);
        Tablero tablero = new Tablero(pirata, tesoro);

        Scanner lector = new Scanner(System.in);
        int n = 0;
        String mensaje = "";

        /**
         * Mientras no se introduzca un N >= 4 entonces no se generará el tablero
         */
        while(mensaje != null){
            System.out.println("Introduzca el valor de N");
            n = lector.nextInt();
            mensaje = tablero.verificarn(n);
            if(mensaje != null){
                System.out.println(mensaje);
            }
        }

        /**
         * Dar posiciones al pirata y al tesoro
         */
        tesoro.setX(rand.nextInt(n-2) + 1); tesoro.setY(rand.nextInt(n-2) + 1);
        pirata.setX(rand.nextInt(n-2) + 1); pirata.setY(rand.nextInt(n-2) + 1);

        /**
         * Mientras las posiciones del tesoro y pirata sean iguales, se asignará otra posición al pirata
         */
        while(tesoro.getX() == pirata.getX() && tesoro.getY() == pirata.getY()){
            pirata.setX(rand.nextInt(n-2) + 1); pirata.setY(rand.nextInt(n-2) + 1);
        }

        /**
         * Estado inicial
         */
        tablero.iniciar(n);
        System.out.println(tablero.mostrar());
        System.out.println("Contador de movimientos " + pirata.getContador());
        System.out.println();

        /**
         * Mientras no se dé ninguna situación de victoria o derrota, el pirata seguirá moviendose por el tablero aumentando tras
         * cada movimiento su contador de movimientos
         */
        while(!tablero.juegoFinalizado()){
            tablero.jugar();
            System.out.println(tablero.mostrar());
            System.out.println("Contador de movimientos " + pirata.getContador());
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
}
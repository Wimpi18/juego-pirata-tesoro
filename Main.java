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
        Tablero tablero;
        Verificador verificador = new Verificador();

        Scanner lector = new Scanner(System.in);
        int tamanio;

        do{
            System.out.println("Introduzca el valor de N");
            tamanio = lector.nextInt();
            if(verificador.verificarTamanio(tamanio) != null){
                System.out.println(verificador.verificarTamanio(tamanio));
            }
        }while(verificador.verificarTamanio(tamanio) != null);

        /**
         * Dar posiciones al pirata y al tesoro
         */
        tesoro.setX(rand.nextInt(tamanio-2) + 1); tesoro.setY(rand.nextInt(tamanio-2) + 1);
        pirata.setX(rand.nextInt(tamanio-2) + 1); pirata.setY(rand.nextInt(tamanio-2) + 1);

        /**
         * Mientras las posiciones del tesoro y pirata sean iguales, se asignará otra posición al pirata
         */
        while(tesoro.getX() == pirata.getX() && tesoro.getY() == pirata.getY()){
            pirata.setX(rand.nextInt(tamanio-2) + 1); pirata.setY(rand.nextInt(tamanio-2) + 1);
        }

        /**
         * Estado inicial
         */
        tablero = new Tablero(tamanio, pirata, tesoro);
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
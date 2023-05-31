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
        
        Pirata pirata;
        Tesoro tesoro;
        Tablero tablero;
        Verificador verificador = new Verificador();
        int[] posicionPirata;
        int[] posicionTesoro;
        Posicionador posicionador;
        
        Scanner lector = new Scanner(System.in);
        int tamanio;

        do{
            System.out.println("Introduzca el valor de N");
            tamanio = lector.nextInt();
            if(verificador.verificarTamanio(tamanio) != null){
                System.out.println(verificador.verificarTamanio(tamanio));
            }
        }while(verificador.verificarTamanio(tamanio) != null);
        
        posicionPirata = new int[2];
        posicionTesoro = new int[2];
        posicionador = new Posicionador();
        posicionador.generarPosiciones(posicionPirata, posicionTesoro, tamanio);
        
        pirata = new Pirata(posicionPirata);
        tesoro = new Tesoro(posicionTesoro);
        

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
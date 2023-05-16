import java.util.Scanner;
import java.util.Random;

/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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

        while(mensaje != null){
            System.out.println("Introduzca el valor de N");
            n = lector.nextInt();
            mensaje = tablero.verificarn(n);
            if(mensaje != null){
                System.out.println(mensaje);
            }
        }

        tesoro.setX(rand.nextInt(n-2) + 1); tesoro.setY(rand.nextInt(n-2) + 1);
        pirata.setX(rand.nextInt(n-2) + 1); pirata.setY(rand.nextInt(n-2) + 1);

        while(tesoro.getX() == pirata.getX() && tesoro.getY() == pirata.getY()){
            pirata.setX(rand.nextInt(n-2) + 1); pirata.setY(rand.nextInt(n-2) + 1);
        }
        
        // Estado inicial
        tablero.iniciar(n);
        System.out.println(tablero.mostrar());
        System.out.println("Contador de movimientos " + pirata.getContador());
        System.out.println();
    
        // Movimientos
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
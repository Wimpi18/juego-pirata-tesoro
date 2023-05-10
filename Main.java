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
        System.out.println("Introduzca el valor de N");
        int n = lector.nextInt();
        String mensaje = tablero.verificarn(n);

        while(mensaje != null){
            System.out.println("Introduzca el valor de N");
            n = lector.nextInt();
            mensaje = tablero.verificarn(n);
        }

        tesoro.setX(rand.nextInt(n-2) + 1); tesoro.setY(rand.nextInt(n-2) + 1);
        pirata.setX(rand.nextInt(n-2) + 1); pirata.setY(rand.nextInt(n-2) + 1);

        while(tesoro.getX() == pirata.getX() && tesoro.getY() == pirata.getY()){
            pirata.setX(rand.nextInt(n-2) + 1); pirata.setY(rand.nextInt(n-2) + 1);
        }
        tablero.iniciar(n);
        System.out.println(tablero.mostrar());
        //tablero.jugar();
        for(int j = 0; j < 60; j++){
            System.out.println("El pirata se mueve" + j);
            tablero.jugar();
            System.out.println(tablero.mostrar());
        }
        
    }
}
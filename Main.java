import java.util.Scanner;

/**
 * La clase Main se encarga de ejecutar el programa, para ello genera un Random, un Scanner, un Pirata, un Tesoro y el Tablero.
 * 
 * @author Maida Rojas Jairo Andree,  Morales Pinto Giulianno Alejandro, Orellana Vásquez Winsor Omar, Vallejos Delgadillo Mariana Andre
 * @version 1.0.0
 */
public class Main{
    public static void main(String args[]){
        int n = obtenerN();
        Tablero tablero = new Tablero(n);

        // Estado inicial
        tablero.inicializar(n);
        tablero.mostrar();

        /**
         * Mientras no se dé ninguna situación de victoria o derrota, el pirata seguirá moviendose por el tablero aumentando tras
         * cada movimiento su contador de movimientos
         */
        while(!tablero.juegoFinalizado()){
            tablero.jugar();
        }
        System.out.println(tablero.getMensaje());
    }

    /**
     * Mientras no se introduzca un N >= 4 entonces no se generará el tablero
     */
    private static int obtenerN(){
        Scanner lector = new Scanner(System.in);
        int resultado;
        do{
            System.out.println("Introduzca el valor de N");
            resultado = lector.nextInt();
            if(resultado < 4){
                System.out.println("Valor de n invalido, n debe ser mayor o igual a 4 \n");
            }
        }while(resultado < 4);
        return resultado;
    }
}
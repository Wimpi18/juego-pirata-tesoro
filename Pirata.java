import java.util.*;
/**
 * La clase Pirata debe posicionarse en una casilla válida del Tablero distinta a la del Tesoro y ser capaz de moverse 50 veces
 * 
 * @author Maida Rojas Jairo Andree,  Morales Pinto Giulianno Alejandro, Orellana Vásquez Winsor Omar, Vallejos Delgadillo Mariana Andre
 * @version 1.0.0
 */
public class Pirata extends Elemento{
    private int contador;
    private Random rand;
    public final int NORTE = 1;
    public final int SUR = 2;
    public final int ESTE = 3;
    public final int OESTE = 4;

    /**
     * Constructor de la clase Pirata
     * 
     * @param x Coordenada en x (filas)
     * @param x Coordenada en y (columnas)
     */
    public Pirata(int x, int y){
        super(x, y);
        contador = 0;
        rand = new Random();
    }

    public void incrementarContador(){
        this.contador = contador + 1;
    }

    /**
     * El movimiento del pirata es definido por un número aleatorio entre 1 y 4 tal que 1 = Norte, 2 = Sur, 3 = Este y 4 = Oeste, tras
     * cada movimiento el contador aumenta en 1 y el pirata solo se moverá si dicho contador es < 50 movimientos.
     */
    public void moverPirata(){
        Direccion direccion = null;
        int direccionAleatoria = rand.nextInt(4) + 1;
        if(contador < 50){
            switch(direccionAleatoria){
                case NORTE:
                    direccion = new Norte();
                break;
                case SUR:
                    direccion = new Sur();
                break;
                case ESTE:
                    direccion = new Este();
                break;
                case OESTE:
                    direccion = new Oeste();
                break;
            }
            direccion.setPosicion(this);
            incrementarContador();
        }
    }

    /**
     * Mientras las posiciones del tesoro y pirata sean iguales, se asignará otra posición al pirata
     */
    public void verificarPosicionesDistintas(Tesoro tesoro, int n){
        while(tesoro.getX() == getX() && tesoro.getY() == getY()){
            setX(rand.nextInt(n-2) + 1); 
            setY(rand.nextInt(n-2) + 1);
        }
    }

    public int getContador(){
        return contador;
    }

    public void setContador(int c){
        contador = c;
    }
}
import java.util.*;
/**
 * La clase Pirata debe posicionarse en una casilla válida del Tablero distinta a la del Tesoro y ser capaz de moverse 50 veces
 * 
 * @author Maida Rojas Jairo Andree,  Morales Pinto Giulianno Alejandro, Orellana Vásquez Winsor Omar, Vallejos Delgadillo Mariana Andre
 * @version 1.0.0
 */
public class Pirata extends Elemento{
    int contador;
    
    /**
     * Constructor de la clase Pirata
     * 
     * @param x Coordenada en x (filas)
     * @param x Coordenada en y (columnas)
     */
    public Pirata(int x, int y){
        super(x, y);
        contador = 0;
    }
    
    public void incrementarContador(){
       this.contador = contador + 1;
    }
    
    /**
     * El movimiento del pirata es definido por un número aleatorio entre 1 y 4 tal que 1 = Norte, 2 = Sur, 3 = Este y 4 = Oeste, tras
     * cada movimiento el contador aumenta en 1 y el pirata solo se moverá si dicho contador es < 50 movimientos.
     */
    public void moverPirata(){
        int direccion = (int)(Math.random() * 4 + 1);
        if(contador < 50){
            switch(direccion){
                case 1:
                    setX(getX() - 1);
                    incrementarContador();
                    break;
                case 2:
                    setX(getX() + 1);
                    incrementarContador();
                    break;
                case 3:
                    setY(getY() + 1);
                    incrementarContador();
                    break;
                case 4:
                    setY(getY() - 1);
                    incrementarContador();
                    break;
            }
        }
    }
    
    public int getContador(){
        return contador;
    }
    
    public void setContador(int c){
        contador = c;
    }
}
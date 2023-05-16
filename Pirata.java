import java.util.*;
/**
 * Write a description of class Pirata here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pirata extends Elemento{
    int contador;
    public Pirata(int x, int y){
        super(x, y);
        contador = 0;
    }
    public void incrementarContador(){
       this.contador = contador + 1;
    }
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
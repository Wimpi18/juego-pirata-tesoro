import java.util.*;

public class Pirata extends Elemento{
    private int contador;
    
    public Pirata(int[] coordenadas){
        super(coordenadas);
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
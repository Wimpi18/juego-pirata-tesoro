/**
 * Abstract class Elemento - write a description of the class here
 * 
 * @author: 
 * Date: 
 */
public abstract class Elemento
{
    protected int coordenadas[];
    
    public Elemento(int x, int y){
        coordenadas = new int[2];
        coordenadas[0] = x;
        coordenadas[1] = y;
    }
    
    protected void setX(int x){
        coordenadas[0] = x;
    }
    
    protected void setY(int y){
        coordenadas[1] = y;
    }
    
    protected int[] getCoordenadas(){
        return coordenadas;
    }
    
    protected int getX(){
        return coordenadas[0];
    }
    
    protected int getY(){
        return coordenadas[1];
    }
}
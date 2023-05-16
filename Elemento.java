/**
 * Clase abstracta Elemento - Nos permite generalizar los atributos y funciones en común entre Tablero y Pirata
 * 
 * @author Maida Rojas Jairo Andree,  Morales Pinto Giulianno Alejandro, Orellana Vásquez Winsor Omar, Vallejos Delgadillo Mariana Andre
 * @version 1.0.0 
 */
public abstract class Elemento
{
    protected int coordenadas[];
    
    /**
     * Constructor de la clase Elemento
     * 
     * @param x Coordenada en x (filas)
     * @param x Coordenada en y (columnas)
     */
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
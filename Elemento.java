public abstract class Elemento
{
    protected int coordenadas[];

    public Elemento(int[] coordenadas){
        this.coordenadas = coordenadas;
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
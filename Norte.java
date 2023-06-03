/**
 * @author Maida Rojas Jairo Andree,  Morales Pinto Giulianno Alejandro, Orellana Vásquez Winsor Omar, Vallejos Delgadillo Mariana Andre
 * @version 1.0.0 
 */
public class Norte extends Direccion{
    public void setPosicion(Pirata pirata){
        pirata.setX(pirata.getX() - 1);
    }
}
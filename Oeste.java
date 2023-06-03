/**
 * @author Maida Rojas Jairo Andree,  Morales Pinto Giulianno Alejandro, Orellana Vásquez Winsor Omar, Vallejos Delgadillo Mariana Andre
 * @version 1.0.0 
 */
public class Oeste extends Direccion{
    public void setPosicion(Pirata pirata){
        pirata.setY(pirata.getY() - 1);
    }
}
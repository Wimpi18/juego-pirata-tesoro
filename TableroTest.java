
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Clase test TableroTest.
 *
 * @author Maida Rojas Jairo Andree,  Morales Pinto Giulianno Alejandro, Orellana Vásquez Winsor Omar, Vallejos Delgadillo Mariana Andre
 * @version 1.0.0 
 */
public class TableroTest
{

    /**
     * Test de la creación correcta de una matriz de tamaño 5
     */
    @Test
    public void iniciarMatriz(){
        Pirata pirata = new Pirata(2, 2);
        Tesoro tesoro = new Tesoro(2, 3);
        Tablero tablero = new Tablero(5, pirata, tesoro);
        tablero.iniciar(5);

        String res = "+---+---+---+---+---+\n" +
            "| A | G | U | A | P |\n" +
            "+---+---+---+---+---+\n" +
            "| G |   |   |   | A |\n" +
            "+---+---+---+---+---+\n" +
            "| U |   | W | T | U |\n" +
            "+---+---+---+---+---+\n" +
            "| A |   |   |   | G |\n" +
            "+---+---+---+---+---+\n" +
            "| P | A | U | G | A |\n" +
            "+---+---+---+---+---+";

        assertEquals(res, tablero.mostrar());
    }
    
    /**
     * Test de la verificación del valor N sea >= 4
     */
    @Test 
    public void verificarN(){
        Verificador verificador;
        
        verificador = new Verificador();
        String res = "Valor de N invalido, N debe ser mayor o igual a 4";
        assertEquals(res, verificador.verificarTamanio(3));
    }

    /**
     * Test de victoria dado una posición inicial cercana a una casilla y un movimiento en el cual el Pirata y el Tesoro coinciden 
     * en la misma casilla
     */
    @Test 
    public void testVictoria(){
        Pirata pirata = new Pirata(2, 2);
        Tesoro tesoro = new Tesoro(2, 3);
        Tablero tablero = new Tablero(5, pirata, tesoro);
        tablero.iniciar(5);
        pirata.setY(pirata.getY()+1);
        tablero.verificarEstadoJuego();

        assertEquals("VICTORIA!!! TESORO ENCONTRADO!!!", tablero.getMensaje());
    }

    /**
     * Test de derrota en el que el Pirata se queda sin movimientos
     */
    @Test 
    public void testDerrotaContador(){
        Pirata pirata = new Pirata(1, 1);
        Tesoro tesoro = new Tesoro(2, 3);
        Tablero tablero = new Tablero(5, pirata, tesoro); 
        tablero.iniciar(5);

        pirata.setContador(50);
        tablero.verificarEstadoJuego();

        assertEquals("DERROTA, LÍMITE DE MOVIMIENTOS ALCANZADO", tablero.getMensaje());
    }

    /**
     * Test de derrota dado una posicial inicial cercana al borde y un movimiento en el cual el Pirata coincide con dicho borde
     */
    @Test 
    public void testDerrotaAhogado(){
        Pirata pirata = new Pirata(1, 1);
        Tesoro tesoro = new Tesoro(2, 3);
        Tablero tablero = new Tablero(5, pirata, tesoro);
        tablero.iniciar(5);

        pirata.setY(pirata.getX()-1);
        tablero.verificarEstadoJuego();

        assertEquals("DERROTA, PIRATA AHOGADO", tablero.getMensaje());
    }
}
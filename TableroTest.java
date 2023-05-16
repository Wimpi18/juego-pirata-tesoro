
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class TableroTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TableroTest
{

    
    @Test 
    public void iniciarMatriz(){
        Tablero tablero;

        tablero = new Tablero(null, null);

        tablero.iniciar(5);

        String res = "+---+---+---+---+---+\n" +
            "| A | G | U | A | P |\n" +
            "+---+---+---+---+---+\n" +
            "| G |   |   |   | A |\n" +
            "+---+---+---+---+---+\n" +
            "| U |   |   |   | U |\n" +
            "+---+---+---+---+---+\n" +
            "| A |   |   |   | G |\n" +
            "+---+---+---+---+---+\n" +
            "| P | A | U | G | A |\n" +
            "+---+---+---+---+---+";

        assertEquals(res, tablero.mostrar());
    }
    @Test 
    public void verificarN(){
        Tablero tablero;
        tablero = new Tablero(null, null);

        String res = "Valor de n invalido, n debe ser mayor o igual a 4";
        assertEquals(res, tablero.verificarn(3));
    }

    @Test 
    public void testVictoria(){
        Pirata pirata = new Pirata(2, 2);
        Tesoro tesoro = new Tesoro(2, 3);
        Tablero tablero = new Tablero(pirata, tesoro);
        tablero.iniciar(5); 

        pirata.setY(pirata.getY()+1);
        tablero.verificarEstadoJuego();

        assertEquals("VICTORIA!!! TESORO ENCONTRADO!!!", tablero.getMensaje());
    }

    @Test 
    public void testDerrotaContador(){
        Pirata pirata = new Pirata(1, 1);
        Tesoro tesoro = new Tesoro(2, 3);
        Tablero tablero = new Tablero(pirata, tesoro);
        tablero.iniciar(5); 

        pirata.setContador(50);
        tablero.verificarEstadoJuego();

        assertEquals("DERROTA, LÍMITE DE MOVIMIENTOS ALCANZADO", tablero.getMensaje());
    }

    @Test 
    public void testDerrotaAhogado(){
        Pirata pirata = new Pirata(1, 1);
        Tesoro tesoro = new Tesoro(2, 3);
        Tablero tablero = new Tablero(pirata, tesoro);
        tablero.iniciar(5); 

        pirata.setY(pirata.getX()-1);
        tablero.verificarEstadoJuego();

        assertEquals("DERROTA, PIRATA AHOGADO", tablero.getMensaje());
    }
}
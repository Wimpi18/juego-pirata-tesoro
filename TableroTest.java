

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
}

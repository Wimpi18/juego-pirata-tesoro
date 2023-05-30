import java.util.Arrays;
/**
 * La clase Tablero se encarga de administrar al Pirata y al Tesoro, también cuenta con un 'n' para generar la matriz del tablero el cual
 * debe ser mayor o igual a 4, el mismo tablero se encarga de verificar este valor. Por último verifica el estado del juego
 * y genera un mensaje de acuerdo a dicho estado.
 * 
 * @author Maida Rojas Jairo Andree,  Morales Pinto Giulianno Alejandro, Orellana Vásquez Winsor Omar, Vallejos Delgadillo Mariana Andre
 * @version 1.0.0
 */
public class Tablero{
    
    private char [][] matriz;
    private int tamanio;
    private Pirata pirata;
    private Tesoro tesoro;
    private boolean juegoFinalizado;
    private String mensaje;

    /**
     * Constructor de la clase Tablero
     * 
     * @param pirata Se requiere un pirata para jugar una partida
     * @param tesoro Se requiere un tesoro el cual intentará encontrar el pirata 
     */
    public Tablero(int tamanio, Pirata pirata, Tesoro tesoro)
    {
        this.tamanio = tamanio;
        this.pirata = pirata;
        this.tesoro = tesoro;
        mensaje = null;
    }

    /**
     * Dado un 'n' se asignará al tamaño de la matriz para inicializar la matriz de caracteres con sus respectivos valores (AGUA, W, T, P)
     * 
     * @param n Tamaño de la matriz cuadrada a generar
     */
    public void iniciar(int n){
        this.tamanio = n;
        matriz = new char[n][n];
        for(int i = 1; i < n-1; i++){
            for(int j = 0; j < n-1; j++){
                matriz[i][j] = ' ';
            }
        }

        for(int i = 1, j = 1; i < n-1; i++, j++){
            if(j == 1){
                matriz[0][i] = matriz[i][0] = matriz[n-1-i][n-1] = matriz[n-1][n-1-i] = 'G';
            } else if(j == 2){
                matriz[0][i] = matriz[i][0] = matriz[n-1-i][n-1] = matriz[n-1][n-1-i] = 'U';
            } else{
                matriz[0][i] = matriz[i][0] = matriz[n-1-i][n-1] = matriz[n-1][n-1-i] = 'A';
                j = 0;
            }
        }

        if(pirata != null && tesoro != null){
            matriz[tesoro.getX()][tesoro.getY()] = 'T';
            matriz[pirata.getX()][pirata.getY()] = 'W';
        }

        matriz[0][0] = matriz[n-1][n-1] = 'A';
        matriz[0][n-1] = matriz[n-1][0] = 'P';
    }

    /**
     * Genera la matriz para imprimirse en consola
     */
    public String mostrar(){
        String muestra;

        String separador;
        String fila;

        muestra = "";
        separador = "";

        for(int i = 0 ; i < tamanio ; i++){
            separador += "+---";
        }
        separador += "+";

        for(int i = 0 ; i < tamanio ; i++){
            fila = "";

            for(int j = 0 ; j < tamanio; j++){
                fila += "| " + matriz[i][j] + " ";
            }
            fila += "|";
            muestra += separador + "\n" + fila + "\n";
        }

        muestra += separador;
        return muestra;
    }

    /**
     * Efectúa un "ciclo de juego" es decir: (1) Mueve al pirata (2) Verifica la situación o estado del juego según el movimiento anterior
     * (3) Actualiza los valores de la matriz
     */
    public void jugar(){
        pirata.moverPirata();
        verificarEstadoJuego();
        iniciar(tamanio);
    }

    /**
     * Verifica 4 estados de juego: (1) El pirata coincide con las mismas coordenadas que el tesoro, por lo tanto encuentra el tesoro 
     * (2) El pirata cae en alguno de los bordes de la matriz y por lo tanto se ahoga (3) El pirata se queda sin movimientos para hacer
     * (4) Ninguno de los anteriores 3 casos se efectuan
     */
    public void verificarEstadoJuego(){
        juegoFinalizado = true;
        if(Arrays.equals(pirata.getCoordenadas(), tesoro.getCoordenadas())){
            mensaje = "VICTORIA!!! TESORO ENCONTRADO!!!";
        } else if(pirata.getX() == 0 || pirata.getX() == tamanio-1 ||
        pirata.getY() == 0 || pirata.getY() == tamanio-1){
            mensaje = "DERROTA, PIRATA AHOGADO";
        } else if(pirata.getContador() >= 50){
            mensaje = "DERROTA, LÍMITE DE MOVIMIENTOS ALCANZADO";
        } else {
            juegoFinalizado = false;
        }
    }

    public boolean juegoFinalizado(){
        return juegoFinalizado;
    }

    public String getMensaje(){
        return mensaje;
    }
}
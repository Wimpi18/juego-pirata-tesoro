import java.util.Arrays;
import java.util.Random;
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
    private int n;
    private Pirata pirata;
    private Tesoro tesoro;
    private boolean juegoFinalizado;
    private Random rand;
    private String mensaje;
    private Graficador graficador;

    /**
     * Constructor de la clase Tablero
     * 
     * @param pirata Se requiere un pirata para jugar una partida
     * @param tesoro Se requiere un tesoro el cual intentará encontrar el pirata 
     */
    public Tablero(int N_Casillas){
        rand = new Random();
        this.n = N_Casillas;
        instanciarPirata_Tesoro();
        graficador = new Graficador(this);
        matriz = new char[this.n][this.n];
        mensaje = null;
    }

    public Tablero(Pirata pirata, Tesoro tesoro){
        this.pirata = pirata;
        this.tesoro = tesoro;
        graficador = new Graficador(this);
        mensaje = null;
    }

    private void instanciarPirata_Tesoro(){
        this.pirata = new Pirata(rand.nextInt(n-2) + 1, rand.nextInt(n-2) + 1);
        this.tesoro = new Tesoro(rand.nextInt(n-2) + 1, rand.nextInt(n-2) + 1);
        this.pirata.verificarPosicionesDistintas(this.tesoro, this.n);
    }

    /**
     * Dado un 'n' se asignará al tamaño de la matriz para inicializar la matriz de caracteres con sus respectivos valores (AGUA, W, T, P)
     * 
     * @param n Tamaño de la matriz cuadrada a generar
     */
    public void inicializar(int n){
        this.n = n;
        agregarEspacios();
        agregarBordes();
        agregarPirata_Tesoro();
    }

    private void agregarEspacios(){
        for(int i = 1; i < n-1; i++){
            for(int j = 0; j < n-1; j++){
                matriz[i][j] = ' ';
            }
        }
    }

    private void agregarBordes(){
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
        matriz[0][0] = matriz[n-1][n-1] = 'A';
        matriz[0][n-1] = matriz[n-1][0] = 'P';
    }

    private void agregarPirata_Tesoro(){
        if(pirata != null && tesoro != null){
            matriz[tesoro.getX()][tesoro.getY()] = 'T';
            matriz[pirata.getX()][pirata.getY()] = 'W';
        }
    }

    private void moverPirata(){
        matriz[pirata.getX()][pirata.getY()] = ' ';
        pirata.moverPirata();
        matriz[pirata.getX()][pirata.getY()] = 'W';
    }

    /**
     * Genera la matriz para imprimirse en consola
     */
    public String mostrar(){
        String resultado = graficador.mostrar();
        return resultado;
    }

    /**
     * Efectúa un "ciclo de juego" es decir: (1) Mueve al pirata (2) Verifica la situación o estado del juego según el movimiento anterior
     * (3) Actualiza los valores de la matriz
     */
    public void jugar(){
        moverPirata();
        verificarEstadoJuego();
        mostrar();
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
        } else if(pirata.getX() == 0 || pirata.getX() == n-1 ||
        pirata.getY() == 0 || pirata.getY() == n-1){
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

    public Pirata getPirata(){
        return pirata;
    }

    public int getN(){
        return n;
    }

    public char[][] getMatriz(){
        return matriz;
    }
}
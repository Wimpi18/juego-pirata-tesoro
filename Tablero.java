import java.util.Arrays;
/**
 * Write a description of class Tablero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tablero
{

    private char [][] matriz;
    private int n;
    private Pirata pirata;
    private Tesoro tesoro;
    private boolean juegoFinalizado;
    private String mensaje;

    /**
     * Constructor for objects of class Tablero
     */
    public Tablero(Pirata pirata, Tesoro tesoro)
    {
        this.pirata = pirata;
        this.tesoro = tesoro;
        mensaje = null;
    }

    String verificarn(int n){
        String mensaje;

        if(n >= 4){
            mensaje = null;
        }else{
            mensaje = "Valor de n invalido, n debe ser mayor o igual a 4";
        }

        return mensaje;
    }

    public void iniciar(int n){
        this.n = n;
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

    public String mostrar(){
        String muestra;

        String separador;
        String fila;

        muestra = "";
        separador = "";

        for(int i = 0 ; i < n ; i++){
            separador += "+---";
        }
        separador += "+";

        for(int i = 0 ; i < n ; i++){
            fila = "";

            for(int j = 0 ; j < n ; j++){
                fila += "| " + matriz[i][j] + " ";
            }
            fila += "|";
            muestra += separador + "\n" + fila + "\n";
        }

        muestra += separador;
        return muestra;
    }

    public void jugar(){
        pirata.moverPirata();
        verificarEstadoJuego();
        iniciar(n);
    }

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
}
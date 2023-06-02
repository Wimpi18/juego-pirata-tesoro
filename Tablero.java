import java.util.Arrays;

public class Tablero{
    private int tamanio;
    private Pirata pirata;
    private Tesoro tesoro;
    private boolean juegoFinalizado;
    private String mensaje;
    
    public Tablero(int tamanio, Pirata pirata, Tesoro tesoro)
    {
        this.tamanio = tamanio;
        this.pirata = pirata;
        this.tesoro = tesoro;
        mensaje = null;
    }

    public char[][] cargarMatriz(){
        char[][] matriz;
        
        matriz = new char[tamanio][tamanio];
        for(int i = 1; i < tamanio-1; i++){
            for(int j = 0; j < tamanio-1; j++){
                matriz[i][j] = ' ';
            }
        }

        for(int i = 1, j = 1; i < tamanio-1; i++, j++){
            if(j == 1){
                matriz[0][i] = matriz[i][0] = matriz[tamanio-1-i][tamanio-1] = matriz[tamanio-1][tamanio-1-i] = 'G';
            } else if(j == 2){
                matriz[0][i] = matriz[i][0] = matriz[tamanio-1-i][tamanio-1] = matriz[tamanio-1][tamanio-1-i] = 'U';
            } else{
                matriz[0][i] = matriz[i][0] = matriz[tamanio-1-i][tamanio-1] = matriz[tamanio-1][tamanio-1-i] = 'A';
                j = 0;
            }
        }

        if(pirata != null && tesoro != null){
            matriz[tesoro.getX()][tesoro.getY()] = 'T';
            matriz[pirata.getX()][pirata.getY()] = 'W';
        }

        matriz[0][0] = matriz[tamanio-1][tamanio-1] = 'A';
        matriz[0][tamanio-1] = matriz[tamanio-1][0] = 'P';
        
        return matriz;
    }

    public String mostrar(){
        String muestra, separador, fila;
        char[][] matriz;
        
        matriz = cargarMatriz();
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

    public void jugar(){
        pirata.moverPirata();
        verificarEstadoJuego();
    }

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
    
    public Pirata getPirata(){
        return pirata;
    }
    
    public Tesoro getTesoro(){
        return tesoro;
    }
}
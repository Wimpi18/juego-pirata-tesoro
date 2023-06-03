public class Graficador{
    private String muestra;
    private String separador;
    private Tablero tablero;
    public Graficador(Tablero tablero){
        this.tablero = tablero;
        this.separador = generarSeparador();
        this.muestra = "";
    }

    public String mostrar(){
        muestra = generarMuestra(tablero.getMatriz());
        System.out.println(muestra);
        System.out.println("Contador de movimientos " + tablero.getPirata().getContador() + "\n");
        try{
            Thread.sleep(1800);
        }
        catch (java.lang.InterruptedException ie){
            ie.printStackTrace();
        }
        return muestra;
    }

    private String generarSeparador(){
        String resultado = "";
        for(int i = 0 ; i < tablero.getN() ; i++){
            resultado += "+---";
        }
        resultado += "+";
        return resultado;
    }

    private String generarMuestra(char[][] matriz){
        String resultado = "";
        String fila;
        for(int i = 0 ; i < tablero.getN() ; i++){
            fila = "";
            for(int j = 0 ; j < tablero.getN() ; j++){
                fila += "| " + matriz[i][j] + " ";
            }
            fila += "|";
            resultado += separador + "\n" + fila + "\n";
        }
        resultado += separador;
        return resultado;
    }
}
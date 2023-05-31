import java.util.Random;

public class Posicionador
{
    public static void generarPosiciones(int[] posicion1, int[] posicion2, int tamanio){
        Random rand = new Random();
        posicion1 = new int[2];
        posicion2 = new int[2];
        
        posicion1[0] = rand.nextInt(tamanio-2) + 1;
        posicion1[1] = rand.nextInt(tamanio-2) + 1;
        posicion2[0] = rand.nextInt(tamanio-2) + 1;
        posicion2[1] = rand.nextInt(tamanio-2) + 1;

        while(posicion2[0] == posicion1[0] && posicion2[1] == posicion1[1]){
            posicion1[0] = rand.nextInt(tamanio-2) + 1;
            posicion1[1] = rand.nextInt(tamanio-2) + 1;
        }
    }
}

public class Verificador
{
    String verificarTamanio(int tamanio){
        String mensaje;
        
        if(tamanio >= 4){
            mensaje = null;
        }else{
            mensaje = "Valor de N invalido, N debe ser mayor o igual a 4";
        }
        return mensaje;
    }
}

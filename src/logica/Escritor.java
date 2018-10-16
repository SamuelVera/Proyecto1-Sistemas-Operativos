package logica;
import java.util.concurrent.Semaphore;
    //Clase Escritor(Cronometrador)
public class Escritor extends Thread{
    
    private int sleep;
    private Semaphore raceSema;
    private int[] contador;
    
    Escritor(Semaphore raceSema, int[] contador, int sleep){
        this.raceSema = raceSema;
        this.contador = contador;
        this.sleep = sleep;
    }
    
    
}

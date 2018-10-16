package logica;
import java.util.concurrent.Semaphore;
    //Clase de lector (Gerente)
public class Lector extends Thread{
    
    private int sleep;
    private Semaphore raceSema;
    private int[] contador;
    
    Lector(Semaphore raceSema, int[] contador, int sleep){
        this.raceSema = raceSema;
        this.contador = contador;
        this.sleep = sleep;
    }
    
}

package logica;

import java.util.concurrent.Semaphore;

public class Productor extends Thread{
    
    private Semaphore s;
    private int[] almacen = new int[1];
    
    Productor(Semaphore s, int[] c){
        this.s = s;
        almacen = c;
    }
}

package logica;

import java.util.concurrent.Semaphore;

public class Consumer extends Thread{
    
    private Semaphore s;
    
    Consumer(Semaphore s){
        this.s = s;
    }
    
    @Override
    public void run(){
        
    }
    
}

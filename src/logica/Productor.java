package logica;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Productor extends Thread{
    
    private Semaphore sP; //Semáforo de productores
    private Semaphore sC; //Semáforo consumidores
    private Semaphore sE; //Semáforo de exclusividad
    private Semaphore sI; //Semádoro para imprimir en la Interfaz
    private int apunta; //Apuntador al búffer
    private boolean val; //Valor que ingresa al búffer el proceso
    int sleep; //Tiempo de espera
    int prod; //Tipo de prodctor (0-Bat/1-Pan/2-Cab)
    
    Productor(Semaphore sP, Semaphore sC, Semaphore sE, int apunta, boolean val, Semaphore sI, int sleep, int prod){
        this.sP = sP;
        this.sC = sC;
        this.sE = sE;
        this.apunta = apunta;
        this.val = val;
        this.sI = sI;
        this.sleep = sleep;
        this.prod = prod;
    }
    
    @Override
    public void run(){
        while(true){
            if(this.prod == 0){
                try {
                //Productor de Baterías
                Thread.sleep(this.sleep);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                System.out.println("Hola produzco Baterías");
            }else if(this.prod == 1){ 
                try {
                //Productor de Pantallas
                Thread.sleep(this.sleep);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                System.out.println("Hola produzco Pantallas");
            }else if(this.prod == 2){ 
                try {
                //Productor de Cables
                Thread.sleep(this.sleep);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                System.out.println("Hola produzco Cables");
            }
        }
    }
    
}

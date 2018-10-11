package logica;

import java.util.concurrent.Semaphore;

public class Productor extends Thread{
    
    Almacen a;
    private Semaphore sP; //Semáforo de productores
    private Semaphore sC; //Semáforo consumidores
    private Semaphore sE; //Semáforo de exclusividad
    private Semaphore sI; //Semádoro para imprimir en la Interfaz
    private int apunta; //Apuntador al búffer
    private boolean val; //Valor que ingresa al búffer el proceso
    int sleep; //Tiempo de espera
    
    Productor(Almacen a, Semaphore sP, Semaphore sC, Semaphore sE, int apunta, boolean val, Semaphore sI, int sleep){
        this.a = a;
        this.sP = sP;
        this.sC = sC;
        this.sE = sE;
        this.apunta = apunta;
        this.val = val;
        this.sI = sI;
        this.sleep = sleep;
    }
    
    @Override
    public void run(){
        
    }
    
}

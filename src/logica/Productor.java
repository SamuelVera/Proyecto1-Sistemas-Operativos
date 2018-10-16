package logica;

import interfaz.Inicio;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Productor extends Thread{
    
        //Declaraciones para los productores
    private Semaphore sP; //Semáforo de productores
    private Semaphore sC; //Semáforo consumidores
    private Semaphore sE; //Semáforo de exclusividad
    private Semaphore sI; //Semádoro para imprimir en la Interfaz
    private boolean val; //Valor que ingresa al búffer el proceso
    private boolean run; //Se ejecuta o no
    int sleep; //Tiempo de espera
    int prod; //Tipo de prodctor (0-Bat/1-Pan/2-Cab/3-Ensamblador)
    
        //Constructor de los productores
    Productor(Semaphore sP, Semaphore sC, Semaphore sE, boolean val, Semaphore sI, int sleep, int prod, boolean run){
        this.sP = sP;
        this.sC = sC;
        this.sE = sE;
        this.val = val;
        this.sI = sI;
        this.sleep = sleep;
        this.prod = prod;
        this.run = run;
    }
    
        //Declaraciones para los ensambladores
    private Semaphore sPB; //Semáforo de productor de baterias
    private Semaphore sCB; //Semáforo de consumidor de baterias
    private Semaphore sEB; //Semáforo de exclusividad de baterías
    private Semaphore sPP; //Semáforo de productor de pantallas
    private Semaphore sCP; //Semáforo de consumidor de pantallas
    private Semaphore sEP; //Semáforo de exclusividad de pantallas
    private Semaphore sPC; //Semáforo de productor de cables
    private Semaphore sCC; //Semáforo de consumidor de cables
    private Semaphore sEC; //Semáforo de exclusividad de cables
    
        //Constructor del consumidor
    Productor(Semaphore sPB, Semaphore sCB, Semaphore sEB, //Semaforos respectivos de baterías 
            Semaphore sPP, Semaphore sCP, Semaphore sEP, //Semaforos respectivos de pantallas
            Semaphore sPC, Semaphore sCC, Semaphore sEC, //Semaforos respectivos de cables
            boolean val, Semaphore sI, int sleep, int prod, boolean run){ //Demás variables
        this.sPB = sPB; this.sCB = sCB; this.sEB = sEB; this.sPP = sPP; this.sCP = sCP;
        this.sEP = sEP; this.sPC = sPC; this.sCC = sCC; this.sEC = sEC; this.val = val;
        this.sI = sI; this.sleep = sleep; this.prod = prod; this.run = run;
    }
    
    public void setRun(boolean run){
        this.run = run;
    }
    
    @Override
    public void run(){
        while(this.run){
                //Ejecución de los productores
            if(this.prod == 0 || this.prod == 1 || this.prod == 2){
                try {
                        //Espera de producción
                    Thread.sleep(this.sleep);
                        //Verificar almacen lleno
                    sP.acquire();
                        //Sección de entrada
                    sE.acquire();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
                }
                    //Secciones críticas
                if(this.prod == 0){
                    
                    //Sección crítica
                        //Llenar un espacio del almacén de baterías
                    Main.aBat.setDat(Main.apuntPB, this.val);
                        //Mover el apuntador
                    Main.apuntPB = ((Main.apuntPB+1)%Main.aBat.getTam());
                        //Sección de salida
                    sE.release();
                        //Avisar nuevo espacio lleno en almacén
                    sC.release();
                    try {
                            //Imprimir por pantalla
                        sI.acquire();//SE
                        Inicio.bat.setText("Baterías: "+Main.aBat.getLlenos());//SC
                        sI.release();//SS
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    System.out.println("Produci una batería");
                    
                }else if(this.prod == 1){ 
                        //Llenar un espacio del almacén de pantallas
                    Main.aPan.setDat(Main.apuntPP, this.val);
                        //Mover el apuntador
                    Main.apuntPP = ((Main.apuntPP+1)%Main.aPan.getTam());
                        //Sección de salida
                    sE.release();
                        //Avisar nuevo espacio lleno en almacén
                    sC.release();
                    try {
                            //Imprimir por pantalla
                        sI.acquire();//SE
                        Inicio.pan.setText("Pantallas: "+Main.aPan.getLlenos());//SC
                        sI.release();//SS
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    System.out.println("Produci una pantalla");
                }else if(this.prod == 2){
                        //Llenar un espacio del almacén de baterías
                    Main.aCab.setDat(Main.apuntPC, this.val);
                        //Mover el apuntador
                    Main.apuntPC = ((Main.apuntPC+1)%Main.aCab.getTam());
                        //Sección de salida
                    sE.release();
                        //Avisar nuevo espacio lleno en almacén
                    sC.release();
                    try {
                            //Imprimir por pantalla
                        sI.acquire();//SE
                        Inicio.cab.setText("Cables: "+Main.aCab.getLlenos());//SC
                        sI.release();//SS
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("Produci un cable");
                }
            }else{  //Ejecución del ensamblador
                try {
                        //Verificar almacenes vacíos
                    sCB.acquire();
                    sCP.acquire();
                    sCC.acquire();
                    sCC.acquire();
                        //Sección de entrada
                    sEB.acquire();
                    sEP.acquire();
                    sEC.acquire();
                        //Sección crítica
                    Main.aBat.setDat(Main.apuntCB, this.val);
                    Main.aPan.setDat(Main.apuntCP, this.val);
                    Main.aCab.setDat(Main.apuntCC, this.val);
                    Main.apuntCB = (Main.apuntCB + 1) % Main.aBat.getTam();
                    Main.apuntCP = (Main.apuntCP + 1) % Main.aBat.getTam();
                    Main.apuntCC = (Main.apuntCC + 1) % Main.aBat.getTam();
                    Main.aCab.setDat(Main.apuntCC, this.val);
                    Main.apuntCC = (Main.apuntCC + 1) % Main.aBat.getTam();
                        //Sección de salida
                    sEB.release();
                    sEP.release();
                    sEC.release();
                        //Avisar nuevo espacio vacio
                    sPB.release();
                    sPP.release();
                    sPC.release();
                    sPC.release();
                        //Imprimir
                    sI.acquire();//SE
                    Inicio.bat.setText("Baterías: "+Main.aBat.getLlenos());
                    Inicio.pan.setText("Pantallas: "+Main.aPan.getLlenos());//SC
                    Inicio.cab.setText("Cables: "+Main.aCab.getLlenos());
                    sI.release();//SS
                    
                    System.out.println("Hora de empezar a producir un teléfono");
                    Thread.sleep(this.sleep);
                    System.out.println("Teléfono producido");
                    Main.tel++;//Nuevo teléfono producido
                    sI.acquire();//SE
                    Inicio.tel.setText("Teléfonos: "+Main.tel);
                    sI.release();//SS
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }
    
}

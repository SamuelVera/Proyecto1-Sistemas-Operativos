package logica;

import interfaz.Inicio;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumidor extends Thread{
    
    //Declaraciones para los ensambladores
    private final Semaphore sPB; //Semáforo de productor de baterias
    private final Semaphore sCB; //Semáforo de consumidor de baterias
    private final Semaphore sEB; //Semáforo de exclusividad de baterías
    private final Semaphore sPP; //Semáforo de productor de pantallas
    private final Semaphore sCP; //Semáforo de consumidor de pantallas
    private final Semaphore sEP; //Semáforo de exclusividad de pantallas
    private final Semaphore sPC; //Semáforo de productor de cables
    private final Semaphore sCC; //Semáforo de consumidor de cables
    private final Semaphore sEC; //Semáforo de exclusividad de cables
    private final Semaphore sEF; //Semáforo de exclusividad de las unidades despachables
    private final Semaphore sI; //Semádoro para imprimir en la Interfaz
    int sleep; //Tiempo de espera
    private boolean run = true;
    
    Consumidor(Semaphore sPB, Semaphore sCB, Semaphore sEB, //Semaforos respectivos de baterías 
            Semaphore sPP, Semaphore sCP, Semaphore sEP, //Semaforos respectivos de pantallas
            Semaphore sPC, Semaphore sCC, Semaphore sEC, //Semaforos respectivos de cables
            Semaphore sI, Semaphore sEF, int sleep){ //Demás variables
        
        this.sPB = sPB; this.sCB = sCB; this.sEB = sEB; this.sPP = sPP; this.sCP = sCP;
        this.sEP = sEP; this.sPC = sPC; this.sCC = sCC; this.sEC = sEC;
        this.sI = sI; this.sleep = sleep; this.sEF = sEF;
    }
    
    public void setRun(boolean a){
        this.run = a;
    }
    
    private void efectuarDespido(){
        Main.en--;
        Inicio.ensNum.setText("Productores de cables: "+Main.en);
    }
    
    @Override
    public void run(){
        while(this.run){
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
                Main.aBat.setDat(Main.apuntCB, false);
                Main.aPan.setDat(Main.apuntCP, false);
                Main.aCab.setDat(Main.apuntCC, false);
                Main.apuntCB = (Main.apuntCB + 1) % Main.aBat.getTam();
                Main.apuntCP = (Main.apuntCP + 1) % Main.aPan.getTam();
                Main.apuntCC = (Main.apuntCC + 1) % Main.aCab.getTam();
                Main.aCab.setDat(Main.apuntCC, false);
                Main.apuntCC = (Main.apuntCC + 1) % Main.aCab.getTam();
                    //Sección de salida
                sEB.release();
                sEP.release();
                sEC.release();
                    //Avisar nuevo espacio vacio
                sPB.release();
                sPP.release();
                sPC.release();
                sPC.release();
                Main.enProd++;
                    //Imprimir
                sI.acquire();//SE
                Inicio.bat.setText("Baterías: "+Main.aBat.getLlenos());
                Inicio.pan.setText("Pantallas: "+Main.aPan.getLlenos());//SC
                Inicio.cab.setText("Cables: "+Main.aCab.getLlenos());
                Inicio.enProd.setText("Teléfonos en producción: "+Main.enProd);
                sI.release();//SS
                Thread.sleep(this.sleep);
                sEF.acquire();//SE
                Main.tel++;//Nuevo teléfono producido
                sEF.release();//SS
                sI.acquire();//SE
                Main.enProd--;
                Inicio.enProd.setText("Teléfonos en producción: "+Main.enProd);
                Inicio.tel.setText("Teléfonos: "+Main.tel);//Imprimir en la interfaz
                sI.release();//SS
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
        this.efectuarDespido();
    }
    
    
    
}

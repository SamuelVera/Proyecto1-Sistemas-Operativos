package logica;

import interfaz.Inicio;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Productor extends Thread{
    
        //Declaraciones para los productores
    private final Semaphore sP; //Semáforo de productores
    private final Semaphore sC; //Semáforo consumidores
    private final Semaphore sE; //Semáforo de exclusividad
    private final Semaphore sI; //Semádoro para imprimir en la Interfaz
    private boolean run = true; //Está en ejecución
    private int sleep; //Tiempo de espera
    private int prod; //Tipo de prodctor (0-Bat/1-Pan/2-Cab/3-Ensamblador)
    
        //Constructor de los productores
    Productor(Semaphore sP, Semaphore sC, Semaphore sE, Semaphore sI, int sleep, int prod){
        this.sP = sP;
        this.sC = sC;
        this.sE = sE;
        this.sI = sI;
        this.sleep = sleep;
        this.prod = prod;
    }
    
    public void setRun(boolean a){
        this.run = a;
    }  

    private void efectuarDespido(int i){
        switch (i) {
            case 0:
                Main.pBat--;
                Inicio.prodBat1.setText("De baterías: "+Main.pBat);
                Main.pBatED--;
                Inicio.prodBatED.setText("Esperando para despedir: "+Main.pBatED);
                break;
            case 1:
                Main.pPan--;
                Inicio.prodPan1.setText("De pantallas: "+Main.pPan);
                Main.pPanED--;
                Inicio.prodPanED.setText("Esperando para despedir: "+Main.pPanED);
                break;
            case 2:
                Main.pCab--;
                Inicio.prodCab1.setText("De cables: "+Main.pCab);
                Main.pCabED--;
                Inicio.prodCabED.setText("Esperando para despedir: "+Main.pCabED);
                break;
            default:
                break;
        }
    }
    
    @Override
    public void run(){
        while(this.run){
                //Ejecución de los productores
            try {
                    //Verificar almacen lleno
                sP.acquire();
                    //Espera de producción
                Thread.sleep(this.sleep);
                    //Sección de entrada
                sE.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
                //Secciones críticas
            switch (this.prod) {
                case 0:
                            //Sección crítica
                        //Llenar un espacio del almacén de baterías
                    Main.aBat.setDat(Main.apuntPB, true);
                        //Mover el apuntador
                    Main.apuntPB = ((Main.apuntPB+1)%Main.aBat.getTam());
                        //Avisar nuevo espacio lleno en almacén
                    sC.release();
                        //Sección de salida
                    sE.release();
                    try {
                            //Imprimir por pantalla
                        sI.acquire();//SE
                        Inicio.bat.setText(""+Main.aBat.getLlenos());//SC
                        sI.release();//SS
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 1: 
                        //Llenar un espacio del almacén de pantallas
                    Main.aPan.setDat(Main.apuntPP, true);
                        //Mover el apuntador
                    Main.apuntPP = ((Main.apuntPP+1)%Main.aPan.getTam());
                        //Avisar nuevo espacio lleno en almacén
                    sC.release();
                        //Sección de salida
                    sE.release();
                    try {
                            //Imprimir por pantalla
                        sI.acquire();//SE
                        Inicio.pan.setText(""+Main.aPan.getLlenos());//SC
                        sI.release();//SS
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 2:
                        //Llenar un espacio del almacén de baterías
                    Main.aCab.setDat(Main.apuntPC, true);
                        //Mover el apuntador
                    Main.apuntPC = ((Main.apuntPC+1)%Main.aCab.getTam());
                        //Avisar nuevo espacio lleno en almacén
                    sC.release();
                        //Sección de salida
                    sE.release();
                try {
                        //Imprimir por pantalla
                    sI.acquire();//SE
                    Inicio.cab.setText(""+Main.aCab.getLlenos());//SC
                    sI.release();//SS
                } catch (InterruptedException ex) {
                    Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            default:
                break;
            }
        }
        this.efectuarDespido(this.prod);
    }
}

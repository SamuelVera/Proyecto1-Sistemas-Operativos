package logica;
import interfaz.Inicio;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

    //Clase Escritor(Cronometrador)
public class Escritor extends Thread{
    
    private int sleep;
    private Semaphore raceSema, ceroSema, ceroSema2;
    private int[] contador;
    private int diasD;
    
    public Escritor(Semaphore raceSema, Semaphore ceroSema, Semaphore ceroSema2, int[] contador, int sleep, int diasD){
        this.raceSema = raceSema;
        this.ceroSema = ceroSema;
        this.ceroSema2 = ceroSema2;
        this.contador = contador;
        this.sleep = sleep;
        this.diasD = diasD;
    }
    
    @Override
    public void run(){
        while(true){
            try {
                
                    //Esperar todo el día menos la última 1.5 horas
                Thread.sleep(this.sleep*15/16);
                
                raceSema.acquire(); //Sección de entrada al contador
                Inicio.crono.setText("Está revisando el contador");
                if(contador[0] == 0){
                    raceSema.release();
                    Inicio.crono.setText("Está esperando por el gerente a despachar");
                    ceroSema.acquire(); //Esperar por el gerente para coherencia de datos
                    Thread.sleep(this.sleep/16); //Esperar 1.5 horas para reiniciar el contador
                    raceSema.acquire();
                    contador[0] = this.diasD; //Reiniciar contador
                    raceSema.release();
                    ceroSema2.release();
                }else{
                    raceSema.release();
                    Inicio.crono.setText("Está disminuyendo el contador");
                    Thread.sleep(this.sleep/16); //Esperar 1.5 horas para disminuir contador
                    raceSema.acquire();
                    contador[0]--;
                    raceSema.release();
                    raceSema.release();//Sección de salida
                }
                
                    //Impresiones
                Inicio.diasD.setText("Días para el despacho: "+contador[0]);
                Inicio.crono.setText("Está dormido");
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
}

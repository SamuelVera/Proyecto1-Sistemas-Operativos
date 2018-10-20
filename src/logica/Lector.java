package logica;
import interfaz.Inicio;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
    //Clase de lector (Gerente)
public class Lector extends Thread{
    
    private int sleep;
    private Semaphore raceSema, ceroSema, ceroSema2, sEF;
    private int[] contador;
    
    Lector(Semaphore raceSema, Semaphore ceroSema, Semaphore sEF, Semaphore ceroSema2,int[] contador, int sleep){
        this.raceSema = raceSema;
        this.ceroSema = ceroSema;
        this.ceroSema2 = ceroSema2;
        this.sEF = sEF;
        this.contador = contador;
        this.sleep = sleep;
    }
    
    @Override
    public void run(){
        while(true){
            
            try {
                raceSema.acquire(); //Sección de entrada al contador
                if(contador[0] != 0){ //Comprobar contador (SC)
                    Inicio.geren.setText("Revisando el contador");
                    raceSema.release(); //Sección de salida
                    Random rand = new Random();
                    long r = rand.nextLong(); //Elegir tiempo para dormir
                    if(r > 4){ //Si va a dormir menos de 6 horas filtra
                        r = 4;
                    }else if(r < (4/3)){ //Si va a dormir más de 18 horas filtra
                        r = 4/3;
                    }
                    Inicio.geren.setText("Está dormido");
                    Thread.sleep(this.sleep/r); //Dormir el tiempo calculado
                }else{
                    Inicio.geren.setText("Despachando los teléfonos");
                    int desp;
                    sEF.acquire(); //SE
                    desp = Main.tel;
                    Main.tel = 0; //Despachar los teléfonos
                    Inicio.tel.setText("Por despachar: "+Main.tel+" Teléfonos");
                    sEF.release(); //SS
                    ceroSema.release(); //Liberar contador de días al cronometrador
                    raceSema.release(); //Liberar semáforo para que ensambladores añadan teléfonos
                    Inicio.despacho.setText("Último despacho: "+desp+" Teléfonos");
                    ceroSema2.acquire();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}

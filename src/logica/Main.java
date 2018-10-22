package logica;

import interfaz.Inicio;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Main {
    
        //Arreglo con los datos
    public int[] data;
    
    public static int pBat;//Cantidad de productores de baterías
    public static int pPan;//Cantidad de productores de pantallas
    public static int pCab;//Cantidad de productores de cables
    public static int en;//Cantidad de ensambladores
    
    public static int pBatED;//Productores de baterías esperando por liquidación
    public static int pPanED;//Productores de pantallas esperando por liquidación
    public static int pCabED;//Productores de cables esperando por liquidación
    public static int enED;//Ensambladores esperando por liquidación
    
        //Almacenes
    public static Almacen aBat;//Almacen de Baterias
    public static Almacen aPan;//Almacen de Pantallas
    public static Almacen aCab;//Almacen de Cables
    public static int tel;//Teléfonos producidos
    public static int enProd = 0;//Teléfonos en producción
    
        //Semáforos
    private Semaphore semaProdB;//Semáforo de productores de Baterías
    private Semaphore semaConsB;//Semáforo de consumidor de Baterías
    private Semaphore semaExB;//Semáforo de exclusividad almacen de Baterías
    private Semaphore semaProdP;//Semáforo de productores de Pantallas
    private Semaphore semaConsP;//Semáforo de consumidor de Pantallas
    private Semaphore semaExP;//Semáforo de exclusividad del almacen de Pantallas
    private Semaphore semaProdC;//Semáforo de productores de Cables
    private Semaphore semaConsC;//Semáforo de consumidor de Cables
    private Semaphore semaExC;//Semáforo de exclusividad del almacen de Cables
    private Semaphore semaImp;//Semáforo de exclusividad al imprimir
    private Semaphore sEF;//Semáforo de exclusividad de unidades finales
    
        //Apuntadores
    public static int apuntPB;//Apuntar al almacen de Baterías para producir
    public static int apuntPP;//Apuntar al almacen de Pantallas para producir
    public static int apuntPC;//Apuntar al almacen de Cables para producir
    public static int apuntCB;//Apuntar al almacen de Baterías para consumir
    public static int apuntCP;//Apuntar al almacen de Pantallas para consumir
    public static int apuntCC;//Apuntar al almacen de Cables para consumir
    
        //Lista para seguir pista de los procesor
    private LinkedList lBat = new LinkedList();
    private LinkedList lPan = new LinkedList();
    private LinkedList lCab = new LinkedList();
    private LinkedList lEn = new LinkedList();
    
        //Cerrar hilo
    public void closeT(int tipo){
        if(tipo == 0 && this.lBat.peekLast() != null){
            Productor p = (Productor)this.lBat.removeLast();
            p.setRun(false);
            Main.pBatED++;
            Inicio.prodBatED.setText("Esperando para despedir: "+Main.pBatED);
        }else if(tipo == 1 && this.lPan.peekLast() != null){
            Productor p = (Productor)this.lPan.removeLast();
            p.setRun(false);
            Main.pPanED++;
            Inicio.prodPanED.setText("Esperando para despedir: "+Main.pPanED);
        }else if(tipo == 2 && this.lCab.peekLast() != null){
            Productor p = (Productor)this.lCab.removeLast();
            p.setRun(false);
            Main.pCabED++;
            Inicio.prodCabED.setText("Esperando para despedir: "+Main.pCabED);
        }else if(tipo == 3 && this.lEn.peekLast()!= null){
            Consumidor p = (Consumidor)this.lEn.removeLast();
            p.setRun(false);
            Main.enED++;
            Inicio.ensED.setText("Esperando para despedir: "+Main.enED);
        }
    }
    
        //Nuevo hilo
    public void newT(int tipo){
        switch (tipo) {
            case 0:
                {
                    Productor p = new Productor(this.semaProdB,this.semaConsB,this.semaExB,this.semaImp,this.data[0],0);
                    this.lBat.addFirst(p);
                    p.start();
                    break;
                }
            case 1:
                {
                    Productor p = new Productor(this.semaProdP,this.semaConsP,this.semaExP,this.semaImp,(this.data[0]*2),1);
                    this.lPan.addFirst(p);
                    p.start();
                    break;
                }
            case 2:
                {
                    Productor p = new Productor(this.semaProdC,this.semaConsC,this.semaExC,this.semaImp,this.data[0],2);
                    this.lCab.addFirst(p);
                    p.start();
                    break;
                }
            case 3:
                {
                    Consumidor p = new Consumidor(this.semaProdB,this.semaConsB,this.semaExB,
                            this.semaProdP,this.semaConsP,this.semaExP,
                            this.semaProdC,this.semaConsC,this.semaExC,
                            this.semaImp,this.sEF,(this.data[0]*2));
                    this.lEn.addFirst(p);
                    p.start();
                    break;
                }
            default:
                break;
        }
    }
    
    public void terminate() throws IOException{
        this.data[0] = this.data[0]/1000;
        RandomAccess.saveData(this.data);
        RandomAccess.closeF();
    }
    
    public void initiate() throws IOException{
        
        File f = new File("data.txt");
        this.data = new int[13];
        
        if(!f.exists()){//Datos a inicializarse en la primera ejecución
            RandomAccess.createF(f);
            
            this.data[0] = 100000; //100 segundos (en ms).
            this.data[1] = 2; //Productores de baterias iniciales
            this.data[2] = 3; //Productores de patalla iniciales
            this.data[3] = 1; //Productores de cables iniciales
            this.data[4] = 4; //Máximo de productores de baterías
            this.data[5] = 8; //Máximo de productores de pantallas
            this.data[6] = 3; //Máximo de productores de cables
            this.data[7] = 25; //Tamaño del almacen de baterías
            this.data[8] = 30; //Tamaño del almacen de pantallas
            this.data[9] = 35; //Tamaño del almacen de cables
            this.data[10] = 2; //Cantidad inicial de ensambladores
            this.data[11] = 5; //Cantidad máxima de ensambladores 
            this.data[12] = 15; //Días entre despachos
            
        }else{
            RandomAccess.createF(f);
            this.data = RandomAccess.loadData(this.data);
            
                //Validaciones de datos
            if(this.data[0] <= 0){ this.data[0] = 100000; //Tiempo
            }else{ this.data[0] = this.data[0]*1000; } //Pasar de seg a miliseg
            if(this.data[1] <= 0){ this.data[1] = 2; } //Productores de baterias iniciales
            if(this.data[2] <= 0){ this.data[2] = 3; } //Productores de patalla iniciales
            if(this.data[3] <= 0){ this.data[3] = 1; } //Productores de cables iniciales
            if(this.data[4] <= 0){ //Máximo de productores de baterías
                this.data[4] = 4;
            }
            if(this.data[4] <= this.data[1]){
                this.data[4] = this.data[1]+2;
            }
            if(this.data[5] <= 0){ //Máximo de productores de pantallas
                this.data[5] = 8;
            }
            if(this.data[5] <= this.data[2]){
                this.data[5] = this.data[2]+2;
            }
            if(this.data[6] <= 0){ //Máximo de productores de cables
                this.data[6] = 3;
            }
            if(this.data[6] <= this.data[3]){
                this.data[6] = this.data[3]+2;
            }
            if(this.data[7] <= 1){ //Tamaño del almacen de baterías
                this.data[7] = 25;
            }
            if(this.data[8] <= 1){ //Tamaño del almacen de pantallas
                this.data[8] = 30;
            }
            if(this.data[9] <= 2){ //Tamaño del almacen de cables
                this.data[9] = 35;
            }
            if(this.data[10] <= 0){ //Cantidad inicial de ensambladores
                this.data[10] = 2;
            }
            if(this.data[11] <= 0){ //Cantidad máxima de ensambladores 
                this.data[11] = 5;
            }
            if(this.data[11] <= this.data[10]){
                this.data[11] = this.data[10]+2;
            }
            if(this.data[12] <= 0){ //Cantidad de días entre despachos
                this.data[12] = 15;
            }
        }
        
        Inicio.prodBat1.setText("De baterías: "+this.data[1]);
        Main.pBat = this.data[1];
        Inicio.prodPan1.setText("De pantallas: "+this.data[2]);
        Main.pPan = this.data[2];
        Inicio.prodCab1.setText("De cables: "+data[3]);
        Main.pCab = this.data[3];
        Inicio.ensNum1.setText("Contratados: "+this.data[10]);
        Main.en = this.data[10];
        Inicio.diasD.setText("Días para el despacho: "+this.data[12]);
        
            //Crear almacenes
        Main.aBat = new Almacen(data[7]);
        Main.aPan = new Almacen(data[8]);
        Main.aCab = new Almacen(data[9]);
        
            //Crear semáforos
        this.semaProdB = new Semaphore(this.data[7]);
        this.semaConsB = new Semaphore(0);
        this.semaExB = new Semaphore(1);
        this.semaProdP = new Semaphore(this.data[8]);
        this.semaConsP = new Semaphore(0);
        this.semaExP = new Semaphore(1);
        this.semaProdC = new Semaphore(this.data[9]);
        this.semaConsC = new Semaphore(0);
        this.semaExC = new Semaphore(1);
        this.semaImp = new Semaphore(1);
        this.sEF = new Semaphore(1);
        
            //Inicializar apuntadores
        Main.apuntPB = 0;
        Main.apuntCB = 0;
        Main.apuntPP = 0;
        Main.apuntCP = 0;
        Main.apuntPC = 0;
        Main.apuntCC = 0;
        
                //Crear Hilos
            //Productores de Baterías
        for(int i=0;i<this.pBat;i++){
            Productor p = new Productor(this.semaProdB,this.semaConsB,this.semaExB,this.semaImp,this.data[0],0);
            p.start();
            this.lBat.addFirst(p);
        }
            //Productores de pantallas
        for(int i=0;i<this.pPan;i++){
            Productor p = new Productor(this.semaProdP,this.semaConsP,this.semaExP,this.semaImp,(this.data[0]*2),1);
            p.start();
            this.lPan.addFirst(p);
        }
            //Productores de Cables
        for(int i=0;i<this.pCab;i++){
            Productor p = new Productor(this.semaProdC,this.semaConsC,this.semaExC,this.semaImp,this.data[0],2);
            p.start();
            this.lCab.addFirst(p);
        }
            //Ensambladores
        for(int i=0;i<this.en;i++){
            Consumidor p = new Consumidor(this.semaProdB,this.semaConsB,this.semaExB,
            this.semaProdP,this.semaConsP,this.semaExP,
            this.semaProdC,this.semaConsC,this.semaExC,
            this.semaImp,this.sEF,(this.data[0]*2));
            p.start();
            this.lEn.addFirst(p);
        }
            //Contador de días
        int[] contador = new int[]{this.data[12]}; //Contador de días
        Semaphore raceSema = new Semaphore(1); //Exclusividad para acceder al co
        Semaphore semaSinc = new Semaphore(0); //Coherencia de datos del contador de teléfonos
        Semaphore ceroSema2 = new Semaphore(0); 
            //Cronometrador
        Escritor e = new Escritor(raceSema, semaSinc, ceroSema2, contador, this.data[0], this.data[12]);
        e.start();
            //Gerente
        Lector l = new Lector(raceSema, semaSinc, this.sEF, ceroSema2, contador, this.data[0]);
        l.start();
    }
}

package logica;

import interfaz.Inicio;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Main {
    
        //Arreglo con los datos
    public int[] data;
    
    public int pBat; //Cantidad de productores de baterías
    public int pPan; //Cantidad de productores de pantallas
    public int pCab; //Cantidad de productores de cables
    public int en; //Cantidad de ensambladores
    
        //Almacenes
    public static Almacen aBat;//Almacen de Baterias
    public static Almacen aPan;//Almacen de Pantallas
    public static Almacen aCab;//Almacen de Cables
    
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
    
        //Apuntadores
    private int apuntPB;//Apuntar al almacen de Baterías para producir
    private int apuntPP;//Apuntar al almacen de Pantallas para producir
    private int apuntPC;//Apuntar al almacen de Cables para producir
    private int apuntCB;//Apuntar al almacen de Baterías para consumir
    private int apuntCP;//Apuntar al almacen de Pantallas para consumir
    private int apuntCC;//Apuntar al almacen de Cables para consumir
    
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
                if(this.data[4] <= this.data[1]){this.data[4] = this.data[1]+2;}
            }
            if(this.data[5] <= 0){ //Máximo de productores de pantallas
                this.data[5] = 8;
                if(this.data[5] <= this.data[2]){ this.data[5] = this.data[2]+2; }
            }
            if(this.data[6] <= 0){ //Máximo de productores de cables
                this.data[6] = 3;
                if(this.data[6] <= this.data[3]){ this.data[6] = this.data[3]+2; }
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
                if(this.data[11] <= this.data[10]){ this.data[11] = this.data[10]+2; }
            }
            if(this.data[12] <= 0){ //Cantidad de días entre despachos
                this.data[12] = 15;
            }
        }
        
        Inicio.prodBat.setText("Productores de baterías: "+this.data[1]);
        this.pBat = this.data[1];
        Inicio.prodPan.setText("Productores de pantallas: "+this.data[2]);
        this.pPan = this.data[2];
        Inicio.prodCab.setText("Productores de cables: "+data[3]);
        this.pCab = this.data[3];
        Inicio.ensNum.setText("Ensambladores: "+this.data[10]);
        this.en = this.data[10];
        Inicio.j.setText("Días entre despachos: "+this.data[12]);
        
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
        
            //Inicializar apuntadores
        this.apuntPB = 0;
        this.apuntCB = 0;
        this.apuntPP = 0;
        this.apuntCP = 0;
        this.apuntPC = 0;
        this.apuntCC = 0;
        
        
                //Crear Hilos
            //Productores de Baterías
        for(int i=0;i<this.pBat;i++){
            Productor p =new Productor(this.semaProdB,this.semaConsB,this.semaExB,this.apuntPB,true,this.semaImp,this.data[0],0);
            p.start();
        }
            //Productores de pantallas
        for(int i=0;i<this.pPan;i++){
            Productor p =new Productor(this.semaProdP,this.semaConsP,this.semaExP,this.apuntPP,true,this.semaImp,(this.data[0]*2),1);
            p.start();
        }
            //Productores de Cables
        for(int i=0;i<this.pCab;i++){
            Productor p =new Productor(this.semaProdC,this.semaConsC,this.semaExC,this.apuntPC,true,this.semaImp,this.data[0],2);
            p.start();
        }
        
    }
}

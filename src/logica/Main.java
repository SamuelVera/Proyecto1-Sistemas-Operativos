package logica;

import interfaz.Inicio;
import java.io.File;
import java.io.IOException;

public class Main {
    
    private final int[] tiempo = new int[1]; //Tiempo que dura el día
    public final int[] productoresIniBat = new int[1]; //Cantidad inicial de productores de baterías
    public final int[] productoresIniPan = new int[1]; //Cantidad inicial de productores de pantallas
    public final int[] productoresIniCab = new int[1]; //Cantidad inicial de productores de cables
    public final int[] productoresMaxBat = new int[1]; //Cantidad máxima de productores de baterías
    public final int[] productoresMaxPan = new int[1]; //Cantidad máxima de productores de pantallas
    public final int[] productoresMaxCab = new int[1]; //Cantidad máxima de productores de cables
    public final int[] maxBat = new int[1]; //Cantidad máxima de baterías en el almacen
    public final int[] maxPan = new int[1]; //Cantidad máxima de pantallas en el almacen
    public final int[] maxCab = new int[1]; //Cantidad máxima de cables en el almacen
    public final int[] iniEnsambla = new int[1]; //Cantidad inicial de ensambladores
    public final int[] maxEnsambla = new int[1]; //Cantidad máxima de ensambladores 
    public final int[] diasDes = new int [1]; //Días entre despachos
    
    public int pBat; //Cantidad de productores de baterías
    public int pPan; //Cantidad de productores de pantallas
    public int pCab; //Cantidad de productores de cables
    public int en; //Cantidad de ensambladores
    
    public void terminate() throws IOException{
        int[] data = new int[13];
        
        data[0] = this.tiempo[0]/1000;
        data[1] = this.productoresIniBat[0];
        data[2] = this.productoresIniPan[0];
        data[3] = this.productoresIniCab[0];
        data[4] = this.productoresMaxBat[0];
        data[5] = this.productoresMaxPan[0];
        data[6] = this.productoresMaxCab[0];
        data[7] = this.maxBat[0];
        data[8] = this.maxPan[0];
        data[9] = this.maxCab[0];
        data[10] = this.iniEnsambla[0];
        data[11] = this.maxEnsambla[0];
        data[12] = this.diasDes[0];
        
        RandomAccess.saveData(data);
        RandomAccess.closeF();
    }
    
    public void execute() throws IOException{
        
        int[] data = new int[13];
        
        File f = new File("data.txt");
        
        if(!f.exists()){//Datos a inicializarse en la primera ejecución
            RandomAccess.createF(f);
            
            data[0] = 100000; //100 segundos (en ms).
            data[1] = 2; //Productores de baterias iniciales
            data[2] = 3; //Productores de patalla iniciales
            data[3] = 1; //Productores de cables iniciales
            data[4] = 4; //Máximo de productores de baterías
            data[5] = 8; //Máximo de productores de pantallas
            data[6] = 3; //Máximo de productores de cables
            data[7] = 25; //Tamaño del almacen de baterías
            data[8] = 30; //Tamaño del almacen de pantallas
            data[9] = 35; //Tamaño del almacen de cables
            data[10] = 2; //Cantidad inicial de ensambladores
            data[11] = 5; //Cantidad máxima de ensambladores 
            data[12] = 15; //Días entre despachos
            
        }else{
            RandomAccess.createF(f);
            data = RandomAccess.loadData(data);
            
                //Validaciones de datos
            if(data[0] <= 0){ data[0] = 100000; //Tiempo
            }else{ data[0] = data[0]*1000; } //Pasar de seg a miliseg
            if(data[1] <= 0){ data[1] = 2; } //Productores de baterias iniciales
            if(data[2] <= 0){ data[2] = 3; } //Productores de patalla iniciales
            if(data[3] <= 0){ data[3] = 1; } //Productores de cables iniciales
            if(data[4] <= 0){ //Máximo de productores de baterías
                data[4] = 4;
                if(data[4] <= data[1]){data[4] = data[1]+2;}
            }
            if(data[5] <= 0){ //Máximo de productores de pantallas
                data[5] = 8;
                if(data[5] <= data[2]){ data[5] = data[2]+2; }
            }
            if(data[6] <= 0){ //Máximo de productores de cables
                data[6] = 3;
                if(data[6] <= data[3]){ data[6] = data[3]+2; }
            }
            if(data[7] <= 1){ //Tamaño del almacen de baterías
                data[7] = 25;
            }
            if(data[8] <= 1){ //Tamaño del almacen de pantallas
                data[8] = 30;
            }
            if(data[9] <= 2){ //Tamaño del almacen de cables
                data[9] = 35;
            }
            if(data[10] <= 0){ //Cantidad inicial de ensambladores
                data[10] = 2;
            }
            if(data[11] <= 0){ //Cantidad máxima de ensambladores 
                data[11] = 5;
                if(data[11] <= data[10]){ data[11] = data[10]+2; }
            }
            if(data[12] <= 0){ //Cantidad de días entre despachos
                data[12] = 15;
            }
        }
        
        this.tiempo[0] = data[0]; //100 segundos (en ms).
        this.productoresIniBat[0] = data[1]; //Productores de baterias iniciales
        this.pBat = data[1];
        Inicio.prodBat.setText("Productores de baterías: "+data[1]);
        this.productoresIniPan[0] = data[2]; //Productores de patalla iniciales
        this.pPan = data[2];
        Inicio.prodPan.setText("Productores de pantallas: "+data[2]);
        this.productoresIniCab[0] = data[3]; //Prodcutores de cables iniciales
        this.pCab = data[3];
        Inicio.prodCab.setText("Productores de cables: "+data[3]);
        this.productoresMaxBat[0] = data[4]; //Máximo de productores de baterías
        this.productoresMaxPan[0] = data[5]; //Máximo de productores de pantallas
        this.productoresMaxCab[0] = data[6]; //Máximo de productores de cables
        this.maxBat[0] = data[7]; //Tamaño del almacen de baterías
        this.maxPan[0] = data[8]; //Tamaño del almacen de pantallas
        this.maxCab[0] = data[9]; //Tamaño del almacen de cables
        this.iniEnsambla[0] = data[10]; //Cantidad inicial de ensambladores
        this.en = data[10];
        Inicio.ensNum.setText("Ensambladores: "+data[10]);
        this.maxEnsambla[0] = data[11]; //Cantidad máxima de ensambladores 
        this.diasDes[0] = data[12]; //Días entre despachos
        Inicio.j.setText("Días entre despachos: "+data[12]);
            //Crear hilos
        
    }
}

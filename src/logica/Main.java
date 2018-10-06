package logica;

import interfaz.Inicio;
import java.io.File;
import java.io.IOException;

public class Main {
    
    public final int[] productores = new int[1];
    public final int[] tiempo = new int[1];
    public final int[] pantallas = new int[1];
    public final int[] baterias = new int[1];
    
    public void terminate() throws IOException{
        int[] data = new int[4];
        
        data[0] = productores[0];
        data[1] = tiempo[0];
        data[2] = pantallas[0];
        data[3] = baterias[0];
        
        RandomAccess.saveData(data);
        RandomAccess.closeF();
    }
    
    public void execute() throws IOException{
        
        int[] data = new int[4];
        
        File f = new File("data.txt");
        
        if(!f.exists()){
            RandomAccess.createF(f);
            for(int i=0;i<data.length;i++){
                if(i==1){
                    data[i]=100000;
                }else{
                    data[i]=0;
                }
            }
        }else{
            RandomAccess.createF(f);
            data = RandomAccess.loadData();
            
            if(data[0] < 0 || data[0] > 4){
                System.out.println("Error de data, seteando productores a 1/Data error, setting productors to 1");
                data[0] = 1;
            }
            if(data[1] < 0){
                System.out.println("Error de data, seteando tiempo de ejecución a 100 segundos/Data error, setting executing time to 100 seconds");
                data[1] = 100000;
            }
            if(data[2] < 0 || data[2] > 20){
                System.out.println("Error de data, seteando pantallas a 0/Data error, setting screens to 0");
                data[2] = 0;
            }
            if(data[3] < 0 || data[3] > 20){
                System.out.println("Error de data, seteando baterías a 0/Data error, setting batteries to 0");
                data[3] = 0;
            }
        }
        
        this.productores[0] = data[0];
        this.tiempo[0] = data[1];
        this.pantallas[0] = data[2];
        this.baterias[0] = data[3];
        
        Inicio.text1.setText("Productores: "+data[0]);
        Inicio.text3.setText("Pantallas: "+data[2]);
        Inicio.text4.setText("Baterías: "+data[3]);
        Inicio.text5.setText(""+(data[1]/1000)+" s");
        
            //Crear hilos
        for(int i=0;i<productores[0];i++){
            
        }
    }
}

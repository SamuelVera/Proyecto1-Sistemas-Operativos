package logica;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;

public class RandomAccess {
    
    private static RandomAccessFile flujo;
    
    public static void createF(File f) throws IOException{
            //Verificar si es un archivo
        if(f.exists() && !f.isFile()){
            throw new IOException(f.getName() + " no es un archivo");
        }
            //Crear Flujo para acceder al archivo
        flujo = new RandomAccessFile(f, "rw");
    }
    
        //Cerrar flujo
    public static void closeF() throws IOException{
        flujo.close();
    }
    
        //Respaldar la información
    public static void saveData(int[] data) throws IOException{
        String s = "";
        
        for(int i=0;i<data.length;i++){
            s += String.valueOf(data[i]);
            s += "/";
        }
        
        System.out.println(String.valueOf(s));
        flujo.seek(0);
        flujo.writeChars(s);
    }
    
        //Extraer toda la información del registro
    public static int[] loadData(int[] data) throws IOException{
        
        for(int i=0;i<data.length;i++){
            data[i] = 0;
        }
        
        int s;
        LinkedList aux = new LinkedList();
        
            //Leer string del .txt y transformar a un char array
        for(int i=0;i<flujo.length();i++){
            s = flujo.readByte();
            if(s >= 47 && s < 58){
                aux.addLast(s);
            }
        }
        
        Object[] aux3 = aux.toArray();
        int aux2 = 0; //Apuntador al int[]
        double auxmult = 0.1; //Posicionador de cero
        
        for(int i=0;i<aux3.length;i++){
            
            if(((Integer)aux3[i]) > 47 && ((Integer)aux3[i]) < 58){
                
                for(int j=i;j<aux3.length;j++){
                    if(((Integer)aux3[j]) == 47){
                        break;
                    }
                    auxmult *= 10;
                }
                data[aux2] += Character.getNumericValue((Integer)aux3[i])*auxmult;
                auxmult = 0.1; //Reiniciar posicionador
            }else if(((Integer)aux3[i]) == 47){
                aux2++;
            }
            
        }
        
        for(int i=0;i<data.length;i++){
        }
        
        return data;
    }
}
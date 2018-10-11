package logica;

public class Almacen {
    
    private int tam;
    private boolean[] vec;
    
        //Constructor del almacen
    public Almacen(int tam){
        this.tam = tam;
        vec = new boolean[tam];
    }
    
        //Obtener tamaño del búffer
    public int getTam(){
        return this.tam;
    }
    
        //Obtener dato del búffer
    public boolean getDat(int pos){
        return vec[pos];
    }
    
        //Ingresar dato al búffer
    public void setDat(int pos, boolean v){
        vec[pos] = v;
    }
    
        //Espacios llenos del almacen
    public int getLlenos(){
        int ret=0;
        for(int i=0;i<vec.length;i++){
            if(vec[i] == true){
                ret++;
            }
        }
        return ret;
    }
    
}

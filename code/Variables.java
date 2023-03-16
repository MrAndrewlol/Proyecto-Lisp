import java.util.ArrayList;
import java.util.HashMap;

public class Variables {
    public HashMap<String, Integer> datos;
    public HashMap<String, HashMap<ArrayList<String>,String>> funciones;
    public HashMap<ArrayList<String>,String> paramCod;

    public Variables() {
        datos = new HashMap<String, Integer>();
        funciones = new HashMap<String, HashMap<ArrayList<String>,String>>();
        paramCod = new HashMap<ArrayList<String>,String>();
    }

    public HashMap<String,Integer> getDatos() {
        return this.datos;
    }

    public void setDatos(HashMap<String,Integer> datos) {
        this.datos = datos;
    }

}

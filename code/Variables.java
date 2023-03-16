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

    public HashMap<String,HashMap<ArrayList<String>,String>> getFunciones() {
        return this.funciones;
    }

    public void setFunciones(HashMap<String,HashMap<ArrayList<String>,String>> funciones) {
        this.funciones = funciones;
    }

    public HashMap<ArrayList<String>,String> getParamCod() {
        return this.paramCod;
    }

    public void setParamCod(HashMap<ArrayList<String>,String> paramCod) {
        this.paramCod = paramCod;
    }

    public HashMap<String,Integer> getDatos() {
        return this.datos;
    }

    public void setDatos(HashMap<String,Integer> datos) {
        this.datos = datos;
    }

}

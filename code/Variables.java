import java.util.HashMap;

public class Variables {
    public HashMap<String, Integer> datos;

    public Variables() {
        datos = new HashMap<String, Integer>();
    }

    public HashMap<String,Integer> getDatos() {
        return this.datos;
    }

    public void setDatos(HashMap<String,Integer> datos) {
        this.datos = datos;
    }

}

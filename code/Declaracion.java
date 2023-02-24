import java.util.HashMap;

public class Declaracion {
    
    public HashMap<String, Integer> variables;

    public Declaracion() {
        variables = new HashMap<String, Integer>();
    }

    public String crearVariable(String codigo) {

        String [] linea = codigo.split(" ");

        String valor = linea[2];
        valor = valor.replaceAll("[()]", "");

        variables.put(linea[1], Integer.valueOf(valor));
        System.out.println(variables);

        return "";
    }
}

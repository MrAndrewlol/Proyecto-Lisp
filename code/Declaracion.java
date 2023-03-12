import java.util.HashMap;

public class Declaracion {

    public String crearVariable(String codigo, HashMap<String, Integer> variables) {

        String [] linea = codigo.split(" ");

        String valor = linea[2];
        valor = valor.replaceAll("[()]", "");

        variables.put(linea[1], Integer.valueOf(valor));
        System.out.println(variables);

        return "";
    }
}

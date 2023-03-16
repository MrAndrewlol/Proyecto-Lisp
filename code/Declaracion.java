import java.util.ArrayList;
import java.util.HashMap;

public class Declaracion {
    ArrayList<String> set = new ArrayList<String>();

    public String crearVariable(String codigo, HashMap<String, Integer> variables) {

        String [] linea = codigo.replaceAll("()", "").split(" ");

        for (int i = 0; i < linea.length; i++) {
            if (linea[i] != ""){
                set.add(linea[i]);
            }
        }

        String valor = set.get(2);
        valor = valor.replaceAll("[()]", "");

        variables.put(set.get(1), Integer.valueOf(valor));
        System.out.println(variables);

        return "";
    }
}

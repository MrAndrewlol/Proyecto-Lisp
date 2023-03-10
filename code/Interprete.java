import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interprete {

    private Declaracion declarar = new Declaracion();
    private Aritmetica operaciones = new Aritmetica();
    

    public String interpretar(String codigo) {
        String ejecucion = "";
        if (evaluate("^[(][ ]*set![ ]+[a-z]+[ ]+[0-9]+[ ]*[)]$",codigo)){
            declarar.crearVariable(codigo);
            ejecucion = "Variable creada";
        } else if (codigo.contains("+") || codigo.contains("-") || codigo.contains("*") || codigo.contains("/") || codigo.contains("%")) {
            ejecucion = operaciones.operar(codigo);
        } else {
            System.out.println("error");
        }

        return ejecucion;
    }

    public boolean evaluate(String regex, String codigo) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        
        Matcher matcher = pattern.matcher(codigo);

        return matcher.find();
    }
}

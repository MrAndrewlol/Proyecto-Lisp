import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interprete {

    private Declaracion declarar = new Declaracion();
    private Condicionales condiciones = new Condicionales();
    private Variables valores = new Variables();
    private Funciones funcion = new Funciones();

    public String interpretar(String codigo) {
        String ejecucion = "";
        if (evaluate("^[(][ ]*set![ ]+[a-z]+[ ]+[0-9]+[ ]*[)]$",codigo)){
            declarar.crearVariable(codigo, valores.getDatos());
            ejecucion = "Variable creada";
        }else if (evaluate("^[(][ ]*[+,-,/,*]*[ ]*", codigo)){
            Aritmetica operaciones = new Aritmetica();
            int operacion = operaciones.operar(codigo, valores.getDatos());
            ejecucion = String.valueOf(operacion);
        } else if (evaluate("^[(][ ]*print", codigo)){
            if (codigo != null || codigo.length() != 0) {
                codigo = codigo.substring(1);
                codigo = codigo.substring(codigo.length());
                System.out.println(interpretar(codigo));
            }
        }else if (evaluate("^[(][ ]*define[ ]", codigo)){
        
        }else {
            System.out.println("error");
        }

        if (evaluate("^[(][ ]*cond[ ]+[a-z]+[ ]+[0-9]+[ ]*[)]$",codigo)){ //Declarar condicionales if
            condiciones.siescondicional(codigo);

        } 
        
        
        if (evaluate("^[(][ ]*and[ ]+[a-z]+[ ]+[0-9]+[ ]*[)]$",codigo)){ //Declarar and 

        }

        
        if (evaluate("^[(][ ]*or[ ]+[a-z]+[ ]+[0-9]+[ ]*[)]$",codigo)){ //  si las dos funciones cumplen or statement

        }

        
        if (evaluate("^[(][ ]*else[ ]+[a-z]+[ ]+[0-9]+[ ]*[)]$",codigo)){ // Si las funciones else por otro lado

        }

        
        if (evaluate("^[(][ ]*defun[ ]+[a-z]+[ ]+[0-9]+[ ]*[)]$",codigo)){ // Para crear las funciones la mas dificil

        }


        return ejecucion;
    }

    public boolean evaluate(String regex, String codigo) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        
        Matcher matcher = pattern.matcher(codigo);

        return matcher.find();
    }
}

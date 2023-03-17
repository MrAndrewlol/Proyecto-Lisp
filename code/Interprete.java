import java.util.ArrayList;
import java.util.HashMap;
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
        }else if (evaluate("^[(][ ]*[+,-,/,*][ ]*", codigo)){
            if (codigo.contains("+") || codigo.contains("-") || codigo.contains("*") || codigo.contains("/")){
                Aritmetica operaciones = new Aritmetica();
                int operacion = operaciones.operar(codigo, valores.getDatos());
                ejecucion = String.valueOf(operacion);
            }
        } else if (evaluate("^[(][ ]*display", codigo)){
            if (codigo != null || codigo.length() != 0) {
                codigo = codigo.substring(1,codigo.length()-1);
                codigo = codigo.replace("display", "").trim();
                //codigo = codigo.substring(codigo.length());
                System.out.println(interpretar(codigo));
            }
        }else if (evaluate("^[(][ ]*define[ ]*[(]", codigo)){

            funcion.crearFuncion(codigo, valores.getFunciones(), valores.getParamCod());

        }else if (evaluate("^[(][ ]*[a-z]+", codigo)){
            String code = "";
            codigo = codigo.replace("(", "").replace(")", "");
            String[] FuncionPartes = codigo.split(" ");
            for (String key : valores.getFunciones().keySet()) {
                if (FuncionPartes[0].equals(key) ){
                    HashMap<ArrayList<String>,String> parametros = valores.getFunciones().get(key);
                    for (ArrayList<String> llave : parametros.keySet()) {
                        code = parametros.get(llave);
                        for (int i = 1; i < FuncionPartes.length; i++){
                            int j = 0;
                            code = code.replace(llave.get(j), FuncionPartes[i]);
                            j++;
                        }
                    }

                    
                }
            }

        String[] coding = code.split("\\|");
            for (int i = 1; i < coding.length; i++){
                interpretar(coding[i].trim());
            }

            
            

        } else if (evaluate("^[(][ ]*[-][ ]*", codigo)){
            Aritmetica operaciones = new Aritmetica();
                int operacion = operaciones.operar(codigo, valores.getDatos());
                ejecucion = String.valueOf(operacion);

        }else if (evaluate("^[(][ ]*[atom,equal,list][ ]+", codigo)){

        }else {
            System.out.println("error");
        }

        if (evaluate("^[(][ ]*cond[ (]+[<]+[a-z]+[ ]+[0-9]+[ ][))]$",codigo) || evaluate("^[(][ ]cond[ ]+[(]+[>]+[ ]+[a-z]+[ ]+[0-9]+[)]+[ ][)]$",codigo) || evaluate("^[(][ ]cond[ (]+[<=]+[a-z]+[ ]+[0-9]+[ ][)]$",codigo) || evaluate("^[(][ ]cond[ (]+[>=]+[a-z]+[ ]+[0-9]+[ ][)]$",codigo) || evaluate("^[(][ ]cond[ (]+[equal]+[a-z]+[ ]+[0-9]+[ ][)]$",codigo)){ //Declarar condicionales if
            System.out.println("Hecho");
           
            if (condiciones.siescondicional(codigo, valores.getDatos() ) == true){
                
            }

        }
        //numeros
        if (evaluate("^[(][ ]*cond[ ]*[(]+[>]+[ ]*[0-9]+[ ]+[0-9]+[ ]*[))]",codigo) || evaluate("^[(][ ]*cond[ ]*[(]+[<]+[ ][0-9]+[ ]+[0-9]+[ ][))]$",codigo) || evaluate("^[(][ ]cond[ (]+[<=]+[0-9]+[ ]+[0-9]+[ ][)]$",codigo) || evaluate("^[(][ ]cond[ (]+[>=]+[0-9]+[ ]+[0-9]+[ ][)]$",codigo) || evaluate("^[(][ ]cond[ (]+[equal]+[0-9]+[ ]+[0-9]+[ ][)]$",codigo)){ //Declarar condicionales if
        
            if (condiciones.siescondicional(codigo, valores.getDatos()) == true){
            }

        }

        if (evaluate("^[(][ ]and[ ]+[a-z]+[ ]+[0-9]+[ ][)]$",codigo)){ //Declarar and 

        }

        
        if (evaluate("^[(][ ]or[ ]+[a-z]+[ ]+[0-9]+[ ][)]$",codigo)){ //  si las dos funciones cumplen or statement

        }

        
        if (evaluate("^[(][ ]else[ ]+[a-z]+[ ]+[0-9]+[ ][)]$",codigo)){ // Si las funciones else por otro lado

        }

        return ejecucion;
    }

    public boolean evaluate(String regex, String codigo) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        
        Matcher matcher = pattern.matcher(codigo);

        return matcher.find();
    }
}
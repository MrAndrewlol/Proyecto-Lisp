import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interprete {

    private Declaracion declarar = new Declaracion();
    private Condicionales condiciones = new Condicionales();
    private Variables valores = new Variables();
    private Funciones funcion = new Funciones();
    private Predicados predicame = new Predicados();

    
    /** 
     * @param codigo
     * @return String
     */
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
                codigo = codigo.replace("display", "");
                if (codigo.contains("\""))
                    System.out.println(codigo);
                else 
                    codigo = codigo.replace("\"","" ).trim();
                    System.out.println(interpretar(codigo));
            }
        }else if (evaluate("^[(][ ]*define[ ]*[(]", codigo)){

            funcion.crearFuncion(codigo, valores.getFunciones(), valores.getParamCod());
            System.out.println("\n");

        }else if (evaluate("^[(][ ]*[atom,equal,list]*[ ]+", codigo)){
            System.out.println(predicame.hacerPredicado(codigo));
        
        }
        else if (evaluate("^[(][ ]*cond[ ]*[(]",codigo) || evaluate("^[(][ ]*and[ ]*[(]",codigo) || evaluate("^[(][ ]*or[ ]*[(]",codigo)){ //Declarar condicionales if
           
            interpretar("(" + condiciones.siescondicional(codigo, valores.getDatos())+ "))"); 

            

        }else if (evaluate("^[(][ ]*QUOTE", codigo)){
            if (codigo.contains("QUOTE")){
                System.out.println( "'" + codigo + "'");

            }
            
        }
        else if (evaluate("^[(][ ]*[a-z]+", codigo)){
            String code = "";
            codigo = codigo.replace("(", "").replace(")", "");
            String[] FuncionPartes = codigo.split(" ");
            for (String key : valores.getFunciones().keySet()) {
                if (FuncionPartes[0].equals(key) ){
                    HashMap<ArrayList<String>,String> parametros = valores.getFunciones().get(key);
                    for (ArrayList<String> llave : parametros.keySet()) {
                        code = parametros.get(llave);
                        int j = 0;
                        for (int i = 1; i < FuncionPartes.length; i++){
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

        } else if (evaluate("[0-9]*", codigo)){
            System.out.println(codigo); 

        }else {
            System.out.println("ERROR: LINEA DE CODIGO IRRECONOCIBLE");
        }

        return ejecucion;
    }

    
    /** 
     * @param regex
     * @param codigo
     * @return boolean
     */
    public boolean evaluate(String regex, String codigo) {
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        
        Matcher matcher = pattern.matcher(codigo);

        return matcher.find();
    }
}
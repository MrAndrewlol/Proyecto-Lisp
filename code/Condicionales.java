<<<<<<< Updated upstream
import java.util.LinkedList;
import java.util.HashMap;



public class Condicionales{
    private LinkedList<String> estackcondicion;
    private String[] listaString;
    private int contador;
  
    public Condicionales(){
        estackcondicion = new LinkedList<String>();
        listaString = new String[3];
        contador = 0;   
=======
import java.util.Stack;

public class Condicionales{
    private Stack<String> estackcondicion;
      
  
    public Condicionales(){
            Stack<String> estackcondicion = new Stack<String>();
            
>>>>>>> Stashed changes
      }
  
  
  
<<<<<<< Updated upstream

    public Condicionales(LinkedList<String> estackcondicion, String[] listaString, int contador) {
        this.estackcondicion = estackcondicion;
        this.listaString = listaString;
        this.contador = contador;
    }
=======
  public Condicionales(Stack<String> estackcondicion){
      this.estackcondicion = estackcondicion;
   
  }
>>>>>>> Stashed changes
    
    

    public LinkedList<String> getEstackcondicion() {
        return this.estackcondicion;
    }

    public void setEstackcondicion(LinkedList<String> estackcondicion) {
        this.estackcondicion = estackcondicion;
    }

    public int getContador() {
        return this.contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    /** 
     * @return String
     */
<<<<<<< Updated upstream
    public LinkedList<String> getCondicion() {
        return this.estackcondicion;
    }

    public void setCondicion(LinkedList<String> Condicion) {
=======
    public Stack<String> getCondicion() {
        return this.estackcondicion;
    }

    public void setCondicion(Stack<String> Condicion) {
>>>>>>> Stashed changes
        this.estackcondicion = Condicion;
    }

    public String[] getListaString() {
        return this.listaString;
    }

    public void setListaString(String[] listaString) {
        this.listaString = listaString;
    }

    public boolean siescondicional( String Condition, HashMap<String, Integer> variables){
        boolean condicional = true;
        char parentesis = '(';
        char parentesisderecha = ')';
        
        
       
            condicional = true;//recursividad
        if(Condition.contains("cond") |getContador() > 1){
                for (int i = 0; i < Condition.length(); i++) {
                    if (Condition.charAt(i) == parentesis) {
                       setContador(contador++);  
                    }
                    if (Condition.charAt(i) == parentesisderecha) {
                        setContador(contador--);
                        
                    }
            

            }
            for (String i : variables.keySet()) {
                System.out.println("key: " + i + " value: " + variables.get(i));
                
                if (Condition.contains(i)){
                   Condition = Condition.replace(i, "53");
                }
    
              }
            listaString = Condition.split("cond");
                setContador(contador--);
                
                estackcondicion.push(listaString[0]); //Solo mete los datos a la pila
                for (String i : variables.keySet()) {
            System.out.println("key: " + i + " value: " + variables.get(i));
            
            if (Condition.contains(i)){
                Condition.replace(i, String.valueOf(variables.get(i)));
            }

          }
                evaluarand();
                evaluaror();
                operadoreslogicos(Condition);
            condicional = true;
        }
        else{
            condicional = false;
        }
        //Espacio en caso de que haya un else
        
        
        


<<<<<<< Updated upstream
            
        return condicional;
        
    }
=======
                case "cond":{ //recursividad
                    if(Condition.contains("cond")){
                        Condition.split("cond");
                        


                    }
                    


                    
                    break;
                }
>>>>>>> Stashed changes

    public boolean evaluarand(){
        String listaString2[];
        boolean resultado = true;
        String valor = estackcondicion.peekLast();
        if (valor.contains("and")){
            valor.replace("and", "");
            listaString2 = valor.split(")", 2);
           

            if(operadoreslogicos(listaString2[1]) && operadoreslogicos(listaString2[2])){
                resultado = true;
            }
            else{
                resultado = false;
            }
        }
            //>< =

        return resultado;
        
    }

    public boolean evaluaror(){
        String listaString2[];
        boolean resultado = true;
        String valor = estackcondicion.peekLast();
        if (valor.contains("or")){
            valor.replace("or", "");
            listaString2 = valor.split(")", 2);
           

            if(operadoreslogicos(listaString2[1]) | operadoreslogicos(listaString2[2])){
                resultado = true;
            }
            else{
                resultado = false;
            }
        }
            //>< =

        return resultado;
        
    }

    public boolean operadoreslogicos(String valoreslogivcos ){ // <= >= < > =
        String listaString2[];
        boolean resultado = true;
        if (valoreslogivcos.contains("<=")){ // (<= 3 3) 
            listaString2 = valoreslogivcos.split(" ", 2);
            listaString2[0] = listaString2[0].replace("(", "");
            listaString2[listaString2.length-1] = listaString2[listaString2.length-1].replace(")", "");
            if(Integer.valueOf(listaString2[1]) <= Integer.valueOf(listaString2[2])){
             resultado = true;
            }
            else{
                resultado = false;
            }

        }
        
        if (valoreslogivcos.contains("<")){
            if (valoreslogivcos.contains("<")){ // (<= 3 3) 
                listaString2 = valoreslogivcos.split(" ", 2);
                listaString2[0] = listaString2[0].replace("(", "");
                listaString2[listaString2.length-1] = listaString2[listaString2.length-1].replace(")", "");
                if(Integer.valueOf(listaString2[1]) < Integer.valueOf(listaString2[2])){
                 resultado = true;
                }
                else{
                    resultado = false;
                }

        }
        }
        if (valoreslogivcos.contains(">=")){
            if (valoreslogivcos.contains(">=")){ // (<= 3 3) 
                listaString2 = valoreslogivcos.split(" ", 2);
                listaString2[0] = listaString2[0].replace("(", "");
                listaString2[listaString2.length-1] = listaString2[listaString2.length-1].replace(")", "");
                if(Integer.valueOf(listaString2[1]) >= Integer.valueOf(listaString2[2])){
                 resultado = true;
                }
                else{
                    resultado = false;
                }

        }
        }
        if (valoreslogivcos.contains(">")){
            if (valoreslogivcos.contains(">")){ // (<= 3 3) 
                valoreslogivcos = valoreslogivcos.replace("cond ((", "");
                listaString2 = valoreslogivcos.split(" ", 3);
                listaString2[0] = listaString2[0].replace("(", "");
                listaString2[listaString2.length-1] = listaString2[listaString2.length-1].replace(")", "");
                if(Integer.valueOf(listaString2[1]) > Integer.valueOf(listaString2[2])){
                 resultado = true;
                 System.out.println("Verdadero");
                }
                else{
                    resultado = false;
                    System.out.println("Falso");
                }
        }

        }
        if (valoreslogivcos.contains("EQ")){
            if (valoreslogivcos.contains("EQ")){ // (<= 3 3) 
                listaString2 = valoreslogivcos.split(" ", 2);
                listaString2[0] = listaString2[0].replace("(", "");
                listaString2[listaString2.length-1] = listaString2[listaString2.length-1].replace(")", "");
                if(Integer.valueOf(listaString2[1]) == Integer.valueOf(listaString2[2])){
                 resultado = true;
                }
                else{
                    resultado = false;
                }

        }

        } 
        return resultado;
        
    }
  
  
  }
  
      
  
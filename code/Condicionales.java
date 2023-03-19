import java.util.LinkedList;

import java.util.HashMap;

//  (cond ((< x 0) (-x)) ((> x 0) x) (t 0)))

//if if else else

public class Condicionales{
    private LinkedList<String> estackcondicion;
    private String[] listaString;
    private int contador;
  
    public Condicionales(){
        estackcondicion = new LinkedList<String>();
        listaString = new String[3];
        contador = 0;   
      }
  
  
  

    public Condicionales(LinkedList<String> estackcondicion, String[] listaString, int contador) {
        this.estackcondicion = estackcondicion;
        this.listaString = listaString;
        this.contador = contador;
    }
    
    

    
    /** 
     * @return LinkedList<String>
     */
    public LinkedList<String> getEstackcondicion() {
        return this.estackcondicion;
    }

    
    /** 
     * @param estackcondicion
     */
    public void setEstackcondicion(LinkedList<String> estackcondicion) {
        this.estackcondicion = estackcondicion;
    }

    
    /** 
     * @return int
     */
    public int getContador() {
        return this.contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    /** 
     * @return String
     */
    public LinkedList<String> getCondicion() {
        return this.estackcondicion;
    }

    public void setCondicion(LinkedList<String> Condicion) {
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

        
        
       
            condicional = true;//recursividad
            if(Condition.contains("cond") || Condition.contains("and") || Condition.contains("or") ||getContador() > 1){
                
            for (String i : variables.keySet()) {
                
                if (Condition.contains(i)){ //reemplaza la variable
                   Condition = Condition.replace(i, Integer.toString(variables.get(i)));
                }
              }
            Condition = Condition.replace("(cond", "");
            Condition = Condition.replace("))", "#");
            Condition = Condition.replace("t", "#");
            listaString = Condition.split("#");
           
                
            for (int i = 0; i < listaString.length-2; i++){
                String[] listaStringparameter;
                listaString[i] = listaString[i].replace(")", "#");
                listaStringparameter = listaString[i].split("#");
                estackcondicion.push(listaStringparameter[0]);
               
                estackcondicion.push(listaStringparameter[1]);
               
                } //Solo mete los datos a la pila
                for (String i : variables.keySet()) {
            
            
            if (Condition.contains(i)){
                Condition.replace(i, String.valueOf(variables.get(i)));
            }

          }
          for (int e = 0; e < estackcondicion.size() ; e++){
                evaluarand(estackcondicion.peekLast());
                evaluaror();
                if (!Condition.contains("and") && !Condition.contains("or")){
                    operadoreslogicos(estackcondicion.peekLast());
                }
                estackcondicion.removeLast();
                estackcondicion.removeLast();
            }
                
            condicional = true;
        }
        else{
            condicional = false;
        }
        //Espacio en caso de que haya un else
        
        


            
        return condicional;
        
    }

    public boolean evaluarand(String statement){
        String listaString2[];
        boolean resultado = true;
       
        if (statement.contains("and")){
            statement = statement.replace("and ", "");
            statement = statement.replace("cond", "");
            statement = statement.replace(") (", "/");
            listaString2 = statement.split("/");
           

            if(operadoreslogicos(listaString2[0]) && operadoreslogicos(listaString2[1])){
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
            valoreslogivcos = valoreslogivcos.replace("cond (", "");
            listaString2 = valoreslogivcos.split(" ", 3);
            listaString2[0] = listaString2[0].replace("(", "");
            listaString2[listaString2.length-1] = listaString2[listaString2.length-1].replace(")", "");
            if(Integer.valueOf(listaString2[1]) <= Integer.valueOf(listaString2[2])){
                resultado = true;
                System.out.println("Verdadero es mayor que " + listaString2[1]);
            }
            else{
                resultado = false;
                System.out.println("Falso es menor que" + listaString2[1]);
            }
    }
        
        if (valoreslogivcos.contains("<")){ // (<= 3 3) 
            valoreslogivcos =valoreslogivcos.trim();
            listaString2 = valoreslogivcos.split(" ");
            listaString2[0] = listaString2[0].replace("(", "");
            listaString2[listaString2.length-1] = listaString2[listaString2.length-1].replace(")", "");
            if(Integer.valueOf(listaString2[1]) < Integer.valueOf(listaString2[2])){
                resultado = true;
                System.out.println(estackcondicion.peekFirst());
                estackcondicion.remove();
                estackcondicion.remove();
            }
            else{
                resultado = false;
                System.out.println(listaString[listaString.length-2]);
                
                
            }
    }
        if (valoreslogivcos.contains(">=")){ // (<= 3 3) 
            valoreslogivcos = valoreslogivcos.replace("cond (", "");
            listaString2 = valoreslogivcos.split(" ", 3);
            listaString2[0] = listaString2[0].replace("(", "");
            listaString2[listaString2.length-1] = listaString2[listaString2.length-1].replace(")", "");
            if(Integer.valueOf(listaString2[1]) >= Integer.valueOf(listaString2[2])){
                resultado = true;
                System.out.println("Verdadero es mayor que " + listaString2[1]);
            }
            else{
                resultado = false;
                System.out.println("Falso es menor que" + listaString2[1]);
            }
    }
        
        if (valoreslogivcos.contains(">")){ // (<= 3 3)
            valoreslogivcos = valoreslogivcos.trim(); 
            valoreslogivcos = valoreslogivcos.replace("cond (", "");
            listaString2 = valoreslogivcos.split(" ", 3);
            listaString2[0] = listaString2[0].replace("(", "");
            listaString2[listaString2.length-1] = listaString2[listaString2.length-1].replace(")", "");
            if(Integer.valueOf(listaString2[1]) > Integer.valueOf(listaString2[2])){
                resultado = true;
                System.out.println("Verdadero es mayor que " + listaString2[1]);
            }
            else{
                resultado = false;
                System.out.println("Falso es menor que" + listaString2[1]);
            }
    }

        
        

        
        return resultado;
        
    }
  
  
  }

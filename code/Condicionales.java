import java.util.LinkedList;

import java.util.HashMap;

//  (cond ((< x 0) (-x)) ((> x 0) x) (t 0)))

//if if else else

public class Condicionales{
    private LinkedList<String> estackcondicion;
    private String[] listaString;
    private String respuesta;
  
    public Condicionales(){
        estackcondicion = new LinkedList<String>();
        listaString = new String[3];
        respuesta = "";   
      }
  
  
  

    public Condicionales(LinkedList<String> estackcondicion, String[] listaString, String contador) {
        this.estackcondicion = estackcondicion;
        this.listaString = listaString;
        this.respuesta = contador;
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
    public String getContador() {
        return this.respuesta;
    }

    public void setContador(String contador) {
        this.respuesta = contador;
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
            if(Condition.contains("cond") || Condition.contains("and") || Condition.contains("or") ){
                
            for (String i : variables.keySet()) {
                
                if (Condition.contains(i)){ //reemplaza la variable
                   Condition = Condition.replace(i, Integer.toString(variables.get(i)));
                }
              }
            Condition = Condition.replace("(cond", "");
            Condition = Condition.replace("))", "#");
            Condition = Condition.replace("t", "#");
            listaString = Condition.split("#");
            setContador(listaString[listaString.length-2]);
           
                
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
        
        


        System.out.println(getContador());    
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
            valoreslogivcos =valoreslogivcos.trim();
            listaString2 = valoreslogivcos.split(" ");
            listaString2[0] = listaString2[0].replace("(", "");
            listaString2[listaString2.length-1] = listaString2[listaString2.length-1].replace(")", "");
            if(Integer.valueOf(listaString2[1]) <= Integer.valueOf(listaString2[2])){
                resultado = true;
                setContador(estackcondicion.peekFirst().trim());
            }
            else{
                resultado = false;
                if (getContador().equals(listaString[listaString.length-2])){
                    setContador(listaString[listaString.length-2]);
                }
            }
    }
        
        if (valoreslogivcos.contains("<")){ // (< 3 3) 
            valoreslogivcos =valoreslogivcos.trim();
            listaString2 = valoreslogivcos.split(" ");
            listaString2[0] = listaString2[0].replace("(", "");
            listaString2[listaString2.length-1] = listaString2[listaString2.length-1].replace(")", "");
            if(Integer.valueOf(listaString2[1]) < Integer.valueOf(listaString2[2])){
                resultado = true;
                setContador(estackcondicion.peekFirst().trim());
                estackcondicion.remove();
                estackcondicion.remove();
            }
            else{
                resultado = false;
                if (getContador() == (listaString[listaString.length-2])){
                    setContador(listaString[listaString.length-2]);
                }
                

            }
    }
        if (valoreslogivcos.contains(">=")){ // (<= 3 3) 
            valoreslogivcos =valoreslogivcos.trim();
            listaString2 = valoreslogivcos.split(" ");
            listaString2[0] = listaString2[0].replace("(", "");
            listaString2[listaString2.length-1] = listaString2[listaString2.length-1].replace(")", "");
            if(Integer.valueOf(listaString2[1]) >= Integer.valueOf(listaString2[2])){
                resultado = true;
                setContador(estackcondicion.peekFirst().trim());
            }
            else{
                resultado = false;
                if (getContador().equals(listaString[listaString.length-2])){
                    setContador(listaString[listaString.length-2]);
                }
            }
    }
        
        if (valoreslogivcos.contains(">")){ // (<= 3 3)
            valoreslogivcos =valoreslogivcos.trim();
            listaString2 = valoreslogivcos.split(" ");
            listaString2[0] = listaString2[0].replace("(", "");
            listaString2[listaString2.length-1] = listaString2[listaString2.length-1].replace(")", "");
            if(Integer.valueOf(listaString2[1]) > Integer.valueOf(listaString2[2])){
                resultado = true;
                setContador(estackcondicion.peekFirst().trim());
            }
            else{
                resultado = false;
                if (getContador().equals(listaString[listaString.length-2])){
                    setContador(listaString[listaString.length-2]);
                }
            }
    }

        
        

       
        return resultado;
        
    }
  
  
  }

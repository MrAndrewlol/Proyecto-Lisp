public class Predicados {
    
    
    /** 
     * @param codigo
     * @return String
     */
    public String hacerPredicado(String codigo) {
        String valor = "";
        codigo = codigo.substring(1, codigo.length()-1).trim();
        
        
        if (codigo.contains("atom")){
            codigo.replaceAll("atom", "");
  
            if (codigo.contains("("))
                valor = "NIL";
            else 
                valor = "#T";

        } else if (codigo.contains("list")){
            codigo.replaceAll("list", "");
            
            if (codigo.contains("("))
                valor = "#T";
            else 
                valor = "NIL";
        } else if (codigo.contains("equal")){
            String[] listastringatomd = codigo.split(" ", 3);
            String[] elements = listastringatomd;
            if (elements[1].equals(elements[2].replace(")", ""))){
                valor = "#T";
            } else {
                valor = "NIL";
            }
        }
        return valor;
    }


}

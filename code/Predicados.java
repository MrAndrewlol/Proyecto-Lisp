public class Predicados {
    
    public String hacerPredicado(String codigo) {
        String valor = "";
        
        
        if (codigo.contains("atom")){
            String[] listastringatomd = codigo.split("atom");
            String codigodelista = listastringatomd[0];
  
            if (codigodelista.contains("("))
                valor = "#T";
            else 
                valor = "NIL";

        } else if (codigo.contains("list")){
            String[] listastringatomd = codigo.split("list");
            String codigodelista = listastringatomd[0];
            
            if (codigodelista.contains("("))
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

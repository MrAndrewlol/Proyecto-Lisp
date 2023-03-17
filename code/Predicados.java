public class Predicados {
    
    public String hacerPredicado(String codigo) {
        String valor = "";
        codigo = codigo.replaceAll("(", "").replaceAll(")", "");
        if (codigo.contains("atom")){
            codigo = codigo.replaceAll("atom", "").trim();
            if (codigo.contains(" "))
                valor = "#f";
            else 
                valor = "#t";

        } else if (codigo.contains("list")){
            codigo = codigo.replaceAll("list", "").trim();
            if (codigo.contains(" "))
                valor = "#t";
            else 
                valor = "#f";
        } else if (codigo.contains("equal")){
            codigo = codigo.replaceAll("equal", "").trim();
            String[] elements = codigo.split(" ");
            if (elements[0].equals(elements[1])){
                valor = "#t";
            } else {
                valor = "#f";
            }
        }
        return valor;
    }


}

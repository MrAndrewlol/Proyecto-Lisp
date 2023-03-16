import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Funciones {
    public String crearFuncion(String codigo, HashMap<String, HashMap<ArrayList<String>,String>> funciones, HashMap<ArrayList<String>,String> paramCod){
        Scanner in = new Scanner(System.in);
        boolean ejecucion = true;
        String code = "";
        ArrayList<Character> open = new ArrayList<Character>();
        ArrayList<Character> close = new ArrayList<Character>();
        ArrayList<String> param = new ArrayList<String>();
        
        String function = codigo.replaceAll("[()]", "").replaceAll("define", "").trim();
        String[] nameParam = function.split(" ");

        String funName = nameParam[0];

        for (int i = 1; i < nameParam.length; i++){
            param.add(nameParam[i]);
        }

        while (ejecucion) {

            char[] chars = codigo.toCharArray();
            for (char c : chars) {
                if (c == '(')
                    open.add(c);

                else if (c == ')')
                    close.add(c);
            }

            code = code + codigo;
            
            if (open.size() == close.size())
                ejecucion = false;

            else
                codigo = in.nextLine();
        }
        return "";
    }
}

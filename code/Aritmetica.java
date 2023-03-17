import java.util.HashMap;

public class Aritmetica {

    Stack<String> stack = new Stack<String>();

    private int resultado;
    private int result;

    public Aritmetica() {
        resultado = 0;
        result = 1;
    }

    public int getResultado() {
        return this.resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }


    public int operar(String codigo, HashMap<String, Integer> map) {

        codigo = new StringBuilder(codigo).reverse().toString();
        char[] chars = codigo.toCharArray();
        String s = "";
        String num = "";

        for (char c : chars) {
            int resultado = getResultado();
            if (Character.isLetterOrDigit(c)){
                s = String.valueOf(c);
                num = s + num;
            } else if (c == ' ') {
                if (num != "") {
                    stack.push(num);
                    num = "";
                }
            } else if (c == ')') {
                s = String.valueOf(c);
                stack.push(s);

            } else {
                if (c == '+') {
                    suma(stack, resultado, map);
                } else if (c == '-') {
                    resta(stack, resultado, map);
                } else if (c == '*') {
                    multiplicacion(stack, resultado, map);
                } else if (c == '/'){
                    division(stack, resultado, map);
                }
            }
        }
        

        return resultado;
    }
    
    public void suma(Stack<String> stack, int resultado, HashMap<String, Integer> map) {
        boolean ejecucion = true;
        while (ejecucion) {
            String cha = stack.peek();
            if (cha.matches("[0-999]*")){
                int valor = Integer.valueOf(stack.peek());
                stack.pull();
                resultado = valor + resultado;
            } else if (cha.matches("[a-z]*")){
                for (String key : map.keySet()) {
                    if (cha.equalsIgnoreCase(key)){
                        int valor = map.get(key);
                        stack.pull();
                        resultado = valor + resultado;
                    }
                }
                
            } else {
                ejecucion = false;
            }
        }
        stack.pull();
        setResultado(resultado);
    }

    public void resta(Stack<String> stack, int resultado, HashMap<String, Integer> map) {
        boolean ejecucion = true;
        while (ejecucion) {
            String cha = stack.peek();
            if (cha.matches("[0-999]*") && cha != ""){
                int valor = Integer.valueOf(stack.peek());
                stack.pull();
                resultado = valor - resultado;
            } else {
                ejecucion = false;
            }
        }
        stack.pull();
        setResultado(resultado);
    }

    public void multiplicacion(Stack<String> stack, int resultado, HashMap<String, Integer> map) {
        boolean ejecucion = true;
        while (ejecucion) {
            String cha = stack.peek();
            if (cha.matches("[0-999]*")){
                int valor = Integer.valueOf(stack.peek());
                stack.pull();
                result = valor * result;
            } else {
                ejecucion = false;
            }
        }
        stack.pull();
        setResultado(result);
    }

    public void division(Stack<String> stack, int resultado, HashMap<String, Integer> map) {
        boolean ejecucion = true;
        while (ejecucion) {
            String cha = stack.peek();
            if (cha.matches("[0-999]*")){
                int valor = Integer.valueOf(stack.peek());
                stack.pull();
                result = valor / result;
            } else {
                ejecucion = false;
            }
        }
        stack.pull();
        setResultado(result);
    }
}

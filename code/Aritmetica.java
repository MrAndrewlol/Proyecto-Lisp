import java.util.HashMap;
import java.util.ArrayList;

public class Aritmetica {

    Stack<String> stack = new Stack<String>();

    private int resultado;
    private int result;
    private ArrayList<Integer> resultados;

    public Aritmetica() {
        resultado = 0;
        result = 1;
        resultados = new ArrayList<Integer>();
    }

    public int getResultado() {
        return this.resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }


    public Stack<String> getStack() {
        return this.stack;
    }

    public void setStack(Stack<String> stack) {
        this.stack = stack;
    }

    public int getResult() {
        return this.result;
    }

    public void setResult(int result) {
        this.result = result;
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

            } else if (c == '('){
                resultados.add(resultado);
                setResult(1);
                setResultado(0);
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
        

        return resultados.get(0);
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
            } else if (resultados.size() >= 2){
                resultado = resultados.get(0) + resultados.get(1);
                resultados.remove(0);
                resultados.remove(0);
            } else {
                ejecucion = false;
            }
        }
        stack.pull();
        setResultado(resultado);
        setResult(resultado);
        
    }

    public void resta(Stack<String> stack, int resultado, HashMap<String, Integer> map) {
        boolean ejecucion = true;
        while (ejecucion) {
            String cha = stack.peek();
            if (cha.matches("[0-999]*") && cha != ""){
                int valor = Integer.valueOf(stack.peek());
                stack.pull();
                if (resultado == 0)
                    resultado = valor - resultado;
                else 
                    resultado = resultado - valor;
            } else {
                ejecucion = false;
            }
        }
        stack.pull();
        setResultado(resultado);
        setResult(resultado);
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
        setResult(result);
    }

    public void division(Stack<String> stack, int resultado, HashMap<String, Integer> map) {
        boolean ejecucion = true;
        while (ejecucion) {
            String cha = stack.peek();
            if (cha.matches("[0-999]*")){
                int valor = Integer.valueOf(stack.peek());
                stack.pull();
                if (result == 1)
                    result = valor / result;
                else 
                    result = result/valor;
            } else {
                ejecucion = false;
            }
        }
        stack.pull();
        setResultado(result);
        setResult(result);
    }
}

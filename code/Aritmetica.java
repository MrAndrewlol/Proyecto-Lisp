public class Aritmetica {

    Stack<String> stack = new Stack<String>();

    int resultado;

    public Aritmetica() {
        resultado = 0;
    }

    public int getResultado() {
        return this.resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }


    public String operar(String codigo) {

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
                stack.push(num);
                num = "";
            } else if (c == ')') {
                s = String.valueOf(c);
                stack.push(s);

            } else {
                if (c == '+') {
                    suma(stack, resultado);
                } else if (c == '-') {
                    resta(stack, resultado);
                } else if (c == '*') {
                    multiplicacion(stack, resultado);
                } else if (c == '/'){
                    division(stack, resultado);
                }
            }
        }
        

        return codigo;
    }
    
    public void suma(Stack<String> stack, int resultado) {
        boolean ejecucion = true;
        while (ejecucion) {
            String cha = stack.peek();
            if (cha.matches("[0-999]*")){
                int valor = Integer.valueOf(stack.peek());
                stack.pull();
                resultado = valor + resultado;
            } else {
                ejecucion = false;
            }
        }
        stack.pull();
        setResultado(resultado);
    }

    public void resta(Stack<String> stack, int resultado) {
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

    public void multiplicacion(Stack<String> stack, int resultado) {
        boolean ejecucion = true;
        while (ejecucion) {
            String cha = stack.peek();
            if (cha.matches("[0-999]*")){
                int valor = Integer.valueOf(stack.peek());
                stack.pull();
                resultado = valor * resultado;
            } else {
                ejecucion = false;
            }
        }
        stack.pull();
        setResultado(resultado);
    }

    public void division(Stack<String> stack, int resultado) {
        boolean ejecucion = true;
        while (ejecucion) {
            String cha = stack.peek();
            if (cha.matches("[0-999]*")){
                int valor = Integer.valueOf(stack.peek());
                stack.pull();
                resultado = valor / resultado;
            } else {
                ejecucion = false;
            }
        }
        stack.pull();
        setResultado(resultado);
    }

    public int modulo(Stack<String> stack, int resultado) {
        return 0;
    }

}

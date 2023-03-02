public class Aritmetica {

    Stack<String> stack = new Stack<String>();

    public String operar(String codigo) {

        codigo = new StringBuilder(codigo).reverse().toString();
        char[] chars = codigo.toCharArray();
        StringBuilder sb = new StringBuilder();
        String s = "";
        String num = "";
        int resultado = 0;

        for (char c : chars) {
            if (Character.isDigit(c)){
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

                } else if (c == '*') {

                } else if (c == '/'){

                }
            }
        }
        

        return codigo;
    }
    
    public int suma(Stack<String> stack, int resultado) {
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
        return resultado;
    }

    public int resta(Stack<String> stack, int resultado) {
        return 0;
    }

    public int multiplicacion(Stack<String> stack, int resultado) {
        return 0;
    }

    public int division(Stack<String> stack, int resultado) {
        return 0;
    }

    public int modulo(Stack<String> stack, int resultado) {
        return 0;
    }

}

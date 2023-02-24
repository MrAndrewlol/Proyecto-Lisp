import java.util.Scanner;

public class interpretacion<T> {

    public static void main(String[] args) {

        String rpa;
        Scanner teclado = new Scanner(System.in);
        Interprete interprete = new Interprete(); 

        System.out.println("Ingrese la linea de código: ");
        rpa = teclado.nextLine();
        interprete.interpretar(rpa);
    }
}
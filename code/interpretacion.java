import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


public class interpretacion<T> {

    public static void main(String[] args) {

        String rpa = "";
        int mresp;
        boolean terminar = true;
        Scanner teclado = new Scanner(System.in);
        Interprete interprete = new Interprete(); 
        System.out.println("Bienvenido a SCHELISP Exist\nElegir la opción que desea para el intérprete: \n\n1. Programación por terminal\n2.Programación mediante archivo txt");
        mresp = teclado.nextInt();
        teclado.nextLine();

        switch(mresp){
            case 1: {
                System.out.println("Ingrese su código (Para guardarlo escriba save)\n");
                while(terminar){
                    rpa = teclado.nextLine();
                    if (rpa.equals("save"))
                        terminar = false;
                    else
                        interprete.interpretar(rpa);

                }
        


                break;
            }

            case 2:{
                System.out.println("Ingrese la ruta del archivo ej C:\\ejemplos\\example1.txt");
                
                String fpath = teclado.nextLine();
                
                try {
                File myObj = new File(fpath);
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    System.out.println(data);
                    System.out.println(interprete.interpretar(data));

                }
                myReader.close();
                } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
                }
  



                break;
            }


        }
        

      
        
    }
}
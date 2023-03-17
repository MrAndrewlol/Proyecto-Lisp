import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files


public class interpretacion<T> {

    public static void main(String[] args) {

        String rpa = "";
        int mresp;
        Scanner teclado = new Scanner(System.in);
        Interprete interprete = new Interprete(); 
        System.out.println("Bienvenido a SCHELISP Exist\npor favor elegir la opcion que desea? 1.Ingresar una linea de codigo\n2.Ingresar formato txt su programa ");
        mresp = teclado.nextInt();

        switch(mresp){
            case 1: {
                while(rpa != "Terminar"){
                    System.out.println("Ingrese la linea de código: ");
                    rpa = teclado.nextLine();
                    
                    System.out.println(interprete.interpretar(rpa));
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
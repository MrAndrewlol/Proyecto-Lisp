import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Pruebasunitarias {
    Declaracion declarar = new Declaracion();
    Condicionales condiciones = new Condicionales();
    Variables valores = new Variables();
    Funciones funcion = new Funciones();
    Predicados predicame = new Predicados();
    Aritmetica operaciones = new Aritmetica();

 // Condicionales
    @Test
    public void siescondicionalpacalcu(){
        boolean resultado = condiciones.siescondicional("(cond (< 4 5))", valores.getDatos());
        assertEquals(true,resultado);
    }

    @Test
    public void evaluarand(){
        boolean resultado = condiciones.evaluarand("(and (= 2 2) (< 4 5))");
        assertEquals(true, resultado);
    }

    @Test 
    public void crearVariable(){
        String resultado = declarar.crearVariable("(set! x 4)", valores.getDatos());
        assertEquals("", resultado);
    }

    @Test
    public void operaciones(){
        int resultado = operaciones.operar("(+ 2 2)", valores.getDatos());
        assertEquals(4, resultado);
    }

   
}
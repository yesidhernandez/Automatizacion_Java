package PruebaUnitariaQV.PruebaUnitariaQVision;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class OperacionesTest 
{
	@Before
	
	@Test
    public void testSuma() 
	{       
        Operaciones operador = new Operaciones();
        int resultado = operador.suma(2, 4);
        int esperado = 6;
        assertEquals(resultado, esperado);
    }
	
	@Test
    public void testResta() 
	{       
        Operaciones operador = new Operaciones();
        int resultado = operador.resta(4, 1);
        int esperado = 3;
        assertEquals(resultado, esperado);
    }
	
	@Test
    public void testMultiplicacion() 
	{       
        Operaciones operador = new Operaciones();
        int resultado = operador.multiplicacion(4, 2);
        int esperado = 8;
        assertEquals(resultado, esperado);
    }
	
	@Test
    public void testDivision() 
	{       
        Operaciones operador = new Operaciones();
        int resultado = operador.resta(4, 2);
        int esperado = 2;
        assertEquals(resultado, esperado);
    }
}
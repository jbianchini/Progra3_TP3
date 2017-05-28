package grafo;

import static org.junit.Assert.*;

import java.util.Set;

import org.junit.Test;

public class GrafoTest
{
	@Test
	public void agregarAristaTest()
	{
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(0, 2);
		assertTrue( grafo.existeArista(0, 2) );
	}
	
	@Test
	public void agregarIndicesInvertidosTest()
	{
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(1, 3);
		assertTrue( grafo.existeArista(3, 1) );
	}
	
	@Test
	public void aristaInexistenteTest()
	{
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(1, 3);
		assertFalse( grafo.existeArista(1, 2) );
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void agregadoErroneoTest()
	{
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(1, 4);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void verticeNegativoTest()
	{
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(-1, 2);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void sinLoopsTest()
	{
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(3, 3);
	}
	
	@Test
	public void eliminarAristaTest()
	{
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(1, 2);

		grafo.eliminarArista(1, 2);
		assertFalse( grafo.existeArista(1, 2) );
	}

	@Test
	public void eliminarCruzadoTest()
	{
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(1, 2);

		grafo.eliminarArista(1, 2);
		assertFalse( grafo.existeArista(2, 1) );
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void eliminarExcedidoTest()
	{
		Grafo grafo = new Grafo(4);
		grafo.eliminarArista(0, 4);
	}

	@Test(expected = IllegalArgumentException.class)
	public void eliminarNegativoTest()
	{
		Grafo grafo = new Grafo(4);
		grafo.eliminarArista(3, -1);
	}

	@Test
	public void gradoTest()
	{
		Grafo rueda = construirRueda();
		
		assertEquals(5, rueda.getGrado(5));
		assertEquals(3, rueda.getGrado(0));
	}

	@Test(expected = IllegalArgumentException.class)
	public void gradoInvalidoTest()
	{
		Grafo rueda = construirRueda();
		rueda.getGrado(-1);		
	}

	@Test(expected = IllegalArgumentException.class)
	public void gradoExcedidoTest()
	{
		Grafo rueda = construirRueda();
		rueda.getGrado(6);		
	}
	
	@Test
	public void vecinosUniversalTest()
	{
		Grafo rueda = construirRueda();
		Set<Integer> vecinos = rueda.getVecinos(5);
		Assert.coinciden(vecinos, new int[] {0, 1, 2, 3, 4});
	}
	
	@Test
	public void vecinosRegularTest()
	{
		Grafo rueda = construirRueda();
		Set<Integer> vecinos = rueda.getVecinos(3);
		Assert.coinciden(vecinos, new int[] {2, 4, 5});
	}
	
	@Test
	public void aisladoTest()
	{
		Grafo grafo = new Grafo(3);
		Set<Integer> vecinos = grafo.getVecinos(1);
		Assert.coinciden(vecinos, new int[] {});
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void vecinosExcedidoTest()
	{
		Grafo grafo = new Grafo(3);
		grafo.getVecinos(3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void vecinosNegativoTest()
	{
		Grafo grafo = new Grafo(3);
		grafo.getVecinos(-1);
	}
	
	private Grafo construirRueda()
	{
		Grafo rueda = new Grafo(6);
		rueda.agregarArista(0, 1);
		rueda.agregarArista(1, 2);
		rueda.agregarArista(2, 3);
		rueda.agregarArista(3, 4);
		rueda.agregarArista(4, 0);
		rueda.agregarArista(0, 5);
		rueda.agregarArista(1, 5);
		rueda.agregarArista(2, 5);
		rueda.agregarArista(3, 5);
		rueda.agregarArista(4, 5);
		
		return rueda;		
	}
}









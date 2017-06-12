package materias;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.TreeMap;

import org.junit.Test;

public class GrafoMateriasTest {
	Materia matematica = new Materia("Matematica", 1100, 1200, 0);
	Materia historia = new Materia("Historia", 1100, 1200, 1);
	Materia fisica = new Materia("Fisica", 1400, 1600, 2);
	Materia programacion = new Materia("Programacion", 1500, 1800, 3);
	
	@Test
	public void testGrafoMaterias(){
		ArrayList<Materia> materias = new ArrayList<>();
		
		materias.add(matematica);
		materias.add(historia);
		materias.add(fisica);
		materias.add(programacion);
		
		GrafoMaterias grafoMaterias = new GrafoMaterias(materias);
		System.out.println(grafoMaterias.toString());
	}
	
	@Test
	public void testSeSuperponenIguales(){
		assertTrue(GrafoMaterias.seSuperpone(matematica, historia));
	}
	
	@Test
	public void testSeSuperponenMenorMayor(){
		assertTrue(GrafoMaterias.seSuperpone(fisica, programacion));
	}
	
	@Test
	public void testSeSuperponenMayorMenor(){
		assertTrue(GrafoMaterias.seSuperpone(programacion, fisica));
	}
	
	@Test 
	public void testNoSeSuperponen(){
		assertFalse(GrafoMaterias.seSuperpone(matematica, fisica));
	}
	
	@Test
	public void testColoreoMinimo(){
		ArrayList<Materia> materias = new ArrayList<>();

		materias.add(fisica);
		materias.add(historia);
		materias.add(programacion);
		
		GrafoMaterias grafoMaterias = new GrafoMaterias(materias);
		TreeMap<Integer, ArrayList<Integer>> coloreo = grafoMaterias.obtenerColoreo();
		
		TreeMap<Integer, ArrayList<Integer>> coloreo2 = new TreeMap<>();
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		
		list1.add(0);
		list1.add(1);
		list2.add(2);
		coloreo2.put(1, list1);
		coloreo2.put(2, list2);
		
		assertEquals(coloreo2, coloreo);
	}
}

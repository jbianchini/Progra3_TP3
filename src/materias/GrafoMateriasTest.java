package materias;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class GrafoMateriasTest {
	Materia matematica = new Materia("Matematica", 1100, 1200, 0);
	Materia historia = new Materia("Historia", 1100, 1200, 1);
	Materia fisica = new Materia("Fisica", 1400, 1600, 2);
	Materia programacion = new Materia("Matematica", 1500, 1800, 3);
	
	@Test
	public void testGrafoMaterias(){
		ArrayList<Materia> materias = new ArrayList<>();
		
		materias.add(matematica);
		materias.add(historia);
		materias.add(fisica);
		materias.add(programacion);
		
		GrafoMaterias grafoMaterias = new GrafoMaterias(materias);
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
}

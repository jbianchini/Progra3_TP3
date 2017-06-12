package interfaz;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import materias.GrafoMaterias;
import materias.Materia;

public class ItinerarioTest {

	Itinerario itinerario;
	Materia matematica = new Materia("Matematica", 1100, 1200, 0);
	Materia historia = new Materia("Historia", 1100, 1200, 1);
	Materia fisica = new Materia("Fisica", 1400, 1600, 2);
	Materia programacion = new Materia("Programacion", 1500, 1800, 3);
	
	private ArrayList<Materia> crearArregloMaterias(){
		ArrayList<Materia> materias = new ArrayList<>();
		
		materias.add(matematica);
		materias.add(historia);
		materias.add(fisica);
		materias.add(programacion);
		
		return materias;
	}
	
	@Test
	public void testItinerario() {
		GrafoMaterias grafoMaterias = new GrafoMaterias(crearArregloMaterias());;
		
		HashMap<Integer, ArrayList<Integer>> coloreo = grafoMaterias.obtenerColoreo();
		
		itinerario = new Itinerario(coloreo, grafoMaterias.getMaterias());
	}
	
	@Test
	public void testMapearMaterias(){
		ArrayList<Materia> materias = crearArregloMaterias();
		ArrayList<Integer> codigos = new ArrayList<>();
		codigos.add(2);
		codigos.add(1);
		codigos.add(3);
		codigos.add(0);
		System.out.println(codigos.toString());
		
		ArrayList<Materia> res = new ArrayList<>();
		res.add(fisica);
		res.add(historia);
		res.add(programacion);
		res.add(matematica);
		
		assertEquals(res, Itinerario.mapearMaterias(codigos, materias)); 
	}
	
}

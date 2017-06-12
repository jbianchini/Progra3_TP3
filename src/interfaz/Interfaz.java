package interfaz;

import java.util.ArrayList;
import java.util.HashMap;

import loader.Loader;
import materias.GrafoMaterias;
import materias.Materia;

public class Interfaz {
	
	public Itinerario ObtenerItinerario(String archivo){
		
		ArrayList<Materia> materias = cargarMaterias(archivo);
		GrafoMaterias grafoMaterias = crearGrafo(materias);
		Itinerario itinerario = calcularItinerario(grafoMaterias);
				
		return itinerario;
	}


	private ArrayList<Materia> cargarMaterias(String archivo) {
		Loader loader = new Loader();
		ArrayList<Materia> materias = loader.obtenerMaterias(archivo);
		return materias;
	}
	
	private GrafoMaterias crearGrafo(ArrayList<Materia> materias) {
		GrafoMaterias grafoMaterias = new GrafoMaterias(materias);
		return grafoMaterias;
	}

	private Itinerario calcularItinerario(GrafoMaterias grafo) {
		return new Itinerario(grafo.obtenerColoreo(), grafo.getMaterias());
	}
}

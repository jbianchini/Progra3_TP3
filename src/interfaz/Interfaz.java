package interfaz;

import java.util.ArrayList;

import loader.Loader;
import materias.GrafoMaterias;
import materias.Materia;

public class Interfaz {
	/*
	 * Esta clase representa un controlador de las clases de negocio inferiores.
	 * Se encarga de que la clase Loader cargue el archivo, se inicialice un grafo,
	 * y crear un itinerario que contenga los datos mencionados.
	 */
	
	public Itinerario ObtenerItinerario(String archivo){
		
		ArrayList<Materia> materias = cargarMaterias(archivo);
		GrafoMaterias grafoMaterias = crearGrafo(materias);
		Itinerario itinerario = crearItinerario(grafoMaterias);
				
		return itinerario;
	}


	private ArrayList<Materia> cargarMaterias(String archivo) {
		ArrayList<Materia> materias = Loader.obtenerMaterias(archivo);
		return materias;
	}
	
	private GrafoMaterias crearGrafo(ArrayList<Materia> materias) {
		GrafoMaterias grafoMaterias = new GrafoMaterias(materias);
		return grafoMaterias;
	}

	private Itinerario crearItinerario(GrafoMaterias grafo) {
		return new Itinerario(grafo.obtenerColoreo(), grafo.getMaterias());
	}
}

package interfaz;

import java.util.ArrayList;

import loader.Loader;
import materias.GrafoMaterias;
import materias.Materia;

public class Interfaz {
	
	// le pasas las materias en el json. Estaria bueno que esto lo use la interfaz grafica
	public void ObtenerItinerario(String archivo){
		
		ArrayList<Materia> materias = cargarMaterias(archivo);
		GrafoMaterias grafoMaterias = crearGrafo(materias);
		Itinerario itinerario = calcularItinerario();
		
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

	private Itinerario calcularItinerario() {
		return null;
	}
}

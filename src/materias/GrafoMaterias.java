package materias;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import java.util.Collections;

import grafo.Grafo;

public class GrafoMaterias extends Grafo {
	private ArrayList<Materia> _materias;
	
	public GrafoMaterias(ArrayList<Materia> materias) { //TODO: el loader de archivos debe 
		super(materias.size());										// checkear los horarios para que sean correctos
		_materias = materias;
		agregarSuperposiciones();
	}
	
	public ArrayList<Materia> getMaterias(){
		return _materias;
	}
	
	private void agregarSuperposiciones(){
		/*
		 * Si se superpone una materia con otra, agrega la arista
		 */
		for (int m=0; m<_materias.size();m++)
			for(int o=0; o<_materias.size();o++){
				Materia materia = _materias.get(m);
				Materia otra = _materias.get(o);
				if (!materia.equals(otra) && seSuperpone(materia, otra))
					agregarArista(m, o);
			}
	}

	protected static boolean seSuperpone(Materia materia, Materia otra) {
		/*
		 * Checkea que la hora de inicio o de finalizacion no esten entre la hora de inicio y finalizacion de otra materia
		 */
		if (
				(materia.get_hora_inicio() >= otra.get_hora_inicio() &&	materia.get_hora_inicio() < otra.get_hora_fin()) ||
				(materia.get_hora_fin() > otra.get_hora_inicio() && materia.get_hora_fin() <= otra.get_hora_fin())
		   )
			return true;
		return false;
	}
	
	// armar los metodos de coloreo y busqueda del numero cromatico
	public HashMap<Integer, ArrayList<Integer>> obtenerColoreo(){
		// creo un diccionario de vertices y colores
		HashMap<Integer, Integer>coloresAsignados = new HashMap<Integer, Integer>();
		// recorro todos los vertices del grafo
		for (int vertice=0;vertice<this.getVertices();vertice++){
			ArrayList<Integer> coloresVecinos = new ArrayList<>();
			// obtengo todos los vecinos del vertice actual
			for (Iterator<Integer> vecino = this.getVecinos(vertice).iterator(); vecino.hasNext(); ) {
				// obtengo los colores de los vecinos
				coloresVecinos.add(coloresAsignados.get(vecino.next()));
			}
			
			int colorNuevo = 0;
			if (coloresAsignados.isEmpty())
				colorNuevo = 1;
			else {
				for (Map.Entry<Integer, Integer> entry : coloresAsignados.entrySet()){
					if (!coloresVecinos.contains(entry.getValue())){
						colorNuevo = entry.getValue();
						break;
					}
					else
						colorNuevo = Collections.max(coloresAsignados.values()) + 1;
				}
			}
			coloresAsignados.put(vertice, colorNuevo);
		}
		// Ahora debo dar vuelta el diccionario. Por cada color, necesito las materais
		HashMap<Integer, ArrayList<Integer>> coloreo = new HashMap<>();
		for (Map.Entry<Integer, Integer> entry : coloresAsignados.entrySet()){
			if (coloreo.containsKey(entry.getValue()))
				coloreo.get(entry.getValue()).add(entry.getKey());
			else{
				coloreo.put(entry.getValue(), new ArrayList<Integer>());
				coloreo.get(entry.getValue()).add(entry.getKey());
			}
		}
		return coloreo;
	}
	
}

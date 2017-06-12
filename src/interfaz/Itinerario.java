package interfaz;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import materias.Materia;

public class Itinerario {
	
	TreeMap<Integer, ArrayList<Integer>> _coloreo;
	ArrayList<Materia> _materias;
	Integer materiasSize;
	
	/**
	 * El constructor del itinerario toma como parametros una lista de materias y
	 * un coloreo de materias por aula.
	 * @param coloreo es un diccionario de listas, donde la key es un aula y la lista
	 * es un cierto grupo de codigos de materias.
	 * @param materias es la lista inicial de todas las materias cargadas.
	 */
	public Itinerario(TreeMap<Integer, ArrayList<Integer>> coloreo,
			ArrayList<Materia> materias){
		_coloreo = coloreo;
		_materias = materias;
		materiasSize = materias.size();
	}
	
	/**
	 * Este metodo se encarga de tomar el diccionario de coloreo y darla un formato
	 * apto para ser leido por el usuario.
	 * @return un diccionario donde la clave es un string con nombre de aula, y los
	 * valores una lista de materias tal como estan definidas en la clase Materia.
	 */
	public TreeMap<String, ArrayList<Materia>> obtenerItinerario()
	{
		TreeMap<String, ArrayList<Materia>> itinerario = new TreeMap<>();
		for (Map.Entry<Integer, ArrayList<Integer>> entry : _coloreo.entrySet()){
			ArrayList<Materia> materiasList = mapearMaterias(entry.getValue(), _materias);
			itinerario.put("Aula "+entry.getKey(), materiasList);
		}
		return itinerario;
	}
	
	/**
	 * Este metodo mapea los numeros de materia de materiasCode con la materia que le
	 * corresponde de la lista inicial de materias.
	 * @param materiasCode lista con codigos de materia (segun el grafo).
	 * @param materias lista de materias.
	 * @return lista de materias mapeadas.
	 */
	protected static ArrayList<Materia> mapearMaterias(ArrayList<Integer> materiasCode, ArrayList<Materia> materias) {
		ArrayList<Materia> materiasList = new ArrayList<>();
		for(Integer mat: materiasCode){
			materiasList.add(materias.get(mat));
		}
		return materiasList;
	}
	
	public Integer getMateriasSize(){
		return materiasSize;
	}
	
}

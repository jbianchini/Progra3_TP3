package interfaz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import materias.Materia;

public class Itinerario {
	
	HashMap<String, ArrayList<Materia>> itinerario;
	Integer materiasSize;
	
	public Itinerario(HashMap<Integer, ArrayList<Integer>> coloreo,
			ArrayList<Materia> materias){
		itinerario = obtenerItinerario(coloreo, materias);
		materiasSize = materias.size();
	}
	
	protected HashMap<String, ArrayList<Materia>> obtenerItinerario(
			HashMap<Integer, ArrayList<Integer>> coloreo,
			ArrayList<Materia> materias
			)
	{
		HashMap<String, ArrayList<Materia>> itinerario = new HashMap<>();
		for (Map.Entry<Integer, ArrayList<Integer>> entry : coloreo.entrySet()){
			ArrayList<Materia> materiasList = mapearMaterias(entry.getValue(), materias);
			itinerario.put("Aula "+entry.getKey(), materiasList);
		}
		return itinerario;
	}
	
	protected static ArrayList<Materia> mapearMaterias(ArrayList<Integer> materiasCode, ArrayList<Materia> materias) {
		ArrayList<Materia> materiasList = new ArrayList<>();
		for(Integer mat: materiasCode){
			materiasList.add(materias.get(mat));
		}
		return materiasList;
	}
	
	public HashMap<String, ArrayList<Materia>> getItinerario(){
		return itinerario;
	}
	
	public Integer getMateriasSize(){
		return materiasSize;
	}
	
	public String toString(){
		StringBuilder ret = new StringBuilder();
		for (Map.Entry<String, ArrayList<Materia>> entry : itinerario.entrySet()){
			ret.append(entry.getKey().toString());
			ret.append(" ");
			ret.append(entry.getValue().toString());
			ret.append("\n");
		}
		return ret.toString();
	}
}

package materias;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collections;

import grafo.Grafo;

public class GrafoMaterias extends Grafo {
	private ArrayList<Materia> _materias;
	
	public GrafoMaterias(ArrayList<Materia> materias) {
		super(materias.size());
		_materias = materias;
		agregarSuperposiciones();
	}
	
	public ArrayList<Materia> getMaterias(){
		return _materias;
	}
	
	/**
	 * En caso de que una materia se superponga con otra, se agrega una arista entre
	 * los vertices que representan a cada una.
	 */
	private void agregarSuperposiciones(){
		ordenarMaterias();
		for (int m=0; m<_materias.size();m++)
			for(int o=0; o<_materias.size();o++){
				Materia materia = _materias.get(m);
				Materia otra = _materias.get(o);
				if (!materia.equals(otra) && seSuperpone(materia, otra))
					agregarArista(m, o);
			}
	}
	
	private void ordenarMaterias(){
		Collections.sort(_materias, (p,q) -> p.get_hora_inicio() - q.get_hora_inicio());
	}
	
	/**
	 * Comprueba si una materia se superpone con otra, y en dicho caso devuelve true.
	 * @param materia Materia.
	 * @param otra Otra Materia.
	 * @return boolean.
	 */
	protected static boolean seSuperpone(Materia materia, Materia otra) {
		if (
				(materia.get_hora_inicio() >= otra.get_hora_inicio() &&	materia.get_hora_inicio() < otra.get_hora_fin()) ||
				(materia.get_hora_fin() > otra.get_hora_inicio() && materia.get_hora_fin() <= otra.get_hora_fin())
		   )
			return true;
		return false;
	}
	
	/**
	 * Este es el metodo principal que obtiene el coloreo (asignacion de colores a los vertices).
	 * Cada color es representado por un numero.
	 * @return diccionario de colores y listas de vertices.
	 * VER: Coloreo de Grafos, Obtencion de numero cromatico.
	 */
	public TreeMap<Integer, ArrayList<Integer>> obtenerColoreo(){
		TreeMap<Integer, Integer> coloresAsignados = new TreeMap<>();
		obtenerColoresVecinos(coloresAsignados);
		return getColoreo(coloresAsignados);
	}

	/**
	 * Para cada vertice recorre sus vecinos y obtiene sus colores (si tienen), y completa un
	 * diccionario de colores asignados.
	 * @param coloresAsignados diccionario de vertice y color.
	 */
	private void obtenerColoresVecinos(TreeMap<Integer, Integer> coloresAsignados) {
		for (int vertice=0;vertice<this.getVertices();vertice++){
			ArrayList<Integer> coloresVecinos = new ArrayList<>();
			for (Iterator<Integer> vecino = this.getVecinos(vertice).iterator(); vecino.hasNext(); ) {
				coloresVecinos.add(coloresAsignados.get(vecino.next()));
			}
			
			colorear(coloresAsignados, vertice, coloresVecinos);
		}
	}

	/**
	 * Este metodo colorea el vertice en base a los colores de sus vecinos y los que ya estan asignados.
	 * @param coloresVecinos lista de colores vecinos del vertice actual.
	 */
	private void colorear(TreeMap<Integer, Integer> coloresAsignados, int vertice, ArrayList<Integer> coloresVecinos) {
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
	
	/**
	 * Este metodo genera un diccionario ordenado donde la key es el color y value es una lista de vertices.
	 * @return diccionario de color y lista de vertices.
	 */
	private TreeMap<Integer, ArrayList<Integer>> getColoreo(TreeMap<Integer, Integer> coloresAsignados) {
		TreeMap<Integer, ArrayList<Integer>> coloreo = new TreeMap<>();
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

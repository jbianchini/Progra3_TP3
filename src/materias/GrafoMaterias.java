package materias;

import java.util.ArrayList;

import grafo.Grafo;

public class GrafoMaterias extends Grafo {
	private ArrayList<Materia> _materias;
	
	public GrafoMaterias(ArrayList<Materia> materias) { //TODO: el loader de archivos debe 
		super(materias.size());										// checkear los horarios para que sean correctos
		_materias = materias;
		agregarSuperposiciones();
	}
	
	private void agregarSuperposiciones(){
		/*
		 * Si se superpone una materia con otra, agrega la arista
		 */
		for (Materia materia : _materias)
			for (Materia otra : _materias)
				if (!materia.equals(otra) && seSuperpone(materia, otra))
					agregarArista(materia.get_indice(), otra.get_indice());
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
	
}

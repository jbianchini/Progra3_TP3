package loader;

import java.util.ArrayList;

import materias.Materia;

public class ArchivoJSON {
	ArrayList<Materia> _materias;
	
	public ArchivoJSON(ArrayList<Materia> materias){
		_materias = materias;
	}
	
	public ArrayList<Materia> getMaterias(){
		return _materias;
	}
	
}

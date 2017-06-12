package loader;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import materias.Materia;

public class Loader {
		
	public static ArrayList<Materia> obtenerMaterias(String ruta){
		return cargarArchivo(ruta);
	}
	
	/**
	 * Inicializa un GSON e intenta cargarlo en la clase ArchivoJSON
	 * @param ruta es la ruta del archivo.
	 * @return ArrayList de materias. (o null)
	 */
	private static ArrayList<Materia> cargarArchivo(String ruta){
		
		Gson gson = new Gson();
		ArchivoJSON ret = null;
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			ret = gson.fromJson(br, ArchivoJSON.class);
			return ret.getMaterias();
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}

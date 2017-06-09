package materias;

public class Materia {
	private String _nombre;
	private int _hora_inicio;
	private int _hora_fin;
	private int _indice;
	
	//TODO: ver como hacer para poder introducir las horas con regular expression, para evitar que se vayan de rango
	public Materia(String nombre, int hora_inicio, int hora_fin, int indice){
		verificarHorario(hora_inicio, hora_fin);
		_nombre = nombre;
		_hora_inicio = hora_inicio;
		_hora_fin = hora_fin;
		_indice = indice;
	}
	
	private void verificarHorario(int hora_inicio, int hora_fin){
		if (hora_inicio >= hora_fin)
			throw new IllegalArgumentException("Se intento agregar un horario de inicio mayor o igual al de finalizacion.");
		
		// Se debe verificar que la hora de inicio y fin no sea mayor a 24 o menor a 0
	}

	public String get_nombre() {
		return _nombre;
	}

	public void set_nombre(String _nombre) {
		this._nombre = _nombre;
	}

	public int get_hora_inicio() {
		return _hora_inicio;
	}

	public void set_hora_inicio(int _hora_inicio) {
		this._hora_inicio = _hora_inicio;
	}

	public int get_hora_fin() {
		return _hora_fin;
	}

	public void set_hora_fin(int _hora_fin) {
		this._hora_fin = _hora_fin;
	}
	
	public int get_indice() {
		return _indice;
	}

	public void set_indice(int _indice) {
		this._indice = _indice;
	}
	
	public String toString(){
		return _nombre + " " +_hora_inicio+" "+_hora_fin;
	}
	
	
}

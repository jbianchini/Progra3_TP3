package materias;

public class Materia {
	private String _nombre;
	private int _hora_inicio;
	private int _hora_fin;
	
	/*
	 * Materia utiliza dos variables hora de inicio y finalizacion que son numeros enteros. Para realizar
	 * la asignacion, es importante que hora de inicio sea menor.
	 */
	public Materia(String nombre, int hora_inicio, int hora_fin, int indice){
		verificarHorario(hora_inicio, hora_fin);
		_nombre = nombre;
		_hora_inicio = hora_inicio;
		_hora_fin = hora_fin;
	}
	
	/**
	 * Verifica que la hora de inicio no sea mayor a la de finalizacion.
	 * @param hora_inicio integer
	 * @param hora_fin integer
	 */
	private void verificarHorario(int hora_inicio, int hora_fin){
		if (hora_inicio >= hora_fin)
			throw new IllegalArgumentException("Se intento agregar un horario de inicio mayor o igual al de finalizacion.");
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
	
	public String toString(){
		return _nombre + " de " +_hora_inicio+" a "+_hora_fin +"\n";
	}
	
	
}

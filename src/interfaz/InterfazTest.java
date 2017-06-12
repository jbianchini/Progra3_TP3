package interfaz;

import org.junit.Test;

public class InterfazTest {

	@Test
	public void testObtenerItinerario() {
		Interfaz interfaz = new Interfaz();
		Itinerario itinerario = interfaz.ObtenerItinerario("D:/repository/Progra3_TP3/src/archivoPrueba.json");
		System.out.println(itinerario.toString());
	}

}

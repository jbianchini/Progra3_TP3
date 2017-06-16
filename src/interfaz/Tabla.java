package interfaz;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Map.Entry;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import materias.Materia;

import javax.swing.JTable;

public class Tabla extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private  Itinerario _itinerario;
	
	public Tabla(Itinerario itinerario) {
		
		_itinerario = itinerario;
		setBounds(100, 100, 450, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		Dimension pantallaTamano = Toolkit.getDefaultToolkit().getScreenSize(); 
		this.setLocation((pantallaTamano.width/2)-(this.getWidth()/2), (pantallaTamano.height/2)-(this.getHeight()/2)); 
				
		{
			JTable tablaMostrar = new JTable();
	        JScrollPane scrollPanel= new JScrollPane();
	        DefaultTableModel tableModel = new DefaultTableModel(getFilas(),
	                                                             getColumnas());
	 
	        tablaMostrar=new JTable(tableModel){
			
	        private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int vColIndex) {
	            return false;
	        }}; 
	        
	        tablaMostrar.setModel(tableModel);
	        scrollPanel.add(tablaMostrar);
	        this.add(scrollPanel);
	        this.setSize(800, 400);
	        scrollPanel.setViewportView(tablaMostrar);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.WEST);
		}
	}
	
	/**
	 * El metodo hace visible la tabla, para que pueda visualizarse cuando es llamado.
	 */
	public void mostrar(){
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	/**
	 * El metodo recorre un arreglo de filas y columnas, y por cada cambio de materia
	 * llena una fila nueva con el nombre y los horarios.
	 * @return tabla armada, llena con nombre de aula y materias que contiene.
	 */
	private Object[][] getFilas(){
		Object tabla [][] = new Object [_itinerario.getMateriasSize()][2];

		int i = 0;
		for(Entry<String, ArrayList<Materia>> asignacion: _itinerario.obtenerItinerario().entrySet()){
			tabla[i][0] = asignacion.getKey();
			for (int j=0;j<asignacion.getValue().size();j++){
				tabla[i][1] = asignacion.getValue().get(j);
				i++;
				
			}
		}  return tabla;
	}
	
	private String[] getColumnas(){
	          String columna[] = new String[]{"Aula","Materias"};
	          return columna;
	}


}

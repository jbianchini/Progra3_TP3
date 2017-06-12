package interfaz;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
			JTable tblEjemplo = new JTable();
	        JScrollPane scpEjemplo= new JScrollPane();
	        DefaultTableModel dtmEjemplo = new DefaultTableModel(getFilas(),
	                                                             getColumnas());
	 
	        tblEjemplo=new JTable(dtmEjemplo){
			
	        private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int rowIndex, int vColIndex) {
	            return false;
	        }}; 
	        
	        tblEjemplo.setModel(dtmEjemplo);
	        scpEjemplo.add(tblEjemplo);
	        this.add(scpEjemplo);
	        this.setSize(500, 300);
	        scpEjemplo.setViewportView(tblEjemplo);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.WEST);
		}
	}
	
	public void mostrar(){
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	private Object[][] getFilas(){
		Object fila [][] = new Object [_itinerario.getMateriasSize()][2];

		int i = 0;
		for(Entry<String, ArrayList<Materia>> asignacion: _itinerario.getItinerario().entrySet()){
			fila[i][0] = asignacion.getKey();
			for (int j=0;j<asignacion.getValue().size();j++){
				fila[i][1] = asignacion.getValue().get(j);
				i++;
				
			}
		}  return fila;
	}
	
	private String[] getColumnas(){
	          String columna[] = new String[]{"Aula","Materias"};
	          return columna;
	}


}

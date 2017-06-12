package interfaz;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import java.io.File;       

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ventana {

	private JFrame frame;
	private JTextField campoRuta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 481, 193);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton botonMostrar = new JButton("Ver asignacion");
		botonMostrar.setBounds(145, 120, 167, 23);
		frame.getContentPane().add(botonMostrar);
		
		JLabel lblArchivoJson = new JLabel("Archivo JSON");
		lblArchivoJson.setBounds(28, 42, 84, 14);
		frame.getContentPane().add(lblArchivoJson);
		
		campoRuta = new JTextField();
		campoRuta.setBounds(111, 39, 245, 20);
		frame.getContentPane().add(campoRuta);
		campoRuta.setColumns(10);
		
		JButton botonSeleccionar = new JButton("Seleccionar Archivo");
		botonSeleccionar.setBounds(168, 70, 125, 23);
		frame.getContentPane().add(botonSeleccionar);
		
		
		// ACTION LISTENERS
		
		botonSeleccionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				int result = fileChooser.showOpenDialog(frame);
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    campoRuta.setText(selectedFile.getAbsolutePath());
				}
			}
		});
		
		botonMostrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarTabla(campoRuta.getText());
			}
		});
		
	}
	
	private void mostrarTabla(String ruta){
		ruta = formatearRuta(ruta);
		Interfaz interfaz = new Interfaz();
		Tabla tabla = new Tabla(interfaz.ObtenerItinerario(ruta));
		tabla.mostrar();
	}
	
	private String formatearRuta(String ruta){
		return ruta.replace('\\', '/');
	}
}

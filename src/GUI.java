
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
	
	private JTextField textExtension;
	private JLabel lblTitulo, lblTamaño, lblExtensiones, lblRuta;
	private JTextPane txtArchivos, txtTamaños;
	private JButton btnSeleccionador, btnCalcular;
	private Logica logica;
	private OyenteCalcular oyente;
	private OyenteSeleccionar oyenteSeleccionador = new OyenteSeleccionar(this);
	
	public GUI(Logica logica) {
		getContentPane().setBackground(new Color(255, 213, 234));
		getContentPane().setLayout(null);
		this.logica = logica;
		setSize(700, 500);
		setResizable(false);
		init();
	}
	
	private void init() {
		oyente = new OyenteCalcular(this, logica);
		textExtension = new JTextField();
		textExtension.setFont(new Font("Tahoma", Font.BOLD, 16));
		textExtension.setBounds(279, 89, 146, 28);
		getContentPane().add(textExtension);
		textExtension.setColumns(10);
		
		textExtension.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				logica.setExtension(textExtension.getText());
				oyente.actionPerformed(e);
			}
			
		});
		
		btnSeleccionador = new JButton("Seleccionar carpeta:");
		btnSeleccionador.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSeleccionador.setBounds(33, 36, 231, 28);
		getContentPane().add(btnSeleccionador);
		
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCalcular.setBounds(33, 145, 392, 28);
		getContentPane().add(btnCalcular);
		btnCalcular.setEnabled(false);
		
		lblTitulo = new JLabel("10 Archivos mas grandes:");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setBounds(33, 205, 253, 21);
		getContentPane().add(lblTitulo);
		
		lblTamaño = new JLabel("Tamaño (en bytes)");
		lblTamaño.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTamaño.setBounds(351, 201, 219, 28);
		getContentPane().add(lblTamaño);
		
		txtArchivos = new JTextPane();
		txtArchivos.setBackground(new Color(255, 185, 220));
		txtArchivos.setBounds(43, 236, 200, 204);
		getContentPane().add(txtArchivos);
		
		txtTamaños = new JTextPane();
		txtTamaños.setBackground(new Color(255, 185, 220));
		txtTamaños.setBounds(351, 239, 189, 201);
		getContentPane().add(txtTamaños);
		
		lblExtensiones = new JLabel("Ingrese la extension:");
		lblExtensiones.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblExtensiones.setBounds(33, 89, 231, 28);
		getContentPane().add(lblExtensiones);
		
		lblRuta = new JLabel("");
		lblRuta.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRuta.setBounds(279, 36, 324, 28);
		getContentPane().add(lblRuta);
		

		btnCalcular.addActionListener(oyente);
		btnSeleccionador.addActionListener(oyenteSeleccionador);

		setVisible(true);
	}
	
	
	public void setText(String ruta) {
		lblRuta.setText(ruta);
		btnCalcular.setEnabled(true);
	}
	
	public void setArchivo(File archivo) {
		oyente.setArchivo(archivo);
	}
	
	public void escribir(String archivo, long tamaño) {
		txtTamaños.setText(txtTamaños.getText() + " \n" + tamaño);
		txtArchivos.setText(txtArchivos.getText() + " \n " + archivo);
	}
	public void limpiar() {
		txtTamaños.setText("");
		txtArchivos.setText("");
		
	}
}
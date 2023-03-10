
import java.awt.event.*;
import java.io.File;

import javax.swing.JFileChooser;


public class OyenteSeleccionar implements ActionListener {
	
	protected GUI gui;
	
	public OyenteSeleccionar(GUI gui) {
		this.gui = gui;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser seleccionador= new JFileChooser();
		seleccionador.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int verdadero = seleccionador.showSaveDialog(null);
		if(verdadero == JFileChooser.APPROVE_OPTION) {
			File carpeta = new File(seleccionador.getSelectedFile().getAbsolutePath());
			String ruta = carpeta.getAbsolutePath();
			gui.setText(ruta);
			gui.setArchivo(carpeta);
		}
	}
}

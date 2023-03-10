
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
public class OyenteCalcular implements ActionListener{
	
	private File archivo;
	private GUI ventana;
	private Logica logica;
	
	public OyenteCalcular(GUI ventana, Logica logica) {
		this.ventana = ventana;
		this.logica = logica;
	}
	
	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}
	public void actionPerformed(ActionEvent e) {
		
		ventana.limpiar();
		
		//Recorro un arreglo clonado, para no afectar a los archivos originales.
		//Pregunto si la extension es vacia, y si no lo es, seteo nulo a los archivos que no terminen con esa extension.
		File[] archivosCarpeta = archivo.listFiles();
		File[] archivosUsar = archivosCarpeta.clone();
		archivosUsar = logica.ordenarArray(archivosUsar);
		
		if (logica.getExtension() != null && logica.getExtension() != "" ) {
			for (int i = 0; i < archivosCarpeta.length; i++) {
				String archivoInspeccionar = archivosCarpeta[i].getName();
				if (archivoInspeccionar.endsWith(logica.getExtension())) {
					ventana.escribir(archivoInspeccionar, archivosCarpeta[i].length());
				}
			}
		}else {
			//ordeno el arreglo, ya que quiero mostrarlo de forma descendente y por default esta de forma ascendente
			for (File f:archivosUsar) {
				ventana.escribir(f.getName(), f.length());
			}
		}
	}
}




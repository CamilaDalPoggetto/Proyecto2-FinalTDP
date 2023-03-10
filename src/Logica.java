
import java.io.File;

/**
 * Resposabilidades: ordenar el arreglo de archivos de manera descendente, y mantener una referencia a la extension
 * 
 *
 */
public class Logica {
	private String extension;
	
	
	public Logica() {
		
	}
	
	public void setExtension(String e) {
		extension = e;
	}
	public String getExtension() {
		return extension;
	}
	public File[] ordenarArray(File[] archivos) {
		
		File[] archivoRetorno = new File[10];
		//tengo el nombre y el tamaño del archivo, tengo que ordenarlos segun el tamaño
		
		for (int i = 0; i < archivos.length; i++) {
	        for (int j = i + 1; j < archivos.length; j++) {
	            File tmp = null;
	            if (archivos[i] !=null && archivos[j]!=null) {
		            if (archivos[i].length() < archivos[j].length()) { //uno es mas grande que el otro
		                tmp = archivos[i];      
		                archivos[i] = archivos[j];
		                archivos[j] = tmp;
		            }
	            }
	        }
	    }
		//Luego de ordenar, guardo solo los primeros 10 lugares 
		for (int i = 0; i < 10 && i < archivos.length; i++) {
		  archivoRetorno[i] = archivos[i];
		 }
		return archivoRetorno;
	}
}
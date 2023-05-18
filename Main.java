import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
        Matrix_colector("adjacency_matrix.txt");
		
	}
	public static void Matrix_colector(String ruta) { 
    try {
        File archivo = new File(ruta);
        try (Scanner myReader = new Scanner(archivo)) {
			ArrayList<String []> matrix = new ArrayList<String []>();
			while (myReader.hasNextLine()) {
			    String dato = myReader.nextLine();
			    String[] linea=dato.split(" "); 
			    matrix.add(linea);
			}

			for (String [] fila : matrix) {
			    for (String elemento : fila) {
			        System.out.print(elemento + " ");
			    }
			    System.out.println(); // Salto de línea después de cada fila
			}
		}
    } catch (FileNotFoundException e) {
        System.out.println("El archivo no existe");
    }
	Floyd floyd = new Floyd<>();
	}
}
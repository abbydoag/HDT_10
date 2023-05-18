import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String[]> datos = Matrix_colector("adjacency_matrix.txt");
        int y = datos.size();
        int x = 5;
        
		
	}



	public static ArrayList<String []> Matrix_colector(String ruta) { 
    try {
        File archivo = new File(ruta);
        try (Scanner myReader = new Scanner(archivo)) {
			ArrayList<String []> matrix = new ArrayList<String []>();
			while (myReader.hasNextLine()) {
			    String dato = myReader.nextLine();
			    String[] linea=dato.split(" "); 
			    matrix.add(linea);
			}
			return matrix;
			}
		}
     catch (FileNotFoundException e) {
        System.out.println("El archivo no existe");
        ArrayList<String []> matrix = new ArrayList<String []>(); 
        return matrix ;
    }
	}
}
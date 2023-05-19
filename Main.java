import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List; 

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String[]> datos = Matrix_colector("adjacency_matrix.txt");
        int y = datos.size();
        int x = 5;
        HashMap<String, List<Arista>> cities = new HashMap<>();

        for (int i = 1; i < y; i++) {
            String[] fila = datos.get(i);
            String origin =fila[0].trim();
            String destino = fila[1].trim();
            int a = Integer.parseInt(fila[2]);
            int a1 = Integer.parseInt(fila[3]);
            int a2 = Integer.parseInt(fila[4]);
            int a3 = Integer.parseInt(fila[5]);

            Arista arista = new Arista(destino,a,a1,a2,a3);
            
            if (cities.containsKey(origin)) {
                // Si la clave existe, obtener la lista asociada
                List<Arista> lista = cities.get(origin);
                // Agregar el nuevo objeto a la lista
                
                lista.add(arista);
                System.out.println("Poto2" );
                cities.put(origin, lista);
            } else {
                // Si la clave no existe, crear una nueva lista, agregar el nuevo objeto y asociarla a la clave
                List<Arista> nuevaLista = new ArrayList<>();
                nuevaLista.add(arista);
                System.out.println("Poto1" );
                cities.put(origin, nuevaLista);
            }

          
            
          }

          for (String entry :  cities.keySet()) {
            String key = entry;
            List<Arista> lista =  cities.get(key);
            System.out.println("Clave: " + key );
            for (int p = 0; p < lista.size(); p++) {
                Arista elemento = lista.get(p);
                System.out.println(elemento.getCiudadDestino());
            }
            ;
        }
        
		
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
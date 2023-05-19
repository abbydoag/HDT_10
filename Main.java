import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.List; 
import java.util.HashSet;
import java.util.Collections;
public class Main {
	public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String[]> datos = Matrix_colector("adjacency_matrix.txt");

        HashMap<String, List<Arista>> cities=HashCreator(datos);
        ArrayList<String>nodos =  Nodos(datos);
        Graph distancias = new Graph(nodos);
        distancias.agregarAristas(cities);
        distancias.floid();
        distancias.show();
        
       
        
        
		
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

    public static ArrayList<String> Nodos(ArrayList<String []> datos){
        int y = datos.size();
        int x = 5;
        ArrayList<String> nombres = new ArrayList<String>(); 
        for (int i = 1; i < y; i++) {
            String[] fila = datos.get(i);
            String origin =fila[0].trim();
            String destino = fila[1].trim();
            nombres.add(origin);
            nombres.add(destino);
    }
    HashSet<String> conjunto = new HashSet<>(nombres);
    ArrayList<String> listaSinDuplicados = new ArrayList<>(conjunto);
    Collections.sort(listaSinDuplicados);
    return listaSinDuplicados;
}

public static HashMap<String, List<Arista>> HashCreator(ArrayList<String[]> datos){

    
    int y = datos.size();
    int x = 5;
    HashMap<String, List<Arista>> cities = new HashMap<>();

    for (int i = 1; i < y; i++) {
        String[] fila = datos.get(i);
        String origin =fila[0].trim();
        String destino = fila[1].trim();
        int a = Integer.parseInt(fila[2].trim());
        int a1 = Integer.parseInt(fila[3].trim());
        int a2 = Integer.parseInt(fila[4].trim());
        int a3 = Integer.parseInt(fila[5].trim());

        Arista arista = new Arista(destino,a,a1,a2,a3);
        
        if (cities.containsKey(origin)) {
            // Si la clave existe, obtener la lista asociada
            List<Arista> lista = cities.get(origin);
            // Agregar el nuevo objeto a la lista
            
            lista.add(arista);
            cities.put(origin, lista);
        } else {
            // Si la clave no existe, crear una nueva lista, agregar el nuevo objeto y asociarla a la clave
            List<Arista> nuevaLista = new ArrayList<>();
            nuevaLista.add(arista);
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
        
    }

    return cities;
}

}
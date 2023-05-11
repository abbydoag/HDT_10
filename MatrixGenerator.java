import java.io.FileWriter;
import java.io.IOException;

class MatrixGenerator {
  public static void main(String[] args) {
    String[] cities = { "NewYork", "London", "Paris", "Tokyo" , "Tamaulipas","Guastatoya","Bibirlihils"};
    int numCities = cities.length;

    String[][] adjacencyMatrix = new String[numCities + 1][numCities + 1];

    // Agregar nombres de ciudades en la primera columna y primera fila
    adjacencyMatrix[0][0] = "Ciudades";
    for (int i = 1; i <= numCities; i++) {
      adjacencyMatrix[0][i] = cities[i - 1];
      adjacencyMatrix[i][0] = cities[i - 1];
    }

    // Generar matriz de adyacencia con pesos aleatorios
    for (int i = 1; i <= numCities; i++) {
      for (int j = 1; j <= numCities; j++) {
        if (i == j) {
          adjacencyMatrix[i][j] = "0"; //Tenemos que agregar la condicion en la que viajar a un mismo pais pese 0
        }
        else if ((int) (Math.random() * 100) + 1 < 10 ) { // Para agregar realismo a la simulacion el grafo no estara completamente conectado
            adjacencyMatrix[i][j] = Integer.toString(99999);


        } 
        else {
          int weight = (int) (Math.random() * 100) + 1; // Peso aleatorio entre 1 y 100
          adjacencyMatrix[i][j] = Integer.toString(weight);
        }
      }
    }

    // Guardar la matriz de adyacencia en un archivo de texto
    String fileName = "adjacency_matrix.txt";
    try {
      FileWriter writer = new FileWriter(fileName);
      for (int i = 0; i <= numCities; i++) {
        for (int j = 0; j <= numCities; j++) {
          writer.write(adjacencyMatrix[i][j] + " ");
        }
        writer.write("\n");
      }
      writer.close();
      System.out.println("Matriz de adyacencia guardada en el archivo: " + fileName);
    } catch (IOException e) {
      System.out.println("Error al guardar la matriz de adyacencia en el archivo: " + fileName);
      e.printStackTrace();
    }
  }
}

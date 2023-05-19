import java.util.HashMap;
import java.util.Collections;

public class Graph implements iGraph {

   
    private int numVertices;
    private int[][] matrizAdy;
    private int[][] Z;
    private HashMap<Integer,String> map;

    public void Grafo(int numVertices) {
        this.numVertices = numVertices;
        this.matrizAdy = new int[numVertices][numVertices];
        // Inicializa la matriz de adyacencia con valores infinitos
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                matrizAdy[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    // Método para agregar una arista al grafo
    public void agregarArista(int origen, int destino, int peso) {
        matrizAdy[origen][destino] = peso;
    }

    // Método para obtener el número de vértices del grafo
    public int getNumVertices() {
        return numVertices;
    }

    // Método para obtener la matriz de adyacencia del grafo
    public int[][] getMatrizAdy() {
        return matrizAdy;
    }
    
}

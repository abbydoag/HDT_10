import java.io.*;
import java.lang.*;
import java.util.*;

class AllPairShortestPath {
    final static int INF = 99999, V = 4;
    int [][]adyacencia;
    int [][] ruta;


    void floydWarshall(int dist[][], int Z[][]) {

        int i, j, k;
        this.adyacencia = dist;
        this.ruta = Z;

        /* Agregar todos los vértices uno por uno
           al conjunto de vértices intermedios.
          ---> Antes de comenzar una iteración,
               tenemos las distancias más cortas
               entre todos los pares de vértices de manera que
               las distancias más cortas solo consideran
               los vértices en el conjunto {0, 1, 2, .. k-1} como
               vértices intermedios.
          ----> Después de terminar una iteración,
                se agrega el vértice número k
                al conjunto de vértices intermedios y el conjunto
                se convierte en {0, 1, 2, .. k} */
        for (k = 0; k < V; k++) {
            // Elegir todos los vértices como fuente uno por uno
            for (i = 0; i < V; i++) {
                // Elegir todos los vértices como destino para la
                // fuente elegida anteriormente
                for (j = 0; j < V; j++) {
                    // Si el vértice k está en el camino más corto
                    // desde i hasta j, entonces actualiza el valor de
                    // dist[i][j]
                    final int INF = Integer.MAX_VALUE;
 
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j] && (k != j || k!=i || i!=j) ) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        Z[i][j]= Z[k][j];

                    }
                }
            }
        }

        this.adyacencia = dist;
        this.ruta = Z;
    }
    

    public int[][] returndistancia() {
        return adyacencia;
    }

    public int[][] returnz() {
        return this.ruta;
    }

    // Código del controlador
    
}

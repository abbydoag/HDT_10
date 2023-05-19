import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;

public class Graph implements iGraph {

   
    private int numVertices;
    private int[][] matrizAdy;
    private int[][] Z;
    private String[][] tiempos;
    private HashMap<Integer,String> map;
    private HashMap<String,Integer> invmap;


    public Graph(ArrayList<String>nodos) {
        this.map = new HashMap<Integer,String>();
        this.invmap = new HashMap<String,Integer>();
        this.numVertices = nodos.size();
        this.matrizAdy = new int[numVertices][numVertices];
        this.tiempos = new String[numVertices][numVertices];
        this.Z = new int[numVertices][numVertices];
        // Inicializa la matriz de adyacencia con valores infinitos
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (i ==j){
                    matrizAdy[i][j] = 0;
                }

                else {
                    matrizAdy[i][j] = Integer.MAX_VALUE;

                }
                
                tiempos[i][j] = "normal";
                Z[i][j] = i;
            }
        }
        setmap(nodos);

    }

    // Método para agregar una arista al grafo
    public void agregarAristas(HashMap<String, List<Arista>> datos)  {
        int y=map.size();
        for (int i = 0; i < y; i++) {
            String origen=map.get(i);
            if(datos.get(origen)!=null){
                List<Arista> fila=datos.get(origen);
                for (int z = 0; z < fila.size(); z++) {
                    Arista elemento = fila.get(z);
                    int destino = invmap.get(elemento.getCiudadDestino());
                    Random random = new Random();
                    int numeroRandom = random.nextInt(4) + 1; // Genera un número aleatorio entre 1 y 4
                    int peso = 0;
                    switch (numeroRandom) {
                        case 1:
                            peso= elemento.getTiempoNormal() ;
                            tiempos[i][destino] = "normal";
                            break;
                        case 2:
                            peso = elemento.getTiempoLluvia() ;
                            tiempos[i][destino] = "Lluvia";
                            break;
                        case 3:
                            peso = elemento.getTiempoNieve() ;
                            tiempos[i][destino] = "Nieve";
                            break;
                        case 4:
                            peso = elemento.getTiempoTormenta() ; 
                            tiempos[i][destino] = "Tormenta";
                            break;
                        }

                        matrizAdy[i][destino] = peso;
                    }
            }
        }   
    }

    private void setmap(ArrayList<String>nodos) {
        for (int i = 0; i < nodos.size(); i++) {
            String item = nodos.get(i);
            this.map.put(i,item);
            this.invmap.put(item,i);
        }
        
    }

    // Método para obtener el número de vértices del grafo
    public int getNumVertices() {
        return numVertices;
    }

    // Método para obtener la matriz de adyacencia del grafo
    public int[][] getMatrizAdy() {
        return matrizAdy;
    }

    public String[][] getMatritiempos() {
        return tiempos;
    }

    public int[][] getZ() {
        return Z;
    }

    public void setMatrizAdy(int[][] matrizAdy) {
        this.matrizAdy = matrizAdy;
    }
    
    public void setMatritiempos(String[][] tiempos) {
        this.tiempos = tiempos;
    }
    
    public void setZ(int[][] Z) {
        this.Z = Z;
    }
     public void floid(){
        AllPairShortestPath a = new AllPairShortestPath();
        a.floydWarshall(this.matrizAdy,this.Z);
        this.matrizAdy = a.returndistancia(); 
        this.Z = a.returnz();
     }

     public void show(){
        System.out.println("Origen");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(map.get(i) + " ");
            for (int j = 0; j < numVertices; j++) {
                int z=this.Z[i][j];
                System.out.print("");
                System.out.print(map.get(z)+" ");           
            }  
            System.out.println("");
        }
        
     }



    
}

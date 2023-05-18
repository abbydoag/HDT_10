public interface iGraph {

    public void Grafo(int numVertices) ;
    public void agregarArista(int origen, int destino, int peso); 
    public int getNumVertices();
    public int[][] getMatrizAdy();
    
}

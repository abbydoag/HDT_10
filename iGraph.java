import java.util.HashMap;
import java.util.List;

public interface iGraph {

   
    public void agregarAristas(HashMap<String, List<Arista>> datos); 
    public int getNumVertices();
    public int[][] getMatrizAdy();
    
}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	private static String readData(String dataFile) throws FileNotFoundException {
		BufferedReader dataScan = new BufferedReader(new FileReader(dataFile));
		String data = "";
		
		try { 
			data = dataScan.readLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(data);		
		return data;
	}

	public static void main(String[]args) throws FileNotFoundException{
        String cities = readData("adjacency_matrix.txt");
        String graph = matrixBuilder(cities);
    }
    private static String matrixBuilder(String cities){
        for (int i=0; i < cities.length(); i++) {
			char character = cities.charAt(i);
			if(character == ' ') {
				continue;
			}
			if (Character.isDigit(character)){
				String c = "" + character;
				int parsedNumber = Integer.parseInt(c);
			}
        }
        return cities;
    }
}
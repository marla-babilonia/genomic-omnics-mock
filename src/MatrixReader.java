import java.io.*;
import java.util.ArrayList;

public class MatrixReader {

    //create readMatrixFromFile method
    public static ArrayList<ArrayList<Integer>> readMatrixFromFile(String fileName){
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        //open file and read
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            //go line for line
            while((line = br.readLine()) != null){
                //remove brackets
                line = line.replace("[", "").replace("]", "").trim();
                //split by commas
                String[] values = line.split(",");
                //create new row list and go adding each value (0 or 1) from values
                ArrayList<Integer> row = new ArrayList<>();
                for (String value : values){
                    row.add(Integer.parseInt(value.trim()));
                }
                matrix.add(row);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return matrix;
    }
    
}

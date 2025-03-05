import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class MatrixHandler {
    
    //change these to the path of the tester files - just here to make my life easier
    private static final String TesterFileName1 = "/home/fslabs/ds_051_9/Desktop/investigacion/test1/ogMatrix-tester.txt";
    private static final String TesterFileName2 = "/home/fslabs/ds_051_9/Desktop/investigacion/test1/ogMatrixTester-4-geneAddition.txt";

    /**
     * GetMatrixFromUser method
     * Reads a matrix file from an user input
     * 
     * @param scanner Scanner object for user input
     * @param prompt Message displayed to user
     * @param testerFile Predefined tester file path
     * @return the matrix as an array list of array list of integers
     */

     public static ArrayList<ArrayList<Integer>> getMatrixFromUser(Scanner scanner, String prompt) {
        System.out.println(prompt);
        String userInput = scanner.nextLine().trim();

        // check if the selected a tester file and determine which file to use
        String filename;
        if (userInput.equalsIgnoreCase("tester1")){
            filename = TesterFileName1;
        } else if (userInput.equalsIgnoreCase("tester2")){
            filename = TesterFileName2;
        } else {
            filename = userInput;
        }

        //check if the file exist, ask user for a new path if missing
        while (!new File(filename).exists()) {
            System.err.println("File does not exist, enter correct file path");
            filename = scanner.nextLine().trim(); 
        }

        return MatrixReader.readMatrixFromFile(filename);
     }


     /**
      * PrintMatrixMethod
      * prints matrix
      *
      *@param matrix is the matrix to be printed
      *@param matrixname is the name to display for the matrix
      */

      public static void printMatrix(ArrayList<ArrayList<Integer>> matrix, String matrixname){
        System.out.println("\n" + matrixname);
        for (ArrayList<Integer> row : matrix){
            System.out.println(row);
        }
      }
     
}

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //get the original matrix
        ArrayList<ArrayList<Integer>> ogMatrix = MatrixHandler.getMatrixFromUser(scanner, "Enter the original file path");

        //get the second matrix (to compare)
        ArrayList<ArrayList<Integer>> comparisonMatrix = MatrixHandler.getMatrixFromUser(scanner, "Enter the comparison file path");

        //print both matrices
        MatrixHandler.printMatrix(ogMatrix, "Original Matrix: ");
        MatrixHandler.printMatrix(comparisonMatrix, "Comparison Matrix: ");

        //get the changes
        MatrixComparison comparison = new MatrixComparison();
        comparison.compareMatrices(ogMatrix, comparisonMatrix);
        comparison.printComparisonResults();
    }
}

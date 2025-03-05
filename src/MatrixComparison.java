import java.util.ArrayList;

public class MatrixComparison {
    private int insertions = 0;
    private int deletions = 0;
    private int newGenes = 0;
    private int totalChanges;
    
    /**
     * Compares two matrices and counts insertions, deletions, and new genes.
     *
     * @param originalMatrix The original matrix
     * @param comparisonMatrix The matrix being compared
     */
    public void compareMatrices(ArrayList<ArrayList<Integer>> originalMatrix, ArrayList<ArrayList<Integer>> comparisonMatrix) {
        int originalRows = originalMatrix.size();
        int comparisonRows = comparisonMatrix.size();
        int originalCols = originalRows > 0 ? originalMatrix.get(0).size() : 0;
        int comparisonCols = comparisonRows > 0 ? comparisonMatrix.get(0).size() : 0;

        // Count new genes (additional rows in comparison matrix)
        if (comparisonRows > originalRows) {
            newGenes += (comparisonRows - originalRows);
        }

        // Iterate through both matrices to count insertions and deletions
        for (int i = 0; i < Math.max(originalRows, comparisonRows); i++) {
            for (int j = 0; j < Math.max(originalCols, comparisonCols); j++) {
                int originalValue = (i < originalRows && j < originalCols) ? originalMatrix.get(i).get(j) : 0;
                int comparisonValue = (i < comparisonRows && j < comparisonCols) ? comparisonMatrix.get(i).get(j) : 0;

                // If comparison has a 1 where original has a 0 → Insertion
                if (comparisonValue == 1 && originalValue == 0) {
                    insertions++;
                }

                // If comparison has a 0 where original has a 1 → Deletion
                if (comparisonValue == 0 && originalValue == 1) {
                    deletions++;
                }
            }
        }

        totalChanges = insertions + deletions + newGenes;
    }

    /**
     * Prints the results of the matrix comparison.
     */
    public void printComparisonResults() {
        System.out.println("\nMatrix Comparison Results:");
        System.out.println("Insertions: " + insertions);
        System.out.println("Deletions: " + deletions);
        System.out.println("New Genes: " + newGenes);
        System.out.println("Total: " + totalChanges);
    }
}
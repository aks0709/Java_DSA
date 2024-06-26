package Graph;

public class FloydWarshalAlgo
{

//User function template for JAVA

    class Solution
    {
        public void shortest_distance(int[][] matrix)
        {
            // Code here
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == -1) {
                        matrix[i][j] = (int)(1e9);
                    }
                    if (i == j) matrix[i][j] = 0;
                }
            }

            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = Math.min(matrix[i][j],
                                matrix[i][k] + matrix[k][j]);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == (int)(1e9)) {
                        matrix[i][j] = -1;
                    }
                }
            }

            //to detect a negative cycle in graph
            for (int i=0;i<n;i++){
                if (matrix[i][i]<0)
                {
                    System.out.println("NEGATIVE CYCLE EXSIST");
                }
            }

        }
    }
}

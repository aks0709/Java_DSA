package Stack.Revision;

import java.util.Stack;

public class MaximalRectangle {
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0; // Handle empty matrix edge case
            }

            int n = matrix.length;
            int m = matrix[0].length;

            // Convert character matrix to integer matrix
            int[][] intMatrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    intMatrix[i][j] = matrix[i][j] - '0';
                }
            }

            // Compute column-wise prefix sums
            int[][] prefixSum = new int[n][m];
            for (int j = 0; j < m; j++) {
                prefixSum[0][j] = intMatrix[0][j];
                for (int i = 1; i < n; i++) {
                    if (intMatrix[i][j] == 1) {
                        prefixSum[i][j] = prefixSum[i - 1][j] + 1;
                    } else {
                        prefixSum[i][j] = 0; // Reset to 0 for consecutive 1s only
                    }
                }
            }

            // Calculate the maximum area using the largest rectangle in histogram method
            int maxArea = 0;
            for (int i = 0; i < n; i++) {
                int area = maxAreaInHistogram(prefixSum[i]);
                maxArea = Math.max(maxArea, area);
            }

            return maxArea;
        }

        public static int maxAreaInHistogram(int[] heights) {
            int n = heights.length;
            int[] nse = new int[n]; // Next Smaller Element
            int[] pse = new int[n]; // Previous Smaller Element
            Stack<Integer> stack = new Stack<>();

            // Compute PSE
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                pse[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }

            stack.clear(); // Reuse stack for NSE

            // Compute NSE
            for (int i = n - 1; i >= 0; i--) {
                while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                    stack.pop();
                }
                nse[i] = stack.isEmpty() ? n : stack.peek();
                stack.push(i);
            }

            // Compute maximum area
            int maxArea = 0;
            for (int i = 0; i < n; i++) {
                int width = nse[i] - pse[i] - 1;
                int area = heights[i] * width;
                maxArea = Math.max(maxArea, area);
            }

            return maxArea;
        }
    }

}

package preRequisites.Arrays;
import java.util.*;
public class PrefixProduct {

     class Solution {

        public static int[] prefixProduct(int[] arr) {
            int n = arr.length;

            // Arrays to store left and right products
            int[] leftProduct = new int[n];
            int[] rightProduct = new int[n];
            int[] result = new int[n];

            // Initialize the first element of leftProduct to 1 (no elements to the left of index 0)
            leftProduct[0] = 1;

            // Fill leftProduct such that leftProduct[i] contains the product of all elements to the left of arr[i]
            for (int i = 1; i < n; i++) {
                leftProduct[i] = leftProduct[i - 1] * arr[i - 1];
            }

            // Initialize the last element of rightProduct to 1 (no elements to the right of the last index)
            rightProduct[n - 1] = 1;

            // Fill rightProduct such that rightProduct[i] contains the product of all elements to the right of arr[i]
            for (int i = n - 2; i >= 0; i--) {
                rightProduct[i] = rightProduct[i + 1] * arr[i + 1];
            }

            // Multiply the left and right products to get the result for each index
            for (int i = 0; i < n; i++) {
                result[i] = leftProduct[i] * rightProduct[i];
            }

            return result;
        }

        public static void main(String[] args) {
            int[] arr = {1, 2, 3, 4, 5};
            int[] result = prefixProduct(arr);
            System.out.println("Prefix product excluding current index: " + Arrays.toString(result));
        }
    }

}

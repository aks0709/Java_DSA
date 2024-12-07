package Stack.Revision;

import java.util.Stack;

public class RemoveK_Digits {
    class Solution {
        public String removeKdigits(String num, int k) {
            if (k >= num.length()) {
                return "0"; // If we remove all digits, return "0".
            }

            Stack<Character> st = new Stack<>();

            for (char digit : num.toCharArray()) {
                // Remove digits from the stack if:
                // - The stack is not empty.
                // - We still need to remove more digits (k > 0).
                // - The top of the stack is greater than the current digit.
                while (!st.isEmpty() && k > 0 && st.peek() > digit) {
                    st.pop();
                    k--;
                }
                st.push(digit);
            }

            // If k > 0 after the loop, remove the remaining digits from the end.
            while (k > 0) {
                st.pop();
                k--;
            }

            // Build the result string from the stack.
            StringBuilder sb = new StringBuilder();
            while (!st.isEmpty()) {
                sb.append(st.pop());
            }
            sb.reverse(); // Reverse to get the correct order.

            // Remove leading zeros from the result.
            while (sb.length() > 0 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }

            // If the result is empty, return "0".
            return sb.length() == 0 ? "0" : sb.toString();
        }
    }

}

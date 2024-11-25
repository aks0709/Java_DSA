package Stack.Revision;

import java.util.ArrayList;
import java.util.Stack;

public class NextSmallerElement {
    class Solution {
        public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
            Stack<Integer> st = new Stack<>();
            ArrayList<Integer> res = new ArrayList<>();

            for (int i = 0; i < A.size(); i++) {
                // Pop elements from the stack until we find a smaller element or the stack becomes empty
                while (!st.isEmpty() && st.peek() >= A.get(i)) {
                    st.pop();
                }

                // If stack is empty, no smaller element exists; otherwise, take the top of the stack
                if (st.isEmpty()) {
                    res.add(-1);
                } else {
                    res.add(st.peek());
                }

                // Push the current element onto the stack
                st.push(A.get(i));
            }

            return res;
        }
    }

}

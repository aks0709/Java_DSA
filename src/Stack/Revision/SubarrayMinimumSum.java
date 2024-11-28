package Stack.Revision;

import java.util.Stack;

public class SubarrayMinimumSum {
    class Solution {
        public int sumSubarrayMins(int[] arr) {


            //the idea is to find the nge smaller element and previous smaller element regarding each element
            int mod = (int)(1e9 + 7);
            int n=arr.length;
            int nse[]=new int[n];   //if no  nse in right then put N
            int pse[]=new int[n];    //if no pse in left then put -1
            Stack<Integer> st=new Stack<>();
            for(int i=n-1;i>=0;i--){
                while(!st.isEmpty()&& arr[st.peek()]>=arr[i])
                    st.pop();

                if(!st.isEmpty())
                    nse[i]=st.peek();
                else
                    nse[i]=n;

                st.push(i);
            }

            Stack<Integer> st2=new Stack<>();
            for(int i=0;i<n;i++){
                while(!st2.isEmpty()&& arr[st2.peek()]>arr[i])   //equal element edge case
                    st2.pop();

                if(!st2.isEmpty())
                    pse[i]=st2.peek();
                else
                    pse[i]=-1;

                st2.push(i);
            }
            long total = 0;
            for (int i = 0; i < n; i++) {
                long count = ((long)(i - pse[i]) * (nse[i] - i)) % mod; // Number of subarrays where arr[i] is the minimum
                total = (total + count * arr[i]) % mod;
            }
            return (int)(total);
        }
    }
}

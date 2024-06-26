package PP.Day9;

import java.util.Stack;

public class MinStack
{
    public class Pair {
        public int first;
        public int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    class MinStack2 {
        Stack<Pair> st=new Stack<Pair>();
        public MinStack2() {

        }

        public void push(int val) {
            if(st.isEmpty()){
                st.push(new Pair(val,val));
            }
            else{
                if(val<st.peek().second)
                    st.push(new Pair(val,val));
                else
                    st.push(new Pair(val,st.peek().second));
            }
        }

        public void pop() {
            st.pop();
        }

        public int top() {
            return st.peek().first;
        }

        public int getMin() {
            return st.peek().second;
        }
    }

}

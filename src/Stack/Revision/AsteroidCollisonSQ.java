package Stack.Revision;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class AsteroidCollisonSQ {
    class Solution {
        public int[] asteroidCollision(int[] asteroids) {
            Stack<Integer> st=new Stack<>();
            Queue<Integer> q=new LinkedList<>();
            for(int n : asteroids)
                q.add(n);
            while(!q.isEmpty()){
                if(st.isEmpty()||q.peek()>0||(st.peek()<0&&q.peek()<0))
                    st.push(q.poll());
                else{
                    if(Math.abs(st.peek())>Math.abs(q.peek()))
                        q.poll();
                    else if(Math.abs(st.peek())<Math.abs(q.peek()))
                        st.pop();
                    else
                    {
                        st.pop();
                        q.poll();
                    }

                }
            }
            Stack<Integer> st2=new Stack<>();
            while(!st.isEmpty()){
                st2.push(st.pop());
            }
            int res[]=new  int[st2.size()];
            int k=0;
            while(!st2.isEmpty())
            {
                res[k]=st2.pop();
                k++;
            }
            return res;
        }
    }
}

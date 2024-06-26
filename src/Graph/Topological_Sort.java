package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class Topological_Sort
{
    public static void main(String[] args) {

        class Solution
        {
            //Function to return list containing vertices in Topological order.
            public  void dfs(int node,boolean vis[],ArrayList<ArrayList<Integer>> adj,Stack<Integer> stack)
            {
                vis[node]=true;
                for(int adjNode: adj.get(node)){
                    if(!vis[adjNode])
                    {
                        dfs(adjNode,vis,adj,stack);
                    }
                }
                stack.push(node);
            }
            public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
            {
                // add your code here
                boolean vis[]=new boolean[V];
                Stack<Integer> stack=new Stack<>();
                for(int i=0;i<V;i++)
                {
                    if(!vis[i])
                    {
                        dfs(i,vis,adj,stack);
                    }
                }

                int ans[]=new int[V];
                int i=0;
                while(!stack.isEmpty())
                {
                    ans[i++]=stack.pop();
                }
                return ans;
            }


        }

    }
}

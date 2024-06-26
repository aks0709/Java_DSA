package Graph;

import java.util.ArrayList;

public class numProvinces
{
    static class Solution {
        static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
            // code here
            ArrayList<ArrayList<Integer>> adjLs=new ArrayList<ArrayList<Integer>>();
            for(int i=0;i<V;i++)
                adjLs.add(new ArrayList<>());

            //since we have given adjacency matrix we have to convert it to adjacency list
            for(int i=0;i<V;i++)
            {
                for(int j=0;j<V;j++)
                {
                    if(adj.get(i).get(j)==1&&i!=j)
                    {
                        adjLs.get(i).add(j);
                        adjLs.get(j).add(i);
                    }
                }
            }

            boolean vis[]=new boolean[V];
            int count=0;
            for(int v=0;v<V;v++)
            {
                if(!vis[v])
                {
                    count++;
                    DFS(v,vis,adjLs);
                }
            }
            return count;
        }

        public static void DFS(int v,boolean vis[],ArrayList<ArrayList<Integer>> adjLs)
        {
            vis[v]=true;
            for(int w: adjLs.get(v) )
            {
                if(!vis[w])
                {
                    DFS(w,vis,adjLs);
                }
            }
        }
    };
}

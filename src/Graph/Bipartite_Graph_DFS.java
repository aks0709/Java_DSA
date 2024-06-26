package Graph;

import java.util.ArrayList;

public class Bipartite_Graph_DFS
{
    public static void main(String[] args) {

    }
    class Solution
    {
        public boolean DFS(int src,int colour,int color[], ArrayList<ArrayList<Integer>>adj)
        {
            color[src]=colour;
            for(int adjNode:adj.get(src))
            {
                if(color[adjNode]==-1)
                {
                    if(DFS(adjNode,1-colour,color,adj)==false)
                        return false;
                }
                else if(color[adjNode]==color[src])
                    return false;
            }
            return true;
        }
        public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
        {
            // Code here
            int color[]=new int[V];
            for(int i=0;i<V;i++)
                color[i]=-1;

            for(int i=0;i<V;i++)
            {
                if(color[i]==-1)
                {
                    if(DFS(i,0,color,adj)==false)
                        return false;
                }
            }
            return true;
        }
    }
}

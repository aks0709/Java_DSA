package Graph;

import java.util.ArrayList;

public class DetectACycleDFS
{
    public static void main(String[] args) {

    }
    class Solution {
        // Function to detect cycle in an undirected graph.
        public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here
            boolean vis[]=new boolean[V];
            for(int v=0;v<V;v++)
            {
                if(!vis[v])
                {
                    if(isCycle(v,-1,adj,vis))//-1 is parent of source node
                        return true;
                }
            }

            return false;
        }

        public boolean isCycle(int v, int parent, ArrayList<ArrayList<Integer>> adj, boolean vis[])
        {
            vis[v]=true;
            for(int w:adj.get(v))
            {
                if(!vis[w])
                {
                    if(isCycle(w,v,adj,vis))
                        return true;
                }
                else if(w!=parent)
                    return true;
            }
            return false;//hence no cycle is detected with this source node
        }
    }
}

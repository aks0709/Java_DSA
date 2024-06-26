package Graph;

import java.util.ArrayList;

public class DetectACycleDirectedGraph
{

    class Solution {
        // Function to detect cycle in a directed graph.
        public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
            // code here
            boolean vis[]=new boolean[V];
            boolean pathVis[]=new boolean[V];
            for(int i=0;i<V;i++)
            {
                if(!vis[i])
                {
                    if(check(i,adj,vis,pathVis)==true)
                        return true;
                }
            }
            return false;
        }

        public boolean check(int node, ArrayList<ArrayList<Integer>> adj, boolean vis[], boolean pathVis[])
        {
            vis[node]=true;
            pathVis[node]=true;

            for(int adjNode:adj.get(node))
            {
                if(!vis[adjNode])
                {
                    if(check(adjNode,adj,vis,pathVis)==true)
                        return true;
                }
                else if(pathVis[adjNode]==true)
                    return true;
            }

            pathVis[node]=false; //backtrack
            return false;
        }
    }
}

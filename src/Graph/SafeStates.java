package Graph;

import java.util.ArrayList;
import java.util.List;

public class SafeStates
{

    class Solution {
        public boolean CycleCheck(int node,boolean vis[],int pathVis[],int check[],List<List<Integer>> adj)
        {
            vis[node]=true;
            pathVis[node]=1;
            check[node]=0; //initally zero
            for(int adjNode:adj.get(node))
            {
                if(!vis[adjNode])
                {
                    if(CycleCheck(adjNode,vis,pathVis,check,adj)==true)
                        return true;
                }
                else if(pathVis[adjNode]==1)
                {
                    return true;
                }
            }
            check[node]=1; //means no cycle exsist or not connected to cycle
            pathVis[node]=0;//backtrack
            return false;
        }
        List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

            // Your code here
            boolean vis[]=new boolean[V];
            int check[]=new int[V];
            int pathVis[]=new int [V];
            for(int i=0;i<V;i++)
            {
                if(!vis[i])
                {
                    CycleCheck(i,vis,pathVis,check,adj);
                }
            }

            List<Integer> safeNodes=new ArrayList<>();
            for(int i=0;i<V;i++)
            {
                if(check[i]==1)
                    safeNodes.add(i);
            }
            return safeNodes;
        }
    }

}

package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KHAN_ALGO
{
    class Solution
    {
        //Function to return list containing vertices in Topological order.
         int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
        {
            // add your code here
            int indegree[]= new int[V];
            for(int i=0;i<V;i++)
            {
                for(int node : adj.get(i))
                {
                    indegree[node]++;
                }
            }
            Queue<Integer> q=new LinkedList<>();
            for(int i=0;i<V;i++)
            {
                if(indegree[i]==0)
                    q.add(i);
            }

            int topo[]=new int[V];
            int i=0;
            while(!q.isEmpty())
            {
                int node=q.remove();
                topo[i++]=node;

                for(int adjNode: adj.get(node))
                {
                    indegree[adjNode]--;

                    if(indegree[adjNode]==0)
                        q.add(adjNode);
                }
            }

            return topo;
        }

    }

}

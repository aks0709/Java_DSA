package Graph;
import java.util.*;
public class DetectACycleUsingKhansAlgo
{
    public static void main(String[] args) {

        class Solution
        {
            //Function to return list containing vertices in Topological order.
            boolean topoSort(int V, ArrayList<ArrayList<Integer>> adj)
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

                if(topo.length==V)
                    return true;

                else return false;
            }

        }

    }
}

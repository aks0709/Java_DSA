package Graph;
import java.util.*;
public class SafeStatesUsingTopo
{

    class Solution {

        List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

            // Your code here
            List<List<Integer>> revAdj=new ArrayList<>();
            for(int i=0;i<V;i++)
            {
                revAdj.add(new ArrayList<>());
            }
            int indegree[]=new int[V];
            for(int i=0;i<V;i++)
            {
                for(int it: adj.get(i))
                {
                    revAdj.get(it).add(i);
                    indegree[i]++;
                }
            }
            Queue<Integer> q=new LinkedList<>();
            for(int i=0;i<V;i++)
            {
                if(indegree[i]==0)
                    q.add(i);
            }

            List<Integer> list=new ArrayList<>();

            while(!q.isEmpty())
            {
                int node=q.remove();
                list.add(node);

                for(int adjNode: revAdj.get(node))
                {
                    indegree[adjNode]--;

                    if(indegree[adjNode]==0)
                        q.add(adjNode);
                }
            }

            Collections.sort(list);
            return list;

        }
    }

}

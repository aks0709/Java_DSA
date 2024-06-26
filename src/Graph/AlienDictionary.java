package Graph;
import java.util.*;
public class AlienDictionary
{

    class Solution
    {
        ArrayList<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adj)
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
            ArrayList<Integer> list=new ArrayList<>();
            while(!q.isEmpty())
            {
                int node=q.remove();
                list.add(node);

                for(int adjNode: adj.get(node))
                {
                    indegree[adjNode]--;

                    if(indegree[adjNode]==0)
                        q.add(adjNode);
                }
            }

            return list;
        }
        public String findOrder(String [] dict, int N, int K)
        {
            // Write your code here
            ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
            for(int i=0;i<K;i++)
            {
                adj.add(new ArrayList<>());
            }
            for(int i=0;i<N-1;i++)
            {
                String str1=dict[i];
                String str2=dict[i+1];
                int len=Math.min(str1.length(),str2.length());
                for(int ptr=0;ptr<len;ptr++)
                {
                    if(str1.charAt(ptr)!=str2.charAt(ptr))
                    {
                        adj.get(str1.charAt(ptr)-'a').add(str2.charAt(ptr)-'a');
                        break;
                    }
                }
            }

            ArrayList<Integer> topo=topoSort(K,adj);
            String ans="";
            for(int it:topo)
            {
                ans=ans+(char)(it+(int)('a'));
            }
            return ans;
        }
    }
}

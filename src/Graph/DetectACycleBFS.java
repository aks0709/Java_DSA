package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectACycleBFS
{
    public static void main(String[] args) {

    }
    class Pair{
        int first;
        int second;
        public Pair(int first,int second)
        {
            this.first=first;
            this.second=second;
        }
    }

    class Solution {
        // Function to detect cycle in an undirected graph.
        public boolean CheckCycle(int source,ArrayList<ArrayList<Integer>> adj,boolean []vis)
        {
            vis[source]=true;
            Queue<Pair> q=new LinkedList<Pair>();
            q.add(new Pair(source,-1));
            while(!q.isEmpty())
            {
                int u=q.peek().first;
                int parent=q.peek().second;
                q.remove();
                for(int v: adj.get(u))
                {
                    if(!vis[v])
                    {
                        vis[v]=true;
                        q.add(new Pair(v,u));

                    }
                    else if(parent!=v)
                        return true;
                }
            }
            return false;
        }
        public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here
            boolean vis[]=new boolean[V];
            for(int v=0;v<V;v++)
            {
                if(!vis[v])
                {
                    if(CheckCycle(v,adj,vis))
                        return true;
                }
            }
            return false;
        }
    }

}

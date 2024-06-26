package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite_Graph_BFS {

    class Solution
    {
        public boolean check(int source,int[] color,ArrayList<ArrayList<Integer>>adj)
        {
            Queue<Integer> q=new LinkedList<>();
            q.add(source);
            color[source]=0;
            while(!q.isEmpty())
            {
                int node=q.peek();
                q.remove();

                for(int adjacenNode:adj.get(node))
                {
                    if(color[adjacenNode]==-1)//not coloured
                    {
                        color[adjacenNode]=1-color[node];
                        q.add(adjacenNode);
                    }
                    else if(color[adjacenNode]==color[node])  //it means adjacenNode is already
                    //coloured by some other path and have same colour as previous node
                    {
                        return false;
                    }
                }
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
                    if(check(i,color,adj)==false)
                        return false;
                }
            }
            return true;
        }
    }
}

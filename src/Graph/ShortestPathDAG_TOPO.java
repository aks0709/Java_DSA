package Graph;
import java.util.*;
public class ShortestPathDAG_TOPO
{
    class Pair //to make vertex and corresponding weights pair up
    {
        int first;  //for node
        int second;  //for weight
        public Pair(int first,int second)
        {
            this.first=first;
            this.second=second;
        }
    }
    class Solution {
        private void topoSort(int node, ArrayList < ArrayList < Pair >> adj,
                              int vis[], Stack < Integer > st) {
            //This is the function to implement Topological sort.

            vis[node] = 1;
            for (int i = 0; i < adj.get(node).size(); i++) {
                int v = adj.get(node).get(i).first;
                if (vis[v] == 0) {
                    topoSort(v, adj, vis, st);
                }
            }
            st.add(node);
        }

        public int[] shortestPath(int N,int M, int[][] edges) {
            //Code here
            ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
            for(int i=0;i<N;i++)
            {
                ArrayList<Pair> temp=new ArrayList<>();
                adj.add(temp);
            }
            //make adjacency list of graph
            for(int i=0;i<M;i++)
            {
                int u=edges[i][0];
                int v=edges[i][1];
                int wt=edges[i][2];
                adj.get(u).add(new Pair(v,wt));
            }
            int vis[]=new int[N];  //vis array fo topo sort
            Stack<Integer> stack=new Stack<>();//topo using DFS
            for(int i=0;i<N;i++)
            {
                if(vis[i]==0)
                {
                    topoSort(i,adj,vis,stack);
                }
            }

            //distancing part

            int dis[]=new int[N];
            for(int i=0;i<N;i++)
            {
                dis[i]=(int)(1e9);//Either  use Integer.MAX_VALUE or 1e9
                //1e9 does not throw exceptions or overflow error
                //1e9 is used becoz it is used by default in gfg
            }
            //distance of source vertex from source vertex is zero
            dis[0]=0;

            while(!stack.isEmpty())
            {
                int node=stack.pop();

                for(int i=0;i<adj.get(node).size();i++)
                {
                    int v=adj.get(node).get(i).first;
                    int wt=adj.get(node).get(i).second;

                    if(dis[node]+wt<dis[v])
                    {
                        dis[v]=dis[node]+wt;
                    }
                }
            }
            for (int i = 0; i < N; i++)
            {
                if (dis[i] == 1e9)
                    dis[i] = -1;

            }
            return dis;
        }
    }
}

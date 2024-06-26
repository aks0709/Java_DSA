package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijkstra_Algo
{
    class Pair{
        int node;
        int distance;
        public Pair(int distance,int node)
        {
            this.node=node;
            this.distance=distance;
        }
    }

    class Solution
    {
        //Function to find the shortest distance of all the vertices
        //from the source vertex S.
        int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
        {
            // Write your code here
            PriorityQueue<Pair> pq=new PriorityQueue<>((x, y)-> x.distance-y.distance);
            int dis[]=new int[V];
            for(int i=0;i<V;i++)
                dis[i]=(int)(1e9);

            dis[S]=0;
            pq.add(new Pair(0,S));

            while(pq.size()!=0)
            {
                int node=pq.peek().node;
                int dist=pq.peek().distance;
                pq.remove();

                for(int i=0;i<adj.get(node).size();i++)
                {
                    int adjNode=adj.get(node).get(i).get(0);
                    int edgeWeight=adj.get(node).get(i).get(1);

                    if(edgeWeight+dis[node]<dis[adjNode])
                    {
                        dis[adjNode]=dist+edgeWeight;
                        pq.add(new Pair(dis[adjNode],adjNode));
                    }
                }

            }

            return dis;
        }

    }


}

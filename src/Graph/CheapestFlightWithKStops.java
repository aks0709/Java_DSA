package Graph;
import java.util.*;
public class CheapestFlightWithKStops
{
    class tuple{
        int stops;
        int node;
        int cost;
        public tuple(int stops,int node,int cost)
        {
            this.stops=stops;
            this.node=node;
            this.cost=cost;
        }
    }
    class Pair{
        int distance;
        int node;
        public Pair(int distance,int node){
            this.distance=distance;
            this.node=node;
        }
    }
    class Solution {

        public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
            // Code here
            ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                adj.add(new ArrayList<>());
            }

            for(int i=0;i<flights.length;i++)
            {
                adj.get(flights[i][0]).add(new Pair(flights[i][2],flights[i][1]));
            }
            int dist[]=new int[n];
            for(int i=0;i<n;i++)
                dist[i]=(int)(1e9);

            dist[src]=0;

            //since there is no need fof priority queue because we have to check every path maybe w3e start on minimum
            //distance path but stops>k we use normal queue nd we judge on the basis of no of stops
            //algo become much faster because of not using priority queue hence extra log n of insertion and deletion is
            //avoided
            Queue<tuple> q=new LinkedList<>();
            q.add(new tuple(0,src,0));

            while(!q.isEmpty())
            {
                tuple tup=q.peek();
                q.remove();
                int node=tup.node;
                int cost=tup.cost;
                int stops=tup.stops;

                if(stops>k) continue;  //simply skip this iteration as stops exceed k

                for(Pair iter: adj.get(node)){
                    int adjNode=iter.node;
                    int edW=iter.distance;

                    if(cost+edW<dist[adjNode]&&stops<=k)
                    {
                        dist[adjNode]=cost+edW;
                        q.add(new tuple(stops+1,adjNode,dist[adjNode]));
                    }
                }
            }

            if(dist[dst]==1e9)
                return -1;

            return dist[dst];
        }
    }
}

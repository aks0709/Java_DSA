package Graph;

import java.util.Arrays;
import java.util.LinkedList;

public class GraphRepresentation
{

        int V;  //no of vertices
        int E;  //no of edges
        int adjMat[][];
        private LinkedList<Integer>[] adj;
        public GraphRepresentation(int size)
        {
            this.V=size;
            this.E=0;
           this.adjMat=new int [size][size];

           this.adj=new LinkedList[size];
           for (int v=0;v<V;v++)
               adj[v]=new LinkedList<>();
        }
        public void addEdge(int u,int v)
        {

            this.adjMat[u][v]=1;
            this.adjMat[v][u]=1;  //since it is undirected graph

            //adjLIst logic
            adj[v].add(u);
            adj[u].add(v);

            E++;  //no of edges increases
        }

        //to print adjList
        public String toString()
        {
            StringBuilder sb=new StringBuilder();
            sb.append(V+" vertices  "+E+" Edges\n");
            for (int v=0;v<V;v++)
            {
                sb.append(v+": ");
                for (int w: adj[v])
                {
                    sb.append(w+" ");
                }
                sb.append("\n");
            }
            return sb.toString();
        }

        // to print adjMAtrix
    /*public String toString()
    {
        StringBuilder sb=new StringBuilder();
        sb.append(V+" vertices  "+E+" Edges\n");
        for (int v=0;v<V;v++)
        {
            sb.append(v+": ");
            for (int w: adjMat[v])
            {
                sb.append(w+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }*/
        public static void main(String[] args) {
            GraphRepresentation g=new GraphRepresentation(4);
            g.addEdge(0,1);
            g.addEdge(2,3);
            g.addEdge(0,2);
            g.addEdge(3,1);
            g.addEdge(2,1);
            System.out.println(g);
        }
}

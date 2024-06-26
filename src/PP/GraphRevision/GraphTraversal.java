package PP.GraphRevision;

import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversal {
    int V;
    int E;
    private LinkedList<Integer> adj[];
    class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public void BFS(int source)//levelOrder Traversal
    {
        boolean vis[]=new boolean[V];
        Queue<Integer> q=new LinkedList<>();
        vis[source]=true;
        q.offer(source);
        while (!q.isEmpty())
        {
            int u=q.poll();
            System.out.print(u+" ");
            for (int v : adj[u]){
                if(!vis[v])
                {
                    vis[v]=true;
                    q.offer(v);
                }
            }
        }
    }
}

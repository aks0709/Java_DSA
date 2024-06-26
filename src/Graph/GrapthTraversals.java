package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GrapthTraversals {
    int V;
    int E;
    private LinkedList<Integer> adj[];

    public GrapthTraversals(int nodes)
    {
        this.V=nodes;
        this.E=0;
        this.adj=new LinkedList[nodes];

        for (int v=0;v<V;v++)
            adj[v]=new LinkedList<>();
    }
    public void AddEdge(int u,int v)
    {
        adj[v].add(u);
        adj[u].add(v);
        E++;
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

    public void DFS(int source)
    {
        boolean vis[]=new boolean[V];
        Stack<Integer> stack=new Stack<>();
        stack.push(source);
        while (!stack.isEmpty())
        {
            int u=stack.pop();
            if (!vis[u])
            {
                vis[u]=true;
                System.out.print(u+" ");
                for (int v:adj[u])
                {
                    if (!vis[v])
                        stack.push(v);
                }
            }
        }
    }

    public void DFS()
    {
        boolean vis[]=new boolean[V];
        for (int v=0;v<V;v++)
        {
            if(!vis[v])
            {
                DFS(v,vis);
            }
        }
    }
    public void DFS(int v,boolean [] vis)
    {
        vis[v]=true;
        System.out.print(v+" ");
        for (int w:adj[v])
        {
            if (!vis[w])
            {
                DFS(w,vis);
            }
        }
    }
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

    public static void main(String[] args) {

        GrapthTraversals g=new GrapthTraversals(8);
        g.AddEdge(0,1);
        g.AddEdge(0,2);
        g.AddEdge(1,3);
        g.AddEdge(1,4);
        g.AddEdge(2,5);
        g.AddEdge(2,6);
        g.AddEdge(3,7);
        g.AddEdge(4,7);
        g.AddEdge(5,7);
        g.AddEdge(6,7);

        g.BFS(0);
        //System.out.println(g);
        System.out.println();
        g.DFS(0);
        System.out.println();
        g.DFS();
    }

}

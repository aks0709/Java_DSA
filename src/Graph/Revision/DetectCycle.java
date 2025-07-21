package Graph.Revision;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair2{
    int node;
    int parent;
    public Pair2(int node,int parent){
        this.node=node;
        this.parent=parent;
    }
}
public class DetectCycle {
    public static void main(String[] args) {

    }
    //detect a cycle in graph using BFS
    public boolean isCycle(int V, List<Integer>[] adj) {
        int[] vis = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (bfs(i, adj, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bfs(int start, List<Integer>[] adj, int[] vis) {
        Queue<Pair2> q = new LinkedList<>();
        q.add(new Pair2(start, -1));
        vis[start] = 1;

        while (!q.isEmpty()) {
            Pair2 curr = q.poll();
            int node = curr.node;
            int parent = curr.parent;

            for (Integer neighbor : adj[node]) {
                if (vis[neighbor] == 0) {
                    vis[neighbor] = 1;
                    q.add(new Pair2(neighbor, node));  // ✅ correct parent
                } else if (neighbor != parent) {
                    return true;  // Cycle detected
                }
            }
        }
        return false;
    }

    public boolean isCycle2(int V, List<Integer>[] adj) {
        int[] vis = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                if (dfs(i, adj, vis,-1)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int node,List<Integer>[] adj, int[] vis,int parent){
        vis[node]=1;
        for(Integer it :adj[node]){
            if(vis[it]==0){
                if (dfs(it, adj, vis, node)) {  // ✅ check return value
                    return true;
                }
            } else if(it!=parent)
                return true;
        }
        return false;
    }
}

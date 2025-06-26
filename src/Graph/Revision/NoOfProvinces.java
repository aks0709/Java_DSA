package Graph.Revision;
import java.util.*;
public class NoOfProvinces {
    class Solution {
        public static void DFS(int node, ArrayList<ArrayList<Integer>> adj, int vis[]) {
            vis[node] = 1;
            for (Integer it : adj.get(node)) {
                if (vis[it] != 1) {
                    DFS(it, adj, vis);
                }
            }
        }

        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length; // 0-based matrix
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }

            // Build adjacency list from 0-based matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (isConnected[i][j] == 1 && i != j) {
                        adj.get(i).add(j);
                    }
                }
            }

            int vis[] = new int[n];
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (vis[i] == 0) {
                    count++;
                    DFS(i, adj, vis);
                }
            }

            return count;
        }
    }

}

package Graph.Revision;
import java.util.*;
public class DFS {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int vis[]=new int[adj.size()];
        for(int i=0;i<vis.length;i++){
            vis[i]=0;
        }
        vis[0]=1;
        ArrayList<Integer> res=new ArrayList<>();
        DFS(0,adj,vis,res);
        return res;
    }
    public static void DFS(int node,ArrayList<ArrayList<Integer>> adj,int vis[],ArrayList<Integer> res){
        vis[node]=1;
        res.add(node);
        for(Integer it : adj.get(node)){
            if(vis[it]!=1)
                DFS(it,adj,vis,res);
        }
    }
}

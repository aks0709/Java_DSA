package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CoursePlanner2
{
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int N=numCourses;
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                adj.add(new ArrayList<>());
            }
            int m=prerequisites.length;
            for (int i = 0; i < m; i++) {
                adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
            int indegree[]= new int[N];
            for(int i=0;i<N;i++)
            {
                for(int node : adj.get(i))
                {
                    indegree[node]++;
                }
            }
            Queue<Integer> q=new LinkedList<>();
            for(int i=0;i<N;i++)
            {
                if(indegree[i]==0)
                    q.add(i);
            }
            int topo[]=new int[N];
            int i=0;
            while(!q.isEmpty())
            {
                int node=q.remove();
                topo[i++]=node;

                for(int adjNode: adj.get(node))
                {
                    indegree[adjNode]--;

                    if(indegree[adjNode]==0)
                        q.add(adjNode);
                }
            }

            if(i==N)
                return topo;

            int arr[]={};
            return arr;
        }
    }
}

package Graph;
import java.util.*;
public class CoursePlanner1
{
    public static void main(String[] args) {

        class Solution {
            public boolean isPossible(int N, int[][] prerequisites)
            {
                // Your Code goes here
                ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
                for (int i = 0; i < N; i++) {
                    adj.add(new ArrayList<>());
                }
                int m=prerequisites.length;
                for (int i = 0; i < m; i++) {
                    adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
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
                int count=0;
                while(!q.isEmpty())
                {
                    int node=q.remove();
                    count++;

                    for(int adjNode: adj.get(node))
                    {
                        indegree[adjNode]--;

                        if(indegree[adjNode]==0)
                            q.add(adjNode);
                    }
                }

                if(count==N)
                    return true;

                else return false;
            }

        }
    }
}

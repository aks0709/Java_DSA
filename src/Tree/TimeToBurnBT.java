package Tree;

import com.sun.source.tree.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TimeToBurnBT
{
    public static void main(String[] args) {

    }
    //a function in which  we do BFS(Level order traversal) to map parents, node is value whereas child is key
    //this method also help us to find the target node in the whole tree structure

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode MapParent(TreeNode root, HashMap<TreeNode,TreeNode> map,int targetNodeVal)
    {
        Queue<TreeNode> q=new LinkedList<>();
        TreeNode target=null;
        q.offer(root);

        while (!q.isEmpty())
        {
            TreeNode node=q.poll();

            if (node.val==targetNodeVal)  target=node;  //here we get our target node which we are going to return
            if(node.left!=null)
            {
                map.put(node.left,node);
                q.offer(node.left);
            }

            if(node.right!=null)
            {
                map.put(node.right,node);
                q.offer(node.right);
            }
        }

        return target;

    }
    public static int findTime(HashMap<TreeNode,TreeNode> map,TreeNode targetNode)
    {
        //for each node we have three ways ,above,left child and right child
        //if any of them exsist and unvisted we add time ,if they are already visited then we didt consider them

        int time=0;
        //we need queue to tack nodes and do bfs
        //why bfs becoz we need to traverse level by level in order to calculate time
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(targetNode);

        //we create a hashmap which tell us if node is visited or not
        HashMap<TreeNode,Integer> vis=new HashMap<>();
        //put targetNode in visited map
        vis.put(targetNode,1); //marked as 1

        while (!q.isEmpty())
        {
            int size= q.size();
            int flag=0;
            //suppose we have to burn left and right  and parent and all these exited and are unvisited
            //so we need not to calculate seperately for each node instead we increase time by 1;
            //so whenever flag is 1 we increment time ,because that is the  utmost time we take to burn the tree

            for (int i=0;i< q.size();i++)
            {
                TreeNode node=q.poll();
                if (node.left!=null&&vis.get(node.left)==null)
                {
                    flag=1;
                    q.offer(node.left);
                    vis.put(node.left,1);
                }
                if(node.right!=null&&vis.get(node.right)==null)
                {
                    flag=1;
                    q.offer(node.right);
                    vis.put(node.right,1);
                }
                if(map.get(node)!=null&&vis.get(map.get(node))==null)  //we pass node as key in map to get parent
                                                                       //to check weather parent exsist and unvisited
                {
                    flag=1;
                    q.offer(map.get(node));
                    vis.put(map.get(node),1);
                }
            }

            if (flag==1)
                time++;

        }

        return time;
    }

    public static int timeToBurnTree(TreeNode root,int start)
    {
        HashMap<TreeNode,TreeNode> map=new HashMap<>();//use to map child and parent
        TreeNode targetNode=MapParent(root,map,start);
        int time=findTime(map,targetNode);

        return time;

    }
}

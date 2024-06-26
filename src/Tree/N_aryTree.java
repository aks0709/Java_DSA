package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N_aryTree
{
    public static void main(String[] args) {

    }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> ans=new LinkedList<>();
        PostTraversal(ans,root);
        return ans;
    }

    static void PostTraversal(List<Integer> ans,Node root)
    {
        if(root==null)
            return ;

        for(Node n : root.children)
        {
            PostTraversal(ans,n);
        }
        ans.add(root.val);
    }
    public List<List<Integer>> levelOrder(Node root) {
        Queue<Node> queue=new LinkedList<>();
        List<List<Integer>> res=new LinkedList<>();

        if(root==null)
            return res;

        queue.add(root);
        while(!queue.isEmpty())
        {
            int levelSize=queue.size();
            List<Integer> levelElement=new LinkedList<>();
            for(int i=0;i<levelSize;i++)
            {
                Node temp=queue.remove();
                levelElement.add(temp.val);

                for(Node n: temp.children)
                {
                    if(n!=null)
                        queue.add(n);
                }
            }
            res.add(levelElement);
        }
        return res;


    }

    public List<Integer> preorder(Node root) {
        List<Integer> ans=new LinkedList<>();
        PreTraversal(ans,root);
        return ans;
    }

    static void PreTraversal(List<Integer> ans,Node root)
    {
        if(root==null)
            return ;

        ans.add(root.val);
        for(Node n : root.children)
        {
            PreTraversal(ans,n);
        }

    }
}
